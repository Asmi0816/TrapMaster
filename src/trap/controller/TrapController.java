package trap.controller;
import trap.view.TrapFrame;
import trap.model.Character;


public class TrapController 
{
	private TrapFrame baseFrame;
	private Character userCharacter;
	
	
	public TrapController()
	{
		baseFrame = new TrapFrame(this);
		userCharacter = new Character(this);
	}
	public void start()
	{
		
	}
	
	public void moveBox(int x, int y)
	{
		userCharacter.moveBox(x, y);
	}
	
	public void movePlatform(int pltX, int pltY)
	{
		userCharacter.movePlatform(pltX, pltY);
	}

	public Character getUserCharacter() 
	{
		return userCharacter;
	}
	
	
	
	
}
