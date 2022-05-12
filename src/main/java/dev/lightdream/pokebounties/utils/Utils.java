package dev.lightdream.pokebounties.utils;

import dev.lightdream.logger.Debugger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static int generateRandom(int low, int high) {
        Debugger.log("Generating random number between " + low + " and " + high);
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public static LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    public static String getDateString() {
        return getDate().format(formatter);
    }

}
