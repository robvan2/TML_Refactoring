package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel {

    private final int SPACE = 20;

    private ArrayList<Wall> walls;
    private ArrayList<Baggage> baggages;
    private ArrayList<Area> areas;
    
    private Player sokoPlayer;
    private int boardWidth = 0;
    private int boardHeight = 0;

    private boolean isCompleted = false;

    Board() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    int getBoardWidth() {
        return this.boardWidth;
    }

    int getBoardHeight() {
        return this.boardHeight;
    }

    private void initWorld() {
        
        walls = new ArrayList<>();
        baggages = new ArrayList<>();
        areas = new ArrayList<>();

        int OFFSET = 30;
        int positionX = OFFSET;
        int positionY = OFFSET;

        Wall wall;
        Baggage baggage;
        Area area;

        //changer le level ici
        Level level = new Level(1) ;

        for (int i = 0; i < level.mapLength(); i++) {
            //caractere sur la ieme position
            char item = level.getMap().charAt(i);

            //selon le charactere on initialise la place
            switch (item) {

                case '\n':
                    positionY += SPACE;
                    if (this.boardWidth < positionX) {
                        this.boardWidth = positionX;
                    }
                    positionX = OFFSET;
                    break;

                case '#':
                    wall = new Wall(positionX, positionY);
                    walls.add(wall);
                    positionX += SPACE;
                    break;

                case '$':
                    baggage = new Baggage(positionX, positionY);
                    baggages.add(baggage);
                    positionX += SPACE;
                    break;

                case '.':
                    area = new Area(positionX, positionY);
                    areas.add(area);
                    positionX += SPACE;
                    break;

                case '@':
                    sokoPlayer = new Player(positionX, positionY);
                    positionX += SPACE;
                    break;

                case ' ':
                    positionX += SPACE;
                    break;

                default:
                    break;
            }

            boardHeight = positionY;
        }
    }

    private void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<Actor> world = new ArrayList<>();

        world.addAll(walls);
        world.addAll(areas);
        world.addAll(baggages);
        world.add(sokoPlayer);

        for (Actor actor : world) {

            int actorPositionX = actor.getPositionX();
            int actorPositionY = actor.getPositionY();

            if (actor instanceof MobileActor) {
                actorPositionX += 2;
                actorPositionY += 2;
            }
            g.drawImage(actor.getImage(), actorPositionX, actorPositionY, this);

            if (isCompleted) {

                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }

    private void isCompleted() {

        int nOfBags = baggages.size();
        int finishedBags = 0;

        for (Baggage bag : baggages) {

            for (int j = 0; j < nOfBags; j++) {

                Area area = areas.get(j);

                if (bag.getPositionX() == area.getPositionX() && bag.getPositionY() == area.getPositionY()) {
                    finishedBags += 1;
                }
            }
        }

        if (finishedBags == nOfBags) {

            isCompleted = true;
            repaint();
        }
    }

    private void restartLevel() {

        areas.clear();
        baggages.clear();
        walls.clear();

        initWorld();
        repaint();

        if (isCompleted) {
            isCompleted = false;
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            Collision collision = new Collision();

            if (isCompleted) {
                return;
            }
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_R){
                    restartLevel();
            }else {
                int[] dShift = collision.setType(key);
                ArrayList<Actor> wallActors = new ArrayList<Actor>(walls);
                if (collision.getType().checkCollision(sokoPlayer,
                        wallActors)) {
                    return;
                }

                if (collision.getType().checkBagCollision(sokoPlayer, baggages, walls)) {
                    return;
                }
                int dx = dShift[0];
                int dy = dShift[1];
                sokoPlayer.move(dx, dy);
                isCompleted();
                repaint();
            }
        }
    }
}
