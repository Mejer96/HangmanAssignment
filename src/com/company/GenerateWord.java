package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateWord {

    public static char[] generateWord(int difficulty) {
        int easy = 1;
        int hard = 2;
        ArrayList<String> wordsFromFile = new ArrayList<>();

        if (difficulty == easy) {
            wordsFromFile = createListEasy(readFile());
        } else if (difficulty == hard) {
            wordsFromFile = createListHard(readFile());
        }
        return randomWord(wordsFromFile);
    }



    private static ArrayList<String> readFile() {
        File readFile = new File("Words");
        ArrayList<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(readFile);
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return words;
    }

    private static ArrayList<String> createListHard(ArrayList<String> words) {
        ArrayList<String> wordsHard = new ArrayList<>();
        int wordDifficultyHard = 6;

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() >= wordDifficultyHard) {
                wordsHard.add(words.get(i));
            }
        }
        return wordsHard;
    }

    private static ArrayList<String> createListEasy(ArrayList<String> words) {
        ArrayList<String> wordsEasy = new ArrayList<>();
        int wordDifficultyEasy = 5;

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() <= wordDifficultyEasy) {
                wordsEasy.add(words.get(i));
            }
        }
        return wordsEasy;
    }


    private static char[] randomWord(ArrayList<String> words) {
        Random random = new Random();
        String randomWord = words.get(random.nextInt(words.size()));

        return randomWord.toCharArray();
    }
}

