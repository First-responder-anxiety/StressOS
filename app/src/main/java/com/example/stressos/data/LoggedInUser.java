package com.example.stressos.data;

public class LoggedInUser {
    private static String userName;
    private static String parent_day_start;
    private static String parent_day_length;
    private static String parent_night_start;
    private static String parent_night_length;

    public static void setUserName(String userName) {
        LoggedInUser.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getParent_day_start() {
        return parent_day_start;
    }

    public static void setParent_day_start(String parent_day_start) {
        LoggedInUser.parent_day_start = parent_day_start;
    }

    public static String getParent_day_length() {
        return parent_day_length;
    }

    public static void setParent_day_length(String parent_day_length) {
        LoggedInUser.parent_day_length = parent_day_length;
    }

    public static String getParent_night_start() {
        return parent_night_start;
    }

    public static void setParent_night_start(String parent_night_start) {
        LoggedInUser.parent_night_start = parent_night_start;
    }

    public static String getParent_night_length() {
        return parent_night_length;
    }

    public static void setParent_night_length(String parent_night_length) {
        LoggedInUser.parent_night_length = parent_night_length;
    }
}
