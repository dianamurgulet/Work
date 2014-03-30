package predictive;

import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DictionaryTreeImpl test = new DictionaryTreeImpl("words");
		String s= "";
		DictionaryTreeImpl d1 = new DictionaryTreeImpl("words");
		Set<String> x = d1.signatureToWords("7243684787");
		for (String string : x) {
			System.out.print(" "+string+" ");
		}
		
		
	}

}
