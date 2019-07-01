package com.zetcode;

public class Player extends MobileActor {

    public Player(int x, int y) {
        super(x, y);
        initPlayer();
    }

    private void initPlayer() {
        String filename = "src/resources/sokoban.png";
        initActor(filename);
    }

}
