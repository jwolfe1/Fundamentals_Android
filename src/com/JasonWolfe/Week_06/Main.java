package com.JasonWolfe.Week_06;

import java.util.Scanner;

class UserInput {
    Scanner scanner = new Scanner(System.in);

    public int promptInt(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        int userInt = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;
            }
            catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid int. " + message);
                userInput = scanner.nextLine();
            }
        }

        return userInt;
    }

    public double promptDouble(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        double userDouble = 0;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                userDouble = Double.parseDouble(userInput);
                isDouble = true;
            }
            catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid double. " + message);
                userInput = scanner.nextLine();
            }
        }

        return userDouble;
    }

    public String promptString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}

public class Main {

    public static void main(String[] args) {
        UserInput input = new UserInput();
        int userInt = input.promptInt("Enter an int");
        double userDouble = input.promptDouble("Enter a double");
        String userString = input.promptString("Enter a string");
        System.out.println("The int that you have entered is " + userInt);
        System.out.println("The double that you have entered is " + userDouble);
        System.out.println("The string that you have entered is " + userString);
    }
}
