package predictivegui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import predictive.DictionaryTreeImpl;

public class DictionaryComponent extends JPanel {
	/**
	 * Creates a dictionary model using the dictionary, places the keypad on the borderlayout and places the field where the numbers 
	 * will be entered on the screen. The field is disabled so that the user cannot type straight into it
	 * @param dictionary the dictionary that is used to create the model
	 */
	public DictionaryComponent(DictionaryTreeImpl dictionary){
		super();
		// make model
				DictionaryModel model = new DictionaryModel(dictionary);
				
				// make board view
				
				// set layout
				setLayout( new BorderLayout() );
				JTextField numberEnter = new JTextField("Enter numbers here", 60);
				DictionaryView view = new DictionaryView(numberEnter,model);
				model.addObserver(view);
				// put board view in center
				add(view, BorderLayout.CENTER);
				
				numberEnter.setEditable(false);
				add(numberEnter,BorderLayout.NORTH);
		
		
	}

}
