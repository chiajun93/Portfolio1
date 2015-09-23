package portfolio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used for reading and creating the dictonary of words
 * @author Charlie
 *
 */
public class Dictionary {

	private String filePath;		//holds the filepath for the dictionary
	private ArrayList words;		//holds the words of the dictionary
	
	//default constructor builds with default dictionary
	public Dictionary(){
		this.filePath = "defaultDictionary.txt";
	}
	
	//constructor builds with specified dictionary file
	public Dictionary(String fileName){
		this.filePath = fileName;
	}
	
	/**
	 * Loads the dictionary from a txt file into memory
	 */
	private void loadDictionary(){
		
	}
	
	/**
	 * Gets the word at a given index
	 * @param index
	 * @return
	 */
	public String getWordAt(int index){
		return "foundWord";
	}
	
	/**
	 * Gets a word at a random index
	 * @return
	 */
	public String getRandomWord(){
		
		return getWordAt(5);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
