package com.zetcode;

/**
 * Created by pc on 29/06/2019.
 */
public class MobileActor extends Actor {
    public MobileActor(int x, int y) {
        super(x, y);
    }

    public void move(int x, int y) {

        int dx = getPositionX() + x;
        int dy = getPositionY() + y;

        setPositionX(dx);
        setPositionY(dy);
    }
}
