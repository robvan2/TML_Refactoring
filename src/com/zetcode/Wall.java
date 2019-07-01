package com.zetcode;

public class Wall extends Actor {

    public Wall(int x, int y) {
        super(x, y);
        initWall();
    }
    private void initWall() {
        String filename = "src/resources/wall.png";
        initActor(filename);
    }

}
