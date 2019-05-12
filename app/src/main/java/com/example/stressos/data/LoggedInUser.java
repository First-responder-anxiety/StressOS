package com.example.stressos.data;

public class LoggedInUser {
    private static String userName;

    public static void setUserName(String userName) {
        LoggedInUser.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }
}
