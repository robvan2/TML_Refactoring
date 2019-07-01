package com.zetcode;

import java.util.ArrayList;

/**
 * Created by pc on 29/06/2019.
 */
public abstract class CollisionType {
    final int SPACE = 20;
    public abstract boolean checkActorCollision(Actor actorInitial, Actor actorToCheckColisionWith);
    public abstract  void moveBag(Baggage baggage);

    public boolean checkCollision(Actor actorInitial, ArrayList<Actor> actors) {
        for (Actor actorTest : actors) {
            if (checkActorCollision(actorInitial,actorTest))
                return true;
        }
        return false;
    }
    public boolean checkBagCollision(Actor actorInitial, ArrayList<Baggage> baggages, ArrayList<Wall> walls) {
        for (Baggage baggage : baggages) {
            if (checkActorCollision(actorInitial,baggage)) {

                for (Baggage testBaggage : baggages) {

                    if (!baggage.equals(testBaggage)) {

                        if(checkActorCollision(baggage,testBaggage))
                            return true;
                    }
                }
                ArrayList<Actor> wallActors = new ArrayList<Actor>(walls);
                if (checkCollision(baggage,wallActors)) {
                    return true;
                }
                //fair bouger les bag de le sens correct (polymorphysm)
                moveBag(baggage);
            }
        }
        return false;
    }
}
class LeftCollision extends CollisionType{

    @Override
    public boolean checkActorCollision(Actor actorInitial, Actor actorToCheckColisionWith) {

        return actorInitial.isLeftCollision(actorToCheckColisionWith);
    }

    @Override
    public void moveBag(Baggage baggage) {
        baggage.move(-SPACE, 0);

    }
}
class RightCollision extends CollisionType{

    @Override
    public boolean checkActorCollision(Actor actorInitial, Actor actorToCheckColisionWith) {
        return actorInitial.isRightCollision(actorToCheckColisionWith);

    }

    @Override
    public void moveBag(Baggage baggage) {
        baggage.move(SPACE, 0);
    }
}
class TopCollision extends CollisionType{

    @Override
    public boolean checkActorCollision(Actor actorInitial, Actor actorToCheckColisionWith) {

        return actorInitial.isTopCollision(actorToCheckColisionWith);
    }

    @Override
    public void moveBag(Baggage baggage) {
        baggage.move(0, -SPACE);
    }
}
class BottomCollision extends CollisionType{

    @Override
    public boolean checkActorCollision(Actor actorInitial, Actor actorToCheckColisionWith) {
        return actorInitial.isBottomCollision(actorToCheckColisionWith);
    }

    @Override
    public void moveBag(Baggage baggage) {
        baggage.move(0, SPACE);

    }
}
