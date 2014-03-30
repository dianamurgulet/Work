package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DictionaryMapImpl implements Dictionary {
	private HashMap<String,Set<String>> table = new HashMap<String,Set<String>>();
	
	/** 
	 * reads the dictionary and adds the values to the map
	 * 
	 * */
	public DictionaryMapImpl(){
		
		BufferedReader dictionaryReader;
		try {
			 dictionaryReader = new BufferedReader(new
			 FileReader("/usr/share/dict/words")); //code for commandline
			//dictionaryReader = new BufferedReader(new FileReader("words"));
			String scurrent = dictionaryReader.readLine();
			while (scurrent != null)// until the end of the dictionary file has
									// not been reached
			{
				if (isValidWord(scurrent)) {
					String signature = wordToSignature(scurrent);
					if(table.get(signature)==null)
					{
						Set<String> words = new HashSet<String>();
						words.add(scurrent);
						table.put(signature, words);	
					}
					else
					{
						Set<String> words = table.get(signature);
						words.add(scurrent);
						table.put(signature, words);	
					}
				}
				scurrent = dictionaryReader.readLine();

			}
			
			dictionaryReader.close();// closes the file that contains the
										// dictionary
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}// opens the file that contains the dictionary
		catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	/**
	 * Checks if the current string is a valid word, contains no special characters 
	 * @param word the word that is checked
	 * @return true if the words is valid, false if not 
	 */
	@Override
	public boolean isValidWord(String word) {
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)<'a' || word.charAt(i)>'z')
				return false;
		
		}
		return true;
	}
	/**
	 * Transforms a word to its signature 
	 * @param word the word that is used in the conversion process
	 * @return the signature of the given word
	 */
	@Override
	public String wordToSignature(String word) {
		String s = new String();

		for (int i = 0; i < word.length(); i++) {

			switch (word.charAt(i))// for each of the letters in the word it
									// concatenates the right number to s
			{
			case 'a':
			case 'b':
			case 'c':
				s = s + "2";
				break;
			case 'd':
			case 'e':
			case 'f':
				s = s + "3";
				break;
			case 'g':
			case 'h':
			case 'i':
				s = s + "4";
				break;
			case 'j':
			case 'k':
			case 'l':
				s = s + "5";
				break;
			case 'm':
			case 'n':
			case 'o':
				s = s + "6";
				break;
			case 'p':
			case 'q':
			case 'r':
			case 's':
				s = s + "7";
				break;
			case 't':
			case 'u':
			case 'v':
				s = s + "8";
				break;
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				s = s + "9";
				break;
			default:
				s = s + " ";
			}

		}

		return s;
	}
	/**
	 * 
	 * @param signature the signature used to search in the dictionary
	 * @return a set of all the words in the dictionary that have the same signature as the given word
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		Set<String> x = table.get(signature);
		
		return x;
	}

}
