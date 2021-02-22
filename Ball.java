package ball;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import interfaces.*;

public class Ball extends JPanel implements Drawable{
	
	private int ballXcoor;
	private int ballYcoor;
	private int ballXdir;
	private int ballYdir;
	private int damage;

	
	public int getBallXcoor() {
		return ballXcoor;
	}
	public void setBallXcoor(int ballXcoor) {
		this.ballXcoor = ballXcoor;
	}
	public int getBallYcoor() {
		return ballYcoor;
	}
	public void setBallYcoor(int ballYcoor) {
		this.ballYcoor = ballYcoor;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	
	public Ball(int ballXcoor, int ballYcoor, int ballXdir, int ballYdir, int damage) {
		super();
		this.ballXcoor = ballXcoor;
		this.ballYcoor = ballYcoor;
		this.ballXdir = ballXdir;
		this.ballYdir = ballYdir;
		this.damage=damage;
	}
	public int getBallXdir() {
		return ballXdir;
	}
	public void setBallXdir(int ballXdir) {
		this.ballXdir = ballXdir;
	}
	public int getBallYdir() {
		return ballYdir;
	}
	public void setBallYdir(int ballYdir) {
		this.ballYdir = ballYdir;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillOval(this.getBallXcoor(), this.getBallYcoor(), 17, 17);
	}
	
	
}
