package com.zetcode;

/**
 * Created by pc on 29/06/2019.
 */
public class Level {
    private String map;
//    private final char wall ='#';
//    private final char area ='.';
//    private final char baggage ='$';
//    private final char space =' ';
//    private final char line ='\n';

    public Level() {
        map ="    ######\n"
                + "    ##   #\n"
                + "    ##$  #\n"
                + "  ####  $##\n"
                + "  ##  $ $ #\n"
                + "#### # ## #   ######\n"
                + "##   # ## #####  ..#\n"
                + "## $  $          ..#\n"
                + "###### ### #@##  ..#\n"
                + "    ##     #########\n"
                + "    ########\n";
    }

    public String getMap() {
        return map;
    }

    public int mapLength(){
        return map.length();
    }

}
