import javax.swing.JFrame;
/**
Creates the objects needed for the game and adds them to the frame
 */
public class MineSweeperGUI
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Minesweeper");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MineSweeper game = new MineSweeper(10);
		
		MineComponent comp = new MineComponent(game);
		
		
		
		frame.add(comp);
		frame.setVisible(true);

	}



}