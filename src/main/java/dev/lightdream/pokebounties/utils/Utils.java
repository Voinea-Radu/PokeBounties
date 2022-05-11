package dev.lightdream.pokebounties.utils;

import java.util.Random;

public class Utils {

    public static int generateRandom(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

}
