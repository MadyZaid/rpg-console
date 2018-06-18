package in.ramakant.rpg.common.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerUtils {

    private RandomIntegerUtils() {
    }

    public static int getRandomIntInclusive(int maxInclusive) {
        return getRandomIntInclusive(0, maxInclusive);
    }

    public static int getRandomIntInclusive(int minInclusive, int maxInclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxInclusive + 1);
    }

    public static int getRandomIntExclusive(int maxExclusive) {
        return getRandomIntExclusive(0, maxExclusive);
    }

    public static int getRandomIntExclusive(int minInclusive, int maxExclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxExclusive);
    }

    public static boolean isNotBetweenZeroAndMaxExclusive(int num, int maxExclusive) {
        return !isBetweenZeroAndMaxExclusive(num, maxExclusive);
    }

    public static boolean isBetweenZeroAndMaxExclusive(int num, int maxExclusive) {
        return isWithinRangeExclusive(num, 0, maxExclusive);
    }

    public static boolean isWithinRangeExclusive(int num, int minInclusive, int maxExclusive) {
        return num >= minInclusive && num < maxExclusive;
    }
}
