package com.codegnan.cgecom.util;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs for password generation options
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include symbols? (yes/no): ");
        boolean includeSymbols = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        // Generate and display the password
        String generatedPassword = generatePassword(length, includeNumbers, includeSymbols, includeUppercase);
        System.out.println("Generated Password: " + generatedPassword);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeSymbols, boolean includeUppercase) {
        // Define character pools
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = includeUppercase ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "";
        String numbers = includeNumbers ? "0123456789" : "";
        String symbols = includeSymbols ? "!@#$%^&*()-_=+[]{}|;:',.<>?/" : "";

        // Combine all eligible characters
        String allChars = lower + upper + numbers + symbols;

        if (allChars.isEmpty()) {
            return "No valid characters to generate a password.";
        }

        // Use SecureRandom for secure random number generation
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Generate random password
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
