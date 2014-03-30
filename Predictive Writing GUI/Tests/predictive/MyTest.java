package predictive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
@Test
public class MyTest {
	DictionaryTreeImpl dict = new DictionaryTreeImpl("/usr/share/dict/words");
	DictionaryListImpl dictl = new DictionaryListImpl();
	@BeforeMethod
  public void setUp() {
		
  }
	
	public void test1(){
		
		assertEquals("43556", PredictivePrototype.wordToSignature("hello"));
	}
	public void test2(){
		Set<String> same= new HashSet<String>();
		same.add("hello");
		assertEquals(same, PredictivePrototype.signatureToWords("43556"));
	}
	public void test3(){
		 
		assertEquals(true, dict.isValidWord("hello"));
	}
	public void test4(){
		Set<String> same= new HashSet<String>();
		same.add("hello");
		assertEquals(same, dict.signatureToWords("43556"));
	}
	public void test5(){
		
		assertEquals("4663", dict.wordToSignature("home"));
	}
	public void test6(){
		Set<String> same= new HashSet<String>();
		//hond, home, hone, gome, goof, good, gone, gond, inne, hood, hoof
		same.add("hond");
		same.add("home");
		same.add("hone");
		same.add("gome");
		same.add("goof");
		same.add("good");
		same.add("gone");
		same.add("gond");
		same.add("inne");
		same.add("hood");
		same.add("hoof");
		assertEquals(same, dict.signatureToWords("4663"));
	}
	
	}
