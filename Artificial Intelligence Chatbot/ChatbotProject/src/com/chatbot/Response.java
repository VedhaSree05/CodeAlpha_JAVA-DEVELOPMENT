package com.chatbot;

public class Response {
    private String intent;
    private String response;

    public Response(String intent, String response) {
        this.intent = intent;
        this.response = response;
    }

    public String getIntent() {
        return intent;
    }

    public String getResponse() {
        return response;
    }
}
