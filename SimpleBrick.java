package brick;
import java.awt.Color;
import java.awt.Graphics;
import interfaces.*;

public class SimpleBrick extends Brick implements Drawable {


	public int getsBrickX() {
		return super.getBrickXCoor();
	}

	public void setsBrickX(int sBrickX) {
		super.setBrickXCoor(sBrickX);
	}

	public int getsBrickY() {
		return super.getBrickYCoor();
	}

	public void setsBrickY(int sBrickY) {
		super.setBrickYCoor(sBrickY);
	}




	public SimpleBrick(int brickXCoor, int brickYCoor) {
		super(brickXCoor, brickYCoor);
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillRect(this.getsBrickX(), this.getsBrickY(), 100, 50);
	}



	
}
