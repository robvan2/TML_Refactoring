package com.zetcode;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);
        
        initArea();
    }

    private void initArea() {
        String filename = "src/resources/area.png";
        initActor(filename);
    }

}
