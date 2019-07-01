package com.zetcode;

public class Baggage extends MobileActor {

    public Baggage(int x, int y) {
        super(x, y);
        initBaggage();
    }

    private void initBaggage() {

        String filename = "src/resources/baggage.png";
       initActor(filename);
    }

}
