package predictive;

import java.util.HashSet;
import java.util.Set;

public class Sig2WordsTree {
	public static void main(String[] args) {
	Set<String> similar= new HashSet<String>();
	long time = System.currentTimeMillis();
	Dictionary imp = new DictionaryTreeImpl("/usr/share/dict/words");
	for(int i=0;i<args.length;i++)
	{	
		Set<String> result = imp.signatureToWords(args[i]);
		for (String string : result) {
			System.out.print(" "+ string+" ");
		}
		System.out.println();
		
	}
	System.out.println(System.currentTimeMillis() - time);
}// TIME FOR 70 WORDS 10357 MS 
}
