package trap.model;
import java.awt.Rectangle;
import trap.controller.TrapController;

public class Character 
{
	
	private Rectangle player;
	private Rectangle platformBox;
	private TrapController baseController;
	private int x;
	
	private int y;
	
	
	public Character(TrapController baseController)
	{
		 this.baseController = baseController;
		 player = new Rectangle(0, 0, 20, 20);
		 platformBox = new Rectangle(0,0,20,20);
	}
	
	public void moveBox(int locationX, int locationY)
	{
		x = locationX;
		y = locationY;
		player.setLocation(locationX, locationY);
	}
	
	public void movePlatform(int locationX, int locationY)
	{
		
		platformBox.setLocation(locationX, locationY);
	}
	public Rectangle getPlayer() {
		return player;
	}

	public void setPlayer(Rectangle player) {
		this.player = player;
	}

	public Rectangle getPlatformBox() {
		return platformBox;
	}

	public void setPlatformBox(Rectangle exitBox) {
		this.platformBox = exitBox;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}