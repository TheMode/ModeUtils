package fr.themode.utils;

public class NumberUtils {

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
