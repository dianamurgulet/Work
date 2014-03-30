package predictive;

import java.util.HashSet;
import java.util.Set;

public class Sigs2WordsProto {
	 
	public static void main(String[] args)
	{ 	
		Set<String> similar= new HashSet<String>();
		for(int i=0;i<args.length;i++)
		{
			System.out.println(PredictivePrototype.signatureToWords(args[i]));
		}

		
	}
}
// 115 words: 54013