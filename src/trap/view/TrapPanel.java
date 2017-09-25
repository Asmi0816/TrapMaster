package trap.view;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import trap.controller.TrapController;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class TrapPanel extends JPanel implements KeyListener, ActionListener
{
	private TrapController baseController;
	private Timer gameTime;
	private Scanner keyBoard;
	private SpringLayout baseLayout;
	private JLabel backgroundLabel, characterLabel, exit, sandPlatform;
	private ImageIcon baseLabel, startIcon, lvlIcon, charIcon, lvl2Icon, lvl3Icon, sandIcon;
	private JButton startButton, backButton;

	
	public TrapPanel(TrapController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		gameTime = new Timer(5,this);
		
		keyBoard = new Scanner(System.in);
		
		backgroundLabel = new JLabel();
		characterLabel = new JLabel();
		exit = new JLabel();
		sandPlatform = new JLabel();
		
		
		
		startButton = new JButton();
		backButton = new JButton("Back");
		
		baseLabel = new ImageIcon(getClass().getResource("/trap/view/pictures/MainScreen.png"));
		startIcon = new ImageIcon(getClass().getResource("/trap/view/pictures/StartButton.gif"));
		lvlIcon = new ImageIcon(getClass().getResource("/trap/view/pictures/Desert_Expance.jpg"));
		lvl2Icon = new ImageIcon(getClass().getResource("/trap/view/pictures/Rolling_Dunes.jpg"));
		lvl3Icon = new ImageIcon(getClass().getResource("/trap/view/pictures/Old_West.jpg"));
		sandIcon = new ImageIcon(getClass().getResource("/trap/view/pictures/LandingSpot.png"));
		charIcon = new ImageIcon(getClass().getResource("/trap/view/pictures/Char.png"));
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900, 600));
	
		this.addKeyListener(this);
		this.setFocusable(true);
		
		this.add(characterLabel);
		characterLabel.setVisible(false);
		characterLabel.setIcon(charIcon);
		
		
		this.add(sandPlatform);
		sandPlatform.setVisible(false);
		sandPlatform.setIcon(sandIcon);
		
		
		this.add(exit);
		exit.setVisible(false);
		exit.setIcon(lvl3Icon);
		
		this.add(startButton);
		
		this.add(backButton);
		backButton.setVisible(false);
		backButton.setEnabled(false);
		
		this.add(backgroundLabel);
		backgroundLabel.setIcon(baseLabel);
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, backgroundLabel, 12, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, backgroundLabel, 12, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, backgroundLabel, -12, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, backgroundLabel, -12, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, startButton, 475, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, startButton, 200, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, startButton, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, startButton, -700, SpringLayout.EAST, this);
		
		
	}
	
	public void setupListeners()
	{
		startButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent selection)
					{
						exit.setLocation(600,800);
						startButton.setVisible(false);
						startButton.setEnabled(false);
						backgroundLabel.setIcon(lvlIcon);
						backButton.setVisible(true);
						backButton.setEnabled(true);
						sandPlatform.setVisible(true);
						
						baseController.movePlatform(sandPlatform.getX(), sandPlatform.getY());
						
						characterLabel.setVisible(true);
						exit.setVisible(true);
						gameTime.start();
						
						
					}
				});
		
		backButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent selection)
				{
					startButton.setVisible(true);
					startButton.setEnabled(true);
					backgroundLabel.setIcon(baseLabel);
					backButton.setVisible(false);
					backButton.setEnabled(false);
					characterLabel.setVisible(false);
					
				}
			});
	}
	
	public void keyPressed(KeyEvent e)
	{
		  int code = e.getKeyCode();
		  int y = characterLabel.getY();
		  int x = characterLabel.getX();
		  
		 
		  // Simple arrow control scheme
				  if(code == KeyEvent.VK_UP)
				  {
					  characterLabel.setLocation(x, y - 5);
					  y = characterLabel.getY();
					  x = characterLabel.getX();
					  baseController.moveBox(x, y);
				  }
				  else if(code == KeyEvent.VK_DOWN)
				  {
					  characterLabel.setLocation(x, y + 5);
					  y = characterLabel.getY();
					  x = characterLabel.getX();
					  baseController.moveBox(x, y);
				  }
				  else if(code == KeyEvent.VK_RIGHT)
				  {
					  characterLabel.setLocation(x+5, y);
					  y = characterLabel.getY();
					  x = characterLabel.getX();
					  baseController.moveBox(x, y);
					  
				  }
				  else if(code == KeyEvent.VK_LEFT)
				  {
					  characterLabel.setLocation(x-5, y);
					  y = characterLabel.getY();
					  x = characterLabel.getX();
					  baseController.moveBox(x, y);
				  }
		  
	}

	
	public void keyReleased(KeyEvent e)
	{
		//Nothing until I add velocity
	}

	
	public void keyTyped(KeyEvent arg0) 
	{
		//Nothing to be written here
		
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		// Gets the characters labels location so that it has easy to use coordinates.
		int newY = characterLabel.getY();
		int newX = characterLabel.getX();
		
		
		// Acts like an animation where it updates and repaints every 5 milliseconds. However right now the argument is being passed as null which needs to be fixed.
  		if((baseController.getUserCharacter().getPlayer().intersects(baseController.getUserCharacter().getPlatformBox()) == false)
  				&& (newY < 500))			
  		{
  			//Changes character location falling down one every time the argument passes. Moving the hit box as well as the character.
  				characterLabel.setLocation(newX, newY + 1);
				newY = characterLabel.getY();
				newX = characterLabel.getX();
				baseController.moveBox(newX, newY);
  		}
  		//Updates the gui.
		repaint();
		
	}
	
	public JLabel getCharacterLabel()
	{
		return characterLabel;
	}

	public void setCharacterLabel(JLabel characterLabel)
	{
		this.characterLabel = characterLabel;
	}

}
