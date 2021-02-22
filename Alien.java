package alien;

import java.awt.Graphics;

public class Alien {
	private int alienXCoor;
	private int alienYCoor;
	public int getAlienXCoor() {
		return alienXCoor;
	}
	public void setAlienXCoor(int alienXCoor) {
		this.alienXCoor = alienXCoor;
	}
	public int getAlienYCoor() {
		return alienYCoor;
	}
	public void setAlienYCoor(int alienYCoor) {
		this.alienYCoor = alienYCoor;
	}
	public Alien(int alienXCoor, int alienYCoor) {
		this.alienXCoor = alienXCoor;
		this.alienYCoor = alienYCoor;
	}
	
	public void draw(Graphics g) {

	}

	
}
