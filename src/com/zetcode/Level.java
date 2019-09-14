package com.zetcode;

/**
 * Created by pc on 29/06/2019.
 */
public class Level {
    private String map;

    //en peur creer une table 'BDD' qui contien tout les level puis fais un query avec l ID du niveau 'map'
    public Level(int map) {
        if (map == 1){
            this.map ="    ######\n"
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
        }else{
            this.map = "  #####\n"
                    +     "###   #\n"
                    +     "#.@$  #\n"
                    +     "### $.#\n"
                    +     "#.##$ #\n"
                    +     "# # . ##\n"
                    +     "#$ $$$.#\n"
                    +     "#  ..  #\n"
                    +     "########\n";
        }
    }

    public String getMap() {
        return map;
    }

    public int mapLength(){
        return map.length();
    }

}
