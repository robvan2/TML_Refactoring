package com.zetcode;

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


    public void setType(int type){
        final int LEFT_COLLISION = 1;
        final int RIGHT_COLLISION = 2;
        final int TOP_COLLISION = 3;
        final int BOTTOM_COLLISION = 4;

        switch (type){
            case LEFT_COLLISION:
                this.type = new LeftCollision();break;
            case RIGHT_COLLISION:
                this.type = new RightCollision();break;
            case TOP_COLLISION:
                this.type = new TopCollision();break;
            case BOTTOM_COLLISION:
                this.type = new BottomCollision();break;
        }
    }
}
