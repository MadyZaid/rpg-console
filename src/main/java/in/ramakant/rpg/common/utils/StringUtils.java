package in.ramakant.rpg.common.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String key) {
        return null == key || key.trim().length() == 0;
    }

}
