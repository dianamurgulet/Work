import javax.swing.JPanel;
import java.awt.BorderLayout;
/** 
Creates a MineComponent
@param game an object of the MineSweeper type used by the program
 */
public class MineComponent extends JPanel
{
	public MineComponent(MineSweeper game)
	{
		super();
		
		// make model
		MineModel model = new MineModel(game);
		
		// make board view
		BoardView board = new BoardView(model);
		
		ControlPanel panel = new ControlPanel(model);
		
		// make view observe the model
		model.addObserver(board);
		
		
		
		// set layout
		setLayout( new BorderLayout() );
		
		
		// put board view in center
		add(board, BorderLayout.CENTER);
		
		add(panel, BorderLayout.SOUTH);
	}
}
