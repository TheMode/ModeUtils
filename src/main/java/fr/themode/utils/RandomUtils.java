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

    public static boolean chance(int min, int max, int value) {
        return value >= getRandomInteger(min, max);
    }

    public static boolean chance(float min, float max, float value) {
        return value >= getRandomFloat(min, max);
    }

    public String randomString(String characters, int length) {

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(RandomUtils.getRandomInteger(0, characters.length() - 1)));
        }

        return sb.toString();
    }

    public String randomString(int length) {
        return randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", length);
    }


}
