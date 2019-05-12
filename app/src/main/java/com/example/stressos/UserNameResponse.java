package com.example.stressos;

/**
 * The response from a POST request
 */
public class UserNameResponse extends DefaultResponse {
    private String userName;

    public UserNameResponse(boolean error, String message, String userName) {
        super(error, message);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
