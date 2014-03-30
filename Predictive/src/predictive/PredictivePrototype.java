package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PredictivePrototype {
	
	/**
	it converts a given string to its signature
	@param word to be converted into a signature
	@return s the string that contains the signature
	*/
	public static String wordToSignature(String word) {
		String s = new String();
		
		for(int i=0;i<word.length();i++)
		{
			
			switch(word.charAt(i))//for each of the letters in the word it concatenates the right number to s
			{
			case 'a':case 'b':case 'c': s=s+"2"; break;
			case 'd':case 'e':case 'f': s=s+"3"; break;
			case 'g':case 'h':case 'i': s=s+"4"; break;
			case 'j':case 'k':case 'l': s=s+"5"; break;
			case 'm':case 'n':case 'o': s=s+"6"; break;
			case 'p':case 'q':case 'r': case 's':s=s+"7"; break;
			case 't':case 'u':case 'v': s=s+"8"; break;
			case 'w':case 'x':case 'y': case'z':s=s+"9"; break;
			default: s=s+" ";
			}
											
		}
		
		return s;
	}
	
	private static boolean isValidWord(String word) {
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)<'a' || word.charAt(i)>'z')
				return false;
		
		}
		return true;
	
	}
	
	/**
	it converts a numeric signature to a set of words that have the given signature
	@param signature the signature that is used to search in the dictionary
	@return same the set that contains all the strings in the dictionary that have the same signature as the signature variable
	*/
	public static Set<String> signatureToWords(String signature){
		Set<String> same= new HashSet<String>();
		try { //if the file cannot be found or opened it returns an error
			BufferedReader dictionaryReader = new BufferedReader(new FileReader("/usr/share/dict/words"));//opens the file that contains the dictionary
			//BufferedReader dictionaryReader = new BufferedReader(new FileReader("words"));
			String scurrent = dictionaryReader.readLine();//reads a line at a time from the dictionary
			
			while(scurrent!=null)//until the end of the dictionary file has not been reached
			{
				if(isValidWord(scurrent))
				{
				if(signature.equals(wordToSignature(scurrent)))//the word is converted to its signature, if the two strings are equal it adds it to the set
					same.add(scurrent);
				}
				scurrent = dictionaryReader.readLine();
				
			}
			dictionaryReader.close();//closes the file that contains the dictionary
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return same;
		//this method is not efficient because for each call of the function we have to get the signature of all the words in the dictionary
		//it would be more efficient if we converted the words to their signature only once and save the in an ordered manner so that words with the same signature
		//are in the same place  
		
		
	}

}
