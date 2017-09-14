package trap.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import trap.controller.TrapController;
import trap.view.TrapPanel;

public class TrapFrame extends JFrame
{
	private TrapController baseController;
	private TrapPanel basePanel;
	
	public TrapFrame(TrapController baseController)
	{
		super();
		this.baseController = baseController;
		basePanel = new TrapPanel(baseController);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(new Dimension(1080,720));
		this.setLocationRelativeTo(null);
		this.setTitle("");
		
		this.setVisible(true);
	}
	
	
}
