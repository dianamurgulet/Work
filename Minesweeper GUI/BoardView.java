import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Observer;
import java.util.Observable;

public class BoardView extends JPanel implements Observer
{
	private MineModel model;
	private JButton[][] cell;
	/** 
	Creates the board and adds listeners to every square on the screen
	*/
	
	public BoardView(MineModel model)
	{
		// call super constructor
		
		super();
		
		//initialise model
		
		this.model = model;
		
		// create cell array
		
		cell = new JButton[10][10];
		
		// set layout
		
		setLayout( new GridLayout(10, 10) );
		
		// loop through board positions
		   // create a button
		   // add listener
		   // place on panel
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				cell[i][j] = new JButton(" ");
				
				cell[i][j].addActionListener(
					new SquareListener(model, i, j));
				
				add(cell[i][j]);
			}
		}   
	}
	/**
	determines how the window need to change as a result of an action
	*/
	public void update(Observable obs, Object obj)
	{	
		boolean isOver = false;
		int ct = 0; 
		if(model.needNewGame())
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					cell[i][j].setText("");
					cell[i][j].setEnabled(true);
				}
			}
		}
	
		if(model.needReveal())
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					cell[i][j].setEnabled(false);
					if(model.getValue(i+1,j+1) == -1)
						cell[i][j].setText("X");
					else
					{
						String str = Integer.toString(model.getValue(i+1,j+1));
						cell[i][j].setText(str);
					}
					
					
				}
			}
			model.revealf();
		}
		
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(model.getMove(i,j))
				{
					if(model.isOver(i+1,j+1))
					{
						cell[i][j].setText("X");
						cell[i][j].setEnabled(false);
						isOver = true;
					}
					else
					{
						String str = Integer.toString(model.getValue(i+1,j+1));
						cell[i][j].setText(str);
						cell[i][j].setEnabled(false);
						ct++;
					}
				}
				
				
			}
		}
		if(isOver)
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{	
					if(model.getValue(i+1,j+1)!=-1)
					{
						String str = Integer.toString(model.getValue(i+1,j+1));
						cell[i][j].setText(str);
					}
					else
						cell[i][j].setText("X");
					cell[i][j].setEnabled(false);
				}
			}
		}
		if(model.isWinner(ct))
		{
			for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < 10; j++)
					{
						String str = Integer.toString(model.getValue(i+1,j+1));
						cell[i][j].setText(str);
						cell[i][j].setEnabled(false);
					}
				}
			
		}
	
		
	
	}
}
