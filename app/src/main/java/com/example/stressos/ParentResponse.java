package com.example.stressos;

public class ParentResponse extends DefaultResponse {
    private String user_name;
    private String occupation;
    private String first_name;
    private String last_name;
    private String[] parent_ids;
    private String parent_id;

    public ParentResponse(boolean error, String message, String user_name, String occupation, String first_name, String last_name) {
        super(error, message);
        this.user_name = user_name;
        this.occupation = occupation;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public ParentResponse(boolean error, String message, String user_name, String occupation) {
        super(error, message);
        this.user_name = user_name;
        this.occupation = occupation;
    }

    public ParentResponse(boolean error, String message, String[] parent_ids) {
        super(error, message);
        this.parent_ids = parent_ids;
    }

    public ParentResponse(boolean error, String message, String parent_id) {
        super(error, message);
        this.parent_id = parent_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
