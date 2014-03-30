import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;



public class ControlPanel extends JPanel 
{

	public ControlPanel(final MineModel model)
	{
	
		// call super constructor
		
		super();
		
		// create "new game" button
		
		
		
		// create "exit" button
		
		JButton exit = new JButton("Exit");
		
		// add anonymous listener
		
		exit.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
		
		JButton reset = new JButton("New Game");
		
		// add anonymous listener
		
		reset.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					model.newGame(10);
				}
			});
			JButton reveal = new JButton("Reveal");
		
		// add anonymous listener
		
		reveal.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.reveal();
				}
			});
		ButtonGroup group = new ButtonGroup();
		JRadioButton button1 = new JRadioButton ("Hard");
		JRadioButton button2 = new JRadioButton ("Normal");
		JRadioButton button3 = new JRadioButton ("Easy",true);
		group.add(button1);
		group.add(button2);
		group.add(button3);
		button1.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int dif =20;
					model.newGame(dif);
				}
			});
		button2.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int dif = 15;
					model.newGame(dif);
				}
			});
		//if(smallbutton.isSelected())
		//setselected
		button3.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int dif = 10;
					model.newGame(dif);
				}
			});
		
		// put buttons on panel
		add(button1);
		add(button2);
		add(button3);
		add(reset);
		add(reveal);
		add(exit);
		
		
	}
}
