package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        boolean whileLoop = true;

        ArrayList<Character> usedWords = new ArrayList<>();
        char[] generatedWord = GenerateWord.generateWord(GameMenu.selectDifficulty());
        char[] printGameProgress = GameMenu.printProgress(generatedWord);
        boolean loop = true;
        int counter = 0;
        int score = 0;

        while (loop) {
            System.out.println(printGameProgress);
            char userGuess = ValidateGuess.userGuess(usedWords);
            usedWords.add(userGuess);
            boolean matchIsFound = false;
            for (int i = 0; i < generatedWord.length; i++) {
                if (generatedWord[i] == userGuess) {
                    printGameProgress[i] = userGuess;
                    score++;
                    matchIsFound = true;
                }
            }
            if (!matchIsFound) {
                counter++;
                int guessesLeft = 6 - counter;
                System.out.println("Wrong guess. Try again. You have " + guessesLeft + " guesses left.");
            }
            if (score == generatedWord.length) {
                System.out.println("Congrats! You guessed the word!");
                loop = false;
            } else if (counter == 6) {
                System.out.println("You failed to guess the word. GAME OVER!");
                loop = false;
            }
        }
    }
}
