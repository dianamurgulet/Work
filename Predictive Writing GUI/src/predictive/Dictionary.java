package predictive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Dictionary {
	/**
	Gets the list that is used to store the words in the dictionary
	@return list the list that stores pairs of words and signatures
	*/
//	public List<WordSig> getList();
//	/**
//	 Sets the list that the program uses as a dictionary
//	 @param list a list of pairs of words and signatures that will be used as a dictionary
//	 */
//	public void setList(ArrayList<WordSig> list);
	/**
	 * Checks if the current string is a valid word, contains no special characters 
	 * @param word the word that is checked
	 * @return true if the words is valid, false if not 
	 */
	public boolean isValidWord(String word);
	/**
	 * Transforms a word to its signature 
	 * @param word the word that is used in the conversion process
	 * @return the signature of the given word
	 */
	public String wordToSignature(String word);
	/**
	 * 
	 * @param signature the signature used to search in the dictionary
	 * @return a set of all the words in the dictionary that have the same signature as the given word
	 */
	public Set<String> signatureToWords(String signature);
	

	
}
