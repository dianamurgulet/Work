package predictive;

import java.util.HashSet;
import java.util.Set;

public class Sig2WordsMap {

	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();

				
		Dictionary imp = new DictionaryMapImpl();
		for(int i=0;i<args.length;i++)
		{	
			Set<String> result = imp.signatureToWords(args[i]);
			for (String string : result) {
				System.out.print(" "+ string+" ");
			}
			System.out.println();
			
		}
		
	}
	
	// TIME FOR 70 WORDS 5987 MS 
}
