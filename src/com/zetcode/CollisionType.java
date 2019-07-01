package com.zetcode;

import java.util.ArrayList;

/**
 * Created by pc on 29/06/2019.
 */
public abstract class CollisionType {
    final int SPACE = 20;
    public abstract boolean checkWallCollision(Actor actorInitial, ArrayList<Wall> walls);
    public abstract boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls);
}
class LeftCollision extends CollisionType{

    @Override
    public boolean checkWallCollision(Actor actorInitial, ArrayList<Wall> walls) {
        for (Wall wall : walls) {

            if (actorInitial.isLeftCollision(wall)) {

                return true;
            }
        }
        return false;    }

    @Override
    public boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls) {
        for (Baggage baggage : baggages) {
            if (actorInitial.isLeftCollision(baggage)) {

                for (Baggage testBaggage : baggages) {

                    if (!baggage.equals(testBaggage)) {

                        if (baggage.isLeftCollision(testBaggage)) {
                            return true;
                        }
                    }

                    if (checkWallCollision(baggage,walls)) {
                        return true;
                    }
                }

                baggage.move(-SPACE, 0);
            }
        }
        return false;        }
}
class RightCollision extends CollisionType{

    @Override
    public boolean checkWallCollision(Actor actorInitial, ArrayList<Wall> walls) {
        for (Wall wall : walls) {

            if (actorInitial.isRightCollision(wall)) {

                return true;
            }
        }
        return false;    }

    @Override
    public boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls) {
        for (Baggage baggage : baggages) {
            if (actorInitial.isRightCollision(baggage)) {

                for (Baggage testBaggage : baggages) {

                    if (!baggage.equals(testBaggage)) {

                        if (baggage.isRightCollision(testBaggage)) {
                            return true;
                        }
                    }

                    if (checkWallCollision(baggage,walls)) {
                        return true;
                    }
                }

                baggage.move(SPACE, 0);
            }
        }
        return false;    }
}
class TopCollision extends CollisionType{

    @Override
    public boolean checkWallCollision(Actor actorInitial, ArrayList<Wall> walls) {
        for (Wall wall : walls) {

            if (actorInitial.isTopCollision(wall)) {

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls) {
        for (Baggage bag : baggages) {
            if (actorInitial.isTopCollision(bag)) {

                for (Baggage item : baggages) {

                    if (!bag.equals(item)) {

                        if (bag.isTopCollision(item)) {
                            return true;
                        }
                    }

                    if (checkWallCollision(bag,walls)) {
                        return true;
                    }
                }

                bag.move(0, -SPACE);
            }
        }
        return false;
    }
}
class BottomCollision extends CollisionType{

    @Override
    public boolean checkWallCollision(Actor actorInitial, ArrayList<Wall> walls) {
        for (Wall wall : walls) {

            if (actorInitial.isBottomCollision(wall)) {

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls) {
        for (Baggage baggage : baggages) {
            if (actorInitial.isBottomCollision(baggage)) {

                for (Baggage testBaggage : baggages) {

                    if (!baggage.equals(testBaggage)) {

                        if (baggage.isBottomCollision(testBaggage)) {
                            return true;
                        }
                    }

                    if (checkWallCollision(baggage,walls)) {
                        return true;
                    }
                }

                baggage.move(0, SPACE);
            }
        }
        return false;
    }
}
