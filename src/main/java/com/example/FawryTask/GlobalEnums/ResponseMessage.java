package com.example.FawryTask.GlobalEnums;

public enum ResponseMessage {

    Succesful_Request("Succesful request"),
    Developer_Message("Successfull Call For Api"),

    ;

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageByUsername(String username) {
        return message.replace("User", username);
    }
    public String getMessageByApi(String api) {
        return message.replace("Api", api);
    }
}
