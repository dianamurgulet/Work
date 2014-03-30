package predictivegui;

import java.util.Observable;
import java.util.Set;

import predictive.DictionaryTreeImpl;

public class DictionaryModel extends Observable{
	
	private DictionaryTreeImpl dictionary;
	private String signature;
	private int count = 1; 
	Set<String> result;
	boolean finishedWord = false;
	private boolean display =false;
	/**
	 * 
	 * @param dictionary the dictionary used in the model - could be changed to any type
	 * of dictionary not just DictionaryTreeImpl
	 */
	public DictionaryModel(DictionaryTreeImpl dictionary)
	{
		super();
		signature = "";
		this.dictionary = dictionary;		
	}
	/**
	 * gets the digit that is currently used = just inserted
	 * @return the letter we are currently looking at 
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * sets the count of the digit in the signature that is currently used
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * Checks if the current string is a valid word, contains no special characters 
	 * @param word the word that is checked
	 * @return true if the words is valid, false if not 
	 */
	public boolean isValidWord(String word)
	{
		return dictionary.isValidWord(word);
		
	}
	/**
	 * Transforms a word to its signature 
	 * @param word the word that is used in the conversion process
	 * @return the signature of the given word
	 */
	public String wordToSignature(String word)
	{
		return dictionary.wordToSignature(word);
		
	}
	/**
	 * appends the current digit inserted from the keyboard to the signature 
	 * and generates the set of words that match it
	 * it also notifies the observes so the update method of the view is called 
	 * @param number the key that was just pressed 
	 * 
	 */
	public void createSignature(String number){
		signature = signature+ number;
		//System.out.println(signature);
		setResult(dictionary.signatureToWords(signature));
		
		//needDisplay();
		
		setChanged();
		notifyObservers();
	}
	/**
	 * gets the set that contains the words that need to be displayed
	 * @return the set of strings that match the signature
	 */ 
	public Set<String> getResult() {
		return result;
	}
	
	public int setSize(){
		
		return result.size();
	}
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
/**
 * it moves to the next word in the set of results
 *	when the end of the list has been reached, it starts back from 1
 *	it notifies the observers to display the next words
 */
	public void nextWord(){
		if(count>getResult().size()-1)
			count = 1;
		else
			count++;
		setChanged();
		notifyObservers();
	}
	public void setResult(Set<String> result) {
		this.result = result;
		
	}

//	public void needDisplay(){
//		 display= true;
//		
//	}
	public Set<String> signatureToWords(String signature)
	{
		
		return dictionary.signatureToWords(signature);
		
		
	}
/**
 * when the user has finished typing a word the signature is set to an empty string to
 * allow creating a new signature for a new word
 * a boolean is changed so that the update method can concatenate the final words and a space 
 * and start displaying the new word
 */
	public void makeNewWord() {
		setSignature("");
		setFinishedWord(true);
		setChanged();
		notifyObservers();
		// TODO Auto-generated method stub
		
	}
/**
 * checks if a user has finished typing a word, if true a space needs to be displayed 
 * and new word needs to be formed
 * @return
 */
	public boolean isFinishedWord() {
		return finishedWord;
	}
/**
 * marks that the user has finished typing a word
 * @param finishedWord
 */
	public void setFinishedWord(boolean finishedWord) {
		this.finishedWord = finishedWord;
	}
	
	
}
