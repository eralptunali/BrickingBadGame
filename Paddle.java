package paddle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

import interfaces.*;



public class Paddle extends JPanel {

	private int length;
	private int paddleXCoordinate;
	private int paddleYCoordinate;
	private int rotateAngle;
	
	
	public int getRotateAngle() {
		return rotateAngle;
	}

	public void setRotateAngle(int rotateAngle) {
		this.rotateAngle = rotateAngle;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	

	public int getPaddleXCoordinate() {
		return paddleXCoordinate;
	}

	public void setPaddleXCoordinate(int paddleXCoordinate) {
		this.paddleXCoordinate = paddleXCoordinate;
	}

	public int getPaddleYCoordinate() {
		return paddleYCoordinate;
	}

	public void setPaddleYCoordinate(int paddleYCoordinate) {
		this.paddleYCoordinate = paddleYCoordinate;
	}

	public Paddle(int length, int paddleXCoordinate, int paddleYCoordinate,int rotateAngle) {
		super();
		this.length = length;
		this.paddleXCoordinate = paddleXCoordinate;
		this.paddleYCoordinate = paddleYCoordinate;
		this.rotateAngle=rotateAngle;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D gg = (Graphics2D) g.create();
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(this.getRotateAngle()), this.getPaddleXCoordinate() + this.getLength()/2, this.getPaddleYCoordinate() + 10);
		Rectangle paddle = new Rectangle(this.getPaddleXCoordinate(),this.getPaddleYCoordinate(),this.getLength(),20);
		Shape transformed = transform.createTransformedShape(paddle);
		gg.setColor(Color.RED);
		gg.fill(transformed);
		gg.dispose();
	}






}
