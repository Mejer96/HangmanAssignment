package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateGuess {

    public static char userGuess(ArrayList<Character> array) {
        boolean loop = true;
        char guess = 0;

        while (loop) {
            guess = validateLength();
            if (validateCharacter(guess) && !checkForDuplicates(array, guess)) {
                loop = false;
            }
        }
        return guess;
    }

    private static char validateLength() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char stringToChar = 0;

        System.out.println("Please enter the letter you would like to try: ");
        while (loop) {

            System.out.print(">");
            String userInput = scanner.nextLine();

            if (userInput.length() > 1) {
                System.out.println("Error. Input cant be more than one character.");
            } else {
                stringToChar = userInput.charAt(0);
                loop = false;
            }
        }
        return stringToChar;
    }

    private static boolean validateCharacter(char userGuess) {
        String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] englishAlphabetToCharArray = englishAlphabet.toCharArray();
        boolean inputIsValid = false;

        for (int i = 0; i < englishAlphabetToCharArray.length; i++) {
            if (userGuess == englishAlphabetToCharArray[i]) {
                inputIsValid = true;
                break;
            } else if (i == englishAlphabetToCharArray.length-1) {
                System.out.println("Invalid input. Characters from the english alphabet only.");
            }
        }
        return inputIsValid;
    }

    private static boolean checkForDuplicates(ArrayList<Character> usedChars, char userInput) {
        boolean isADuplicate = false;

        for (int i = 0; i < usedChars.size(); i++) {
            int compareInputWithUsedChars = Character.compare(userInput, usedChars.get(i));
            if (compareInputWithUsedChars == 0) {
                System.out.println("U have already picked this character. Try again.");
                isADuplicate = true;
                break;
            }
        }
        return isADuplicate;
    }

}
