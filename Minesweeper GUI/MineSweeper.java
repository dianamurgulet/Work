import java.util.Random;
/**
	Creates the board for a new game	
 */
public class MineSweeper
{
	/**
	@param moves the board that saves the clicks of the user, true means the cell has been clicked
	@param board the board with values -1 for mine, positive value for the number of surrounding mines
	@param dif the level of difficulty, how many bombs are on the board
	*/
	private int[][] board;
	private boolean[][] moves;
	int dif;
	/**
	creates a new board and a board of moves
	@param dif the level of difficulty, how many bombs are on the board
	*/
	public MineSweeper(int dif)
	{
		this.dif = dif;
		moves = new boolean [10][10];
		board = new int [12][12];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				moves[i][j]=false;
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				board[i][j] = 0;
			}
		}
		for(int i=0;i<dif;i++)
		{
			Random rand = new Random(); 
			int value = rand.nextInt(100); 
			
			board[value/10+1][value%10+1] = -1;
		}
		for(int i=1;i<11;i++)
			for(int j=1;j<11;j++)
			{
				if(board[i][j]!=-1)
				{
					int ct = 0;
					if(board[i-1][j] == -1)
						ct++;
					if(board[i+1][j] == -1)
						ct++;
					if(board[i][j-1] == -1)
						ct++;
					if(board[i][j+1] == -1)
						ct++;
					if(board[i-1][j-1] == -1)
						ct++;
					if(board[i+1][j+1] == -1)
						ct++;
					if(board[i+1][j-1] == -1)
						ct++;
					if(board[i-1][j+1] == -1)
						ct++;
					board[i][j]=ct;
				}
			}		
		/*for(int i=1;i<11;i++)
		{
			for(int j =1;j<11;j++)
				System.out.print(" "+board[i][j]+ " ");
			System.out.print("\n");
		}*/
	}
	
	/**
	marks on the move board that a the user has clicked a box
	@param i the line coordinate
	@param j the column coordinate
	*/
	public void move(int i,int j)
	{
		moves[i][j]= true; 
	}
	/**
	@param i the line coordinate
	@param j the column coordinate
	@return indicates whether the user has clicked on the box at the coord i and j 
	*/
	public boolean getMove(int i,int j)
	{
		return moves[i][j];
	
	}
	/** 
	@param i the line coordinate
	@param j the column coordinate
	@return the value at a given coordinate, could be -1 for bomb, or positive number for nr of surrounding bombs
	*/
	public int getValue(int i,int j)
	{
		return board[i][j];
	
	}
	/** 
	determines whether the user has clicked on a bomb
	@param i the line coordinate
	@param j the column coordinate
	@return true for game over
	*/
	public boolean isOver(int i,int j)
	{
		if(board[i][j]==-1)
			return true;
		else
			return false;
	
	}
	/** 
	determines whether the game has been won by subtracting the nr of moves made so far from the number of possible moves 
	@param ct the numbers of moves made so far
	@return true for winner 
	*/
	public boolean isWinner(int ct)
	{
		if(ct == 100 - dif)
			return true;
		else 
			return false;
		
	
	}
	/** 
	creates a new game of a given difficulty 
	@param dif the level of difficulty, how many bombs are on the board
	*/
	public void newGame(int dif)
	{
		this.dif = dif;
		moves = new boolean [10][10];
		board = new int [12][12];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				moves[i][j]=false;
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				board[i][j] = 0;
			}
		}
		for(int i=0;i<dif;i++)
		{
			Random rand = new Random(); 
			int value = rand.nextInt(100); 
			
			board[value/10+1][value%10+1] = -1;
		}
		for(int i=1;i<11;i++)
			for(int j=1;j<11;j++)
			{
				if(board[i][j]!=-1)
				{
					int ct = 0;
					if(board[i-1][j] == -1)
						ct++;
					if(board[i+1][j] == -1)
						ct++;
					if(board[i][j-1] == -1)
						ct++;
					if(board[i][j+1] == -1)
						ct++;
					if(board[i-1][j-1] == -1)
						ct++;
					if(board[i+1][j+1] == -1)
						ct++;
					if(board[i+1][j-1] == -1)
						ct++;
					if(board[i-1][j+1] == -1)
						ct++;
					board[i][j]=ct;
				}
			}		
	
	
	
	}
}