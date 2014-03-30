package predictivegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import predictive.DictionaryTreeImpl;

public class ButtonListener implements ActionListener {
	private DictionaryModel model;
	private int number;
	
	/** 
	 * Creates a listener for each of the buttons
	 * @param model model used 
	 * @param number the digit on the pressed key
	 */
	public ButtonListener(DictionaryModel model,int number)
	{
		this.model = model;
		this.number = number;
	}
	@Override
	/**
	 * creates a signature with the new number taken from the keypad
	 */
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(number);
		model.createSignature(number+"");
		
		// display the first word and keep the others at hand 
		
	}

}
