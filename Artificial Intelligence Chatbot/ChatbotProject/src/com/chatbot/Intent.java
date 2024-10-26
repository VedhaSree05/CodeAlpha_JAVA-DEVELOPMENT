package com.chatbot;

import java.util.ArrayList;
import java.util.List;

public class Intent {
    private String name;
    private List<String> keywords;
    private String response;

    public Intent(String name, String response) {
        this.name = name;
        this.response = response;
        this.keywords = new ArrayList<>();
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    public String getName() {
        return name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getResponse() {
        return response;
    }
}
