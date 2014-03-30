import java.util.Observable;
/**
Creates the Model for a MineSweeper game
 */
public class MineModel extends Observable
{	
	private MineSweeper game;
	private boolean neednew = false;
	public boolean reveal=false;
	public MineModel(MineSweeper game)
	{	
		super();
		this.game = game; 
	
	
	}
	/**
	marks on the move board that a the user has clicked a box
	@param i the line coordinate
	@param j the column coordinate
	*/
	public void move (int i,int j)
	{
		game.move(i,j);
		setChanged();
		notifyObservers();
	}
	/** 
	generates a new game
	*/
	public void newGame(int dif)
	{
		game.newGame(dif);
		neednew=true;
		setChanged();
		notifyObservers();
	}
	/**
	announces that a new game needs to be creates	
	*/
	public boolean needNewGame()
	{
		return neednew;
	}
	/**
	@param i the line coordinate
	@param j the column coordinate
	@return indicates whether the user has clicked on the box at the coord i and j 
	*/
	public boolean getMove(int i,int j)
	{
		return game.getMove(i,j);
	}
	/** 
	@param i the line coordinate
	@param j the column coordinate
	@return the value at a given coordinate, could be -1 for bomb, or positive number for nr of surrounding bombs
	*/
	public int getValue(int i,int j)
	{
		return game.getValue(i,j);
	
	}
	/** 
	determines whether the user has clicked on a bomb
	@param i the line coordinate
	@param j the column coordinate
	@return true for game over
	*/
	public boolean isOver(int i,int j)
	{
		return game.isOver(i,j);
		
	}
	/** 
	determines whether the game has been won by subtracting the nr of moves made so far from the number of possible moves 
	@param ct the numbers of moves made so far
	@return true for winner 
	*/
	public boolean isWinner(int ct)
	{
		return game.isWinner(ct);
	}
	/**
	indicates that the board does not need to be revealed 
	*/
	public void revealf()
	{
		reveal = false;
	}
	/**
	determines that the board needs to be revealed and notifies the observers
	*/
	public void reveal()
	{
		reveal = true;
		setChanged();
		notifyObservers();
	}
	/**
	indicates that the board needs to be revealed and notifies the observers
	*/
	public boolean needReveal()
	{
		return reveal;
	}
}