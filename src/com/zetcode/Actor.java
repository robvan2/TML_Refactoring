package com.zetcode;

import javax.swing.*;
import java.awt.*;

public class Actor {

    private final int SPACE = 20;

    private int positionX;
    private int positionY;
    private Image image;

    public Actor(int positionX, int positionY) {
        
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int getPositionX() {
        
        return positionX;
    }

    public void setPositionX(int positionX) {

        this.positionX = positionX;
    }

    public int getPositionY() {

        return positionY;
    }

    public void setPositionY(int positionY) {
        
        this.positionY = positionY;
    }

    public boolean isLeftCollision(Actor actor) {
        
        return getPositionX() - SPACE == actor.getPositionX() && getPositionY() == actor.getPositionY();
    }

    public boolean isRightCollision(Actor actor) {
        
        return getPositionX() + SPACE == actor.getPositionX() && getPositionY() == actor.getPositionY();
    }

    public boolean isTopCollision(Actor actor) {
        
        return getPositionY() - SPACE == actor.getPositionY() && getPositionX() == actor.getPositionX();
    }

    public boolean isBottomCollision(Actor actor) {
        
        return getPositionY() + SPACE == actor.getPositionY() && getPositionX() == actor.getPositionX();
    }

    protected void initActor(String filename) {
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage();
        setImage(image);
    }
}
