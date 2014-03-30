package predictive;

import java.util.HashSet;
import java.util.Set;

public class TreeDictionary {

	private TreeDictionary t2;
	private TreeDictionary t3;
	private TreeDictionary t4;
	private TreeDictionary t5;
	private TreeDictionary t6;
	private TreeDictionary t7;
	private TreeDictionary t8;
	private TreeDictionary t9;
	private Set<String> words;
	private String currentsignature, ncurrentsignature;
	/**
	 * creates a new tree that holds a dictionary
	 * @param currentsignature the signature of the current level in the tree
	 */
	public TreeDictionary(String currentsignature) {
		this.currentsignature = currentsignature;
	}
	/**
	 * adds a word to the right place in the ree
	 * @param scurrent the current string to be added
	 * @param signature the signature of the current string
	 * @param i the character that is compared in order to decide which branch to take
	 */
	public void add(String scurrent, String signature, int i) {
		if (signature.equals(currentsignature)) {
			if (words == null) {
				words = new HashSet<String>();
				words.add(scurrent);
			} else
				words.add(scurrent);
		} else {
			switch (signature.charAt(i))// for each of the letters in the word
										// it
			// concatenates the right number to s
			{
			case '2': {
				ncurrentsignature = currentsignature + "2";
				if (t2 == null)
					t2 = new TreeDictionary(ncurrentsignature);
				t2.add(scurrent, signature, i + 1);

				break;
			}
			case '3': {
				ncurrentsignature = currentsignature + "3";
				if (t3 == null)
					t3 = new TreeDictionary(ncurrentsignature);
				t3.add(scurrent, signature, i + 1);

				break;
			}
			case '4': {
				ncurrentsignature = currentsignature + "4";
				if (t4 == null)
					t4 = new TreeDictionary(ncurrentsignature);
				t4.add(scurrent, signature, i + 1);

				break;
			}
			case '5': {
				ncurrentsignature = currentsignature + "5";
				if (t5 == null)
					t5 = new TreeDictionary(ncurrentsignature);
				t5.add(scurrent, signature, i + 1);

				break;
			}
			case '6': {
				ncurrentsignature = currentsignature + "6";
				if (t6 == null)
					t6 = new TreeDictionary(ncurrentsignature);
				t6.add(scurrent, signature, i + 1);

				break;
			}
			case '7': {
				ncurrentsignature = currentsignature + "7";
				if (t7 == null)
					t7 = new TreeDictionary(ncurrentsignature);
				t7.add(scurrent, signature, i + 1);

				break;
			}
			case '8': {
				ncurrentsignature = currentsignature + "8";
				if (t8 == null)
					t8 = new TreeDictionary(ncurrentsignature);
				t8.add(scurrent, signature, i + 1);

				break;
			}
			case '9': {
				ncurrentsignature = currentsignature + "9";
				if (t9 == null)
					t9 = new TreeDictionary(ncurrentsignature);
				t9.add(scurrent, signature, i + 1);

				break;
			}
			default: {
				t2 = new TreeDictionary(currentsignature);
				t2.add(scurrent, signature, i);
			}
			}

		}

	}
/**
 * searches for an element in the tree
 * @param signature the signature of the element that is searched 
 * @param i the character in the signature that is used to decide which branch to take
 * @return
 */
	public Set<String> search(String signature,int i) {
		Set<String> t0 = new HashSet();
		
		if (signature.equals(currentsignature))
			return words;
		else {
			switch (signature.charAt(i))// for each of the letters in the word
			{
			case '2': {
				if(t2 != null)
					return t2.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
				
			}
			case '3': {
				if(t3 != null)
					return t3.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
				
			}
			case '4': {
				if(t4 != null)
					return t4.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
				 
			}
			case '5': {
				if(t5 != null)
					return t5.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
			}
			case '6': {
				if(t6 != null)
					return t6.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
				 
			}
			case '7': {
				if(t7 != null)
					return t7.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}

				 
			}
			case '8': {
				if(t8 != null)
					return t8.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}
				 
			}
			case '9': {
				if(t9 != null)
					return t9.search(signature,i+1);
				else
				{
					t0.add(signature);
					return t0;
				}

				 
			}
			default: {
				return t9.search(signature,i+1);
			}
			}
			
		}
		
	}
}
