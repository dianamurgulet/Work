package predictivegui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DictionaryView extends JPanel implements Observer {

	private JButton[][] key;
	private JTextField numberEnter;
	private DictionaryModel model;
	private Set<String> result;
	private String toDisplay = "";
	private String first="";
	/**
	 * Creates a dictionary view and adds the buttons 
	 * for each button from 2 to 9 it adds the appropriate listener
	 * for * and _ separate listeners are created
	 * @param numberEnter the field where the numbers will be displayed
	 * @param model
	 */
	public DictionaryView(JTextField numberEnter, final DictionaryModel model){
		super();
		key = new JButton[10][10];
		this.numberEnter = numberEnter;
		this.model = model;
	
		// set layout
		
		setLayout(new GridLayout(4, 3) );
		
		// loop through board positions
		   // create a button
		   // add listener
		   // place on panel
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				int number = i*3 +j+1;
				
				switch (number)// for each of the letters in the word
				{
				case 1: {
					key[i][j] = new JButton(number+ "");break;
				}
				case 2: {
					key[i][j] = new JButton(number+ "  (abc)");break;
				}
				case 3: {
				
					key[i][j] = new JButton(number+ "  (def)");break;
				}
				case 4: {
					
					key[i][j] = new JButton(number+ "  (ghi)");break;
				}
				case 5: {
					key[i][j] = new JButton(number+ "  (jkl)");break;
					 
				}
				case 6: {
					
					key[i][j] = new JButton(number+ "  (mno)");break;
				}
				case 7: {
					key[i][j] = new JButton(number+ "  (pqrs)");break;

					 
				}
				case 8: {
					key[i][j] = new JButton(number+ "  (tuv)");break;
					 
				}
				case 9: {
					
					key[i][j] = new JButton(number+ "  (wxyz)");break;
					 
				}
				case 10: {
					
					key[i][j] = new JButton("  *");break;
					 
				}
				case 11: {
					
					key[i][j] = new JButton("  _");break;
					 
				}
				case 12: {
					
					key[i][j] = new JButton("");break;
					 
				}
				default: {
					key[i][j] = new JButton(number+ "");
				}
				}
				
				
				if(number>1 && number< 10){
					key[i][j].addActionListener(new ButtonListener(model,number));
				}
				if(number == 10){
					key[i][j].addActionListener(
							new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									//go through the list of words one at a time 
									model.nextWord();
								}
							});
				}
				if(number == 11){
					key[i][j].addActionListener(
							new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									model.makeNewWord();
									
								}
							});
				}
				if(number == 12){
					key[i][j].addActionListener(
							new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									//
								}
							});
				}
				add(key[i][j]);
			}
		}   
		
		
		
	}
	@Override
	/**
	 * gets the first word out of the set and displays it. if * was pressed it moves on to the next word
	 * if a there is no word for that signature, the signature is displayed
	 */
	public void update(Observable obs, Object obj) {
		//	System.out.println("text");
			
			
			 result = model.getResult();
			 if(result == null){
			 String signature =model.getSignature();
				
				numberEnter.setText(toDisplay+ signature);
			 }
			 else
			 {
			 System.out.println(result);
			 if(model.isFinishedWord())
			 {
				toDisplay = toDisplay+ first;
				toDisplay = toDisplay+ " ";
				numberEnter.setText(toDisplay);
				//System.out.println("toDisplay is: "+ toDisplay+ "first is: "+ first);
				 model.setFinishedWord(false);
			 }
			 else
			 {
				 int i = model.getCount();
				 if(i==1){
					 first = result.iterator().next();
				 }
				 else
				 {
					 Iterator<String> j = result.iterator();
					 String x=j.next();
	
					 System.out.println(i);
					 while(i>1&&j.hasNext())
					 { 
						  x = j.next();
						 i--;
					 }
					
					 first = x;
					 
				 }
				 
				
				numberEnter.setText(toDisplay + first);
			 }
			
			 }
		
	}

}
