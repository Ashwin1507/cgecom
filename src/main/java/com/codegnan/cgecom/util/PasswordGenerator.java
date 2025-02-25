package com.codegnan.cgecom.util;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include symbols? (yes/no): ");
        boolean includeSymbols = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Generated Password: " + generatePassword(length, includeNumbers, includeSymbols, includeUppercase));
        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeSymbols, boolean includeUppercase) {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = includeUppercase ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "";
        String numbers = includeNumbers ? "0123456789" : "";
        String symbols = includeSymbols ? "!@#$%^&*()-_=+[]{}|;:',.<>?/" : "";

        String allChars = lower + upper + numbers + symbols;
        if (allChars.isEmpty()) {
            return "No valid characters to generate a password.";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }
}

