package predictive;

import java.math.BigInteger;

public class WordSig implements Comparable<WordSig> {

	private String signature;
	private String words;
	
	public WordSig(String signature,String words){
		this.signature= signature;
		this.words= words;
		
	}
	@Override
	public int compareTo(WordSig word2) {
		BigInteger intw = new BigInteger(word2.getSignature());
		BigInteger intthis = new BigInteger(signature);
		return intthis.compareTo(intw);
		
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	
}
