package com.zetcode;

import java.awt.event.KeyEvent;

/**
 * Created by pc on 29/06/2019.
 */
public class Collision {
    private CollisionType type;

    public Collision(){}

    public Collision(int type){
        setType(type);
    }


    public CollisionType getType() {
        return type;
    }


    public int[] setType(int type){
        int dx = 0;
        int dy = 0;
        int SPACE = 20;
        int[] dShift = new int[2];
        switch (type){
            case KeyEvent.VK_LEFT:
                this.type = new LeftCollision();
                dx-=SPACE;
                break;
            case KeyEvent.VK_RIGHT:
                this.type = new RightCollision();
                dx+=SPACE;
                break;
            case KeyEvent.VK_UP:
                this.type = new TopCollision();
                dy-=SPACE;
                break;
            case KeyEvent.VK_DOWN:
                this.type = new BottomCollision();
                dy+=SPACE;
                break;
        }
        dShift[0] = dx;
        dShift[1]=dy;
        return dShift;
    }
}
