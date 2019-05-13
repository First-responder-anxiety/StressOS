package com.example.stressos.responses;

public class MultipleParentResponse extends DefaultResponse {
    String[] parent_names;
    MultipleParentResponse(boolean error, String message, String[] parent_names) {
        super(error, message);
        this.parent_names = parent_names;
    }

    public String[] getParent_names() {
        return parent_names;
    }
}
