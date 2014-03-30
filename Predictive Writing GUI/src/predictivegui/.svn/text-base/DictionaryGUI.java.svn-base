package predictivegui;

import javax.swing.JFrame;

import predictive.DictionaryListImpl;
import predictive.DictionaryTreeImpl;

public class DictionaryGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Predictive Dictionary");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DictionaryTreeImpl dictionary = new DictionaryTreeImpl("words");
		
		DictionaryComponent comp = new DictionaryComponent(dictionary);
		
		
		
		frame.add(comp);
		frame.setVisible(true);
	}

}
