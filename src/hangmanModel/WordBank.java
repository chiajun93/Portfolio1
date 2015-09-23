package hangmanModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordBank {
	private String filePath;			//holds the filepath for the dictionary
	private ArrayList<String> words;	//holds the words of the dictionary
	
	/**
	 * Default constructor builds with default dictionary
	 */
	public WordBank(){
		this.filePath = "defaultDictionary.txt";
		this.words = new ArrayList<String>();
		
		//populate the dictionary
		loadDictionary();
	}
	
	
	/**
	 * Constructor builds with specified dictionary file
	 * @param fileName - Dictionary to be opened
	 */
	public WordBank(String fileName){
		this.filePath = fileName;
		this.words = new ArrayList<String>();
		
		//populate the dictionary
		loadDictionary();
	}
	
	/**
	 * Loads the dictionary from a txt file into memory
	 */
	private void loadDictionary(){
		try {
			Scanner wordFile = new Scanner(new File(filePath));
			while(wordFile.hasNext()){
				words.add(wordFile.next().toUpperCase());
			}
			wordFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the word at a given index
	 * @param index
	 * @return
	 */
	private String getWordAt(int index){
		return words.get(index);
	}
	
	/**
	 * Gets a word at a random index
	 * @return Single random word as String
	 */
	public String getRandomWord(){
		Random rand = new Random();
		return getWordAt(rand.nextInt(words.size()));
	}
	
	/**
	 * Gets the number of elements in the word bank
	 * @return Number of words as integer
	 */
	public int getNumOfWords(){
		return words.size();
	}
	
	/**
	 * Gets the entire list of words
	 * @return ArrayList with all words
	 */
	public ArrayList<String> getWordList(){
		return words;
	}
	
	public static void main(String[] args){
		WordBank bank = new WordBank();
		System.out.println(bank.getWordList());
		System.out.println(bank.getRandomWord());
		System.out.println(bank.getRandomWord());
		System.out.println(bank.getRandomWord());
		
	}
	
}
