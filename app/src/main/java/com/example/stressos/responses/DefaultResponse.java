package com.example.stressos.responses;

public class DefaultResponse {
    private boolean error;
    private String message;

    DefaultResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
