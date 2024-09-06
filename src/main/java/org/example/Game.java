package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {

    // List of words to guess from
    private static final String[] WORDS = {"apple", "banana", "grape", "orange", "mango", "pineapple"};
    private static final int MAX_ATTEMPTS = 6; // Maximum attempts before losing the game

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }

    public void playGame() {
        String wordToGuess = selectRandomWord();       // Select a random word
        String hiddenWord = hideWord(wordToGuess);     // Create the hidden version of the word
        int attemptsLeft = MAX_ATTEMPTS;               // Initialize attempts
        boolean wordGuessed = false;

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Try to guess the word:");
        System.out.println(hiddenWord);

        while (attemptsLeft > 0 && !wordGuessed) {
            char playerGuess = getPlayerGuess();       // Get player's guess
            if (isGuessCorrect(wordToGuess, playerGuess)) {
                hiddenWord = updateHiddenWord(wordToGuess, hiddenWord, playerGuess);  // Reveal correctly guessed letter
            } else {
                attemptsLeft--;                        // Deduct an attempt if guess is incorrect
                System.out.println("Wrong guess! Attempts left: " + attemptsLeft);
            }
            System.out.println(hiddenWord);
            if (!hiddenWord.contains("_")) {           // Check if word is completely guessed
                wordGuessed = true;
            }
        }

        displayGameResult(wordToGuess, hiddenWord, attemptsLeft);
    }

    // Selects and returns a random word from the WORDS array
    public String selectRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    // Returns a string of underscores with the same length as the input word
    public String hideWord(String word) {
        return "_".repeat(word.length());
    }

    // Prompts the player for a guess and returns the guessed character
    public char getPlayerGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (a single letter): ");
        return scanner.next().charAt(0);
    }

    // Checks if the guessed character is in the word and returns a boolean result
    public boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }

    // Updates the hidden word by revealing the correctly guessed character and returns the new hidden word
    public String updateHiddenWord(String word, String hiddenWord, char guess) {
        StringBuilder updatedWord = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedWord.setCharAt(i, guess);       // Reveal the correct character
            }
        }
        return updatedWord.toString();
    }

    // Displays the final game result, including whether the player won or lost
    public void displayGameResult(String wordToGuess, String hiddenWord, int attemptsLeft) {
        if (hiddenWord.equals(wordToGuess)) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("You've run out of attempts! The word was: " + wordToGuess);
        }
    }
}
