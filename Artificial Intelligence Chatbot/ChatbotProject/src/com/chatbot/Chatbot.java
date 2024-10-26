package com.chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chatbot {
    private List<Intent> intents;

    public Chatbot() {
        intents = new ArrayList<>();
        loadIntents(); // Load predefined intents
    }

    private void loadIntents() {
        Intent greetingIntent = new Intent("greeting", "Hello! How can I assist you today?");
        greetingIntent.addKeyword("hi");
        greetingIntent.addKeyword("hello");
        greetingIntent.addKeyword("hey");
        intents.add(greetingIntent);

        Intent farewellIntent = new Intent("farewell", "Goodbye! Have a great day!");
        farewellIntent.addKeyword("bye");
        farewellIntent.addKeyword("goodbye");
        farewellIntent.addKeyword("see you");
        intents.add(farewellIntent);

        Intent helpIntent = new Intent("help", "I can assist you with various queries. Please ask!");
        helpIntent.addKeyword("help");
        helpIntent.addKeyword("support");
        intents.add(helpIntent);
    }

    public String getResponse(String userInput) {
        for (Intent intent : intents) {
            for (String keyword : intent.getKeywords()) {
                if (userInput.toLowerCase().contains(keyword)) {
                    return intent.getResponse();
                }
            }
        }
        return "I'm sorry, I don't understand that.";
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chatbot: Hello! Type 'exit' to end the chat.");
        String userInput;
        do {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            if (!userInput.equalsIgnoreCase("exit")) {
                String response = getResponse(userInput);
                System.out.println("Chatbot: " + response);
            }
        } while (!userInput.equalsIgnoreCase("exit"));
        scanner.close();
    }

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.startChat();
    }
}
