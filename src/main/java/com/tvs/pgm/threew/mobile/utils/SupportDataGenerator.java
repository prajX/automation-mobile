package com.tvs.pgm.threew.mobile.utils;

import java.util.Random;

public class SupportDataGenerator {
    private static final Random RANDOM = new Random();

    private static final String[] TITLES = {
        "Issue with app login", "Payment failure problem", "Unable to upload documents",
        "Bug in profile update", "Feature request for dark mode", "App crashes on start",
        "Slow response in support chat", "Error while processing order"
    };

    private static final String[] DESCRIPTIONS = {
        "I am facing an issue while logging into the app. It keeps showing an invalid credentials error even when I enter the correct details. Please assist.",
        "My payment got deducted but the order was not placed. Kindly check and resolve this at the earliest.",
        "I am trying to upload my verification documents, but the upload button is not responding. Please guide me on how to proceed.",
        "Whenever I update my profile information and save changes, they do not reflect after reopening the app.",
        "It would be great if you could introduce a dark mode option in the app for better readability at night.",
        "The app keeps crashing whenever I try to open it on my Android device. I have already cleared cache but the issue persists.",
        "The support chat takes too long to respond. It sometimes freezes, making it difficult to communicate with the support team.",
        "I am receiving an error message while trying to complete my order. The app is not letting me proceed with the payment."
    };

    private static final String[] FIRST_NAMES = {
        "John", "Emma", "Michael", "Sophia", "James", "Olivia", "William", "Ava", "Alexander", "Isabella"
    };
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Brown", "Williams", "Jones", "Miller", "Davis", "Garcia", "Martinez", "Taylor"
    };

    public static String generateRandomTitle() {
        return TITLES[RANDOM.nextInt(TITLES.length)];
    }

    public static String generateRandomDescription() {
        return DESCRIPTIONS[RANDOM.nextInt(DESCRIPTIONS.length)];
    }

    public static String generateRandomCustomerName() {
        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    public static String generateRandomContactNumber() {
        StringBuilder phoneNumber = new StringBuilder("9"); // Ensuring it starts with '9' for validity
        for (int i = 1; i < 10; i++) {
            phoneNumber.append(RANDOM.nextInt(10)); // Append random digits (0-9)
        }
        return phoneNumber.toString();
    }
}
