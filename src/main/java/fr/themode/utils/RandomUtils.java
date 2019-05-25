package fr.themode.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInteger(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static double getRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble() * (max - min) + min;
    }

    public static float getRandomFloat(float min, float max) {
        return ThreadLocalRandom.current().nextFloat() * (max - min) + min;
    }

    public static boolean chance(float value) {
        value = MathUtils.minMax(value, 0, 1);
        return value >= getRandomFloat(0, 1);
    }

    public static String randomString(String characters, int length) {

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(RandomUtils.getRandomInteger(0, characters.length() - 1)));
        }

        return sb.toString();
    }

    public static String randomString(int length) {
        return randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", length);
    }


}
