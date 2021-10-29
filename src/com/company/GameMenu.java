package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {

    public static int selectDifficulty() {

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int userInput = 0;

        System.out.println("Please select difficulty: \n1 - Easy.\n2 - Hard.");

        while (loop) {
            System.out.print(">");
            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input must be a number.");
                scanner.next();
                continue;
            }
            if (userInput == 1 || userInput == 2) {
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return userInput;
    }

    public static char[] printProgress(char[] generatedWord) {
        char[] arrayToPrint = new char[generatedWord.length];

        for (int i = 0; i < generatedWord.length; i++) {
            arrayToPrint[i] = '_';
        }
        return arrayToPrint;
    }
}




