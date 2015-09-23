package hangmanModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangManModel {
	private WordBank wordBank;
	private ArrayList<String> lettersGuessed;
	private String goalWord;
	private int lettersRemaining;
	private int guessesRemaining;
	private String wordDisplayed;

	public HangManModel() {
		wordBank = new WordBank();
		lettersGuessed = new ArrayList<String>();
		goalWord = wordBank.getRandomWord();
		lettersRemaining = getNumUniqueLetters(goalWord);
		guessesRemaining = 11;
		wordDisplayed = initWordDisplay();
	}

	/**
	 * Sets a new goal word from the WordBank
	 */
	public void setNewGoalWord() {
		lettersGuessed = new ArrayList<String>();
		goalWord = wordBank.getRandomWord();
		lettersRemaining = getNumUniqueLetters(goalWord);
		guessesRemaining = 11;
		wordDisplayed = initWordDisplay();

	}

	public boolean hasWon() {
		if (lettersRemaining <= 0) {
			return true;
		}

		return false;
	}
	
	public boolean hasLost() {
		if (guessesRemaining <= 0) {
			return true;
		}

		return false;
	}

	/**
	 * Gets the word the player is trying to guess
	 * 
	 * @return Goal word as a string
	 */
	public String getGoalWord() {
		return goalWord;
	}

	/**
	 * Returns the length of the goal word
	 * 
	 * @return Goal word length as integer
	 */
	public int getGoalWordLength() {
		return goalWord.length();
	}

	/**
	 * Get total number of words in word bank
	 * 
	 * @return
	 */
	public int getWordsCount() {
		return wordBank.getNumOfWords();
	}

	/**
	 * Returns the number of unique letters in the string
	 * 
	 * @param word
	 *            - String value
	 * @return Integer value of unique character count
	 */
	public int getNumUniqueLetters(String word) {
		char characters[] = word.toCharArray();
		int uniqueCharCount = word.length();
		for (int i = 0; i < characters.length; i++) {
			if (i != word.indexOf(characters[i])) {
				uniqueCharCount--;
			}
		}
		return uniqueCharCount;
	}

	/**
	 * Get the number of guesses the player has left
	 * 
	 * @return
	 */
	public int getGuessesRemaining() {
		return guessesRemaining;
	}

	/**
	 * Get the number of letters remaining for the player to guess
	 * 
	 * @return
	 */
	public int getLettersRemaining() {
		return lettersRemaining;
	}

	/**
	 * Gets the list of letters that have been guessed
	 * 
	 * @return ArrayList of letters guessed
	 */
	public ArrayList<String> getLettersGuessed() {
		return lettersGuessed;
	}

	/**
	 * Gets the current display for the word being guessed
	 * 
	 * @return
	 */
	public String getWordDisplay() {
		return wordDisplayed;
	}

	/**
	 * Initializes the word displayed as underscores with spaces between them
	 * 
	 * @return
	 */
	private String initWordDisplay() {
		String disp = new String();
		for (int i = 0; i < goalWord.length(); i++) {
			disp += '_';
			disp += ' ';
		}

		return disp;
	}

	public void guessLetter(String guess) {
		if(guess == null || guess.length() == 0){
			return;
		}
		
		// make guess uppercase
		String uGuess = guess.toUpperCase();

		// add guess to the list of guesses
		if (lettersGuessed.contains(uGuess)) {
			return;
		}
		lettersGuessed.add(uGuess);
		boolean correctGuess = false;

		char[] disp = wordDisplayed.toCharArray();

		// loop through the goalWord and update guess values and display
		// accordingly
		for (int i = 0; i < goalWord.length(); i++) {
			// if the character equals the guess
			if (goalWord.charAt(i) == uGuess.charAt(0)) {
				// we had a correct guess
				correctGuess = true;

				// we have one less letter remaining
				lettersRemaining--;

				// update the wordDisplayed
				disp[i + i] = uGuess.charAt(0);
			}
		}

		if (correctGuess) {
			// put disp back to wordDisplayed
			String Sdisp = new String();
			for (int j = 0; j < wordDisplayed.length(); j++) {
				Sdisp += disp[j];
			}
			wordDisplayed = Sdisp;
		} else {
			// we we have one less attempt
			guessesRemaining--;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		HangManModel m = new HangManModel();
		System.out.println(m.getGoalWord());
		System.out.println(m.getNumUniqueLetters(m.getGoalWord()));
		System.out.println(m.getWordDisplay() + ", " + m.getGuessesRemaining() + ", " + m.getLettersRemaining());
		System.out.println(m.getLettersGuessed());
		m.guessLetter("e");
		System.out.println(m.getWordDisplay() + ", " + m.getGuessesRemaining() + ", " + m.getLettersRemaining());
		System.out.println(m.getLettersGuessed());
		m.guessLetter("s");
		System.out.println(m.getWordDisplay() + ", " + m.getGuessesRemaining() + ", " + m.getLettersRemaining());
		System.out.println(m.getLettersGuessed());

	}
}
