import java.awt.event.*;
/** Creates a listener for the squares that are clicked by the user */
public class SquareListener implements ActionListener
{
	private MineModel model;
	private int row;
	private int column;
	
	public SquareListener(MineModel model,int row, int column)
	{
		this.model = model;
		this.row = row;
		this.column = column;
	}
	/**
	sets the value true on the board at position row, column, indicating that the user has clicked the box*/
	public void actionPerformed(ActionEvent e)
	{
		model.move(row, column);
	}
}
