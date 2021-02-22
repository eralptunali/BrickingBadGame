package brick;

import javax.swing.JPanel;

public class Brick extends JPanel{
	private int brickXCoor;
	private int brickYCoor;
	public int getBrickXCoor() {
		return brickXCoor;
	}
	public void setBrickXCoor(int brickXCoor) {
		this.brickXCoor = brickXCoor;
	}
	public int getBrickYCoor() {
		return brickYCoor;
	}
	public void setBrickYCoor(int brickYCoor) {
		this.brickYCoor = brickYCoor;
	}
	public Brick(int brickXCoor, int brickYCoor) {
		this.brickXCoor = brickXCoor;
		this.brickYCoor = brickYCoor;
	}
	
	
}
