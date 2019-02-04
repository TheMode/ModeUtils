package fr.themode.utils;

public class Validate {

    public static void condition(boolean check, String message) {
        if (!check)
            throw new IllegalArgumentException(message);
    }

    public static void requireNonNull(Object object, String message) {
        if (object == null)
            throw new NullPointerException(message);
    }

}
