package game;
import ball.*;
import brick.*;
import interfaces.*;
import paddle.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class RunningMode extends JPanel implements KeyListener {
	
	private JFrame f1 = new JFrame("BrickingBad / Gandhi");
	private ImageIcon background = new ImageIcon("src/images/background.jpg");
	private Random rgen = new Random();
	private boolean ballNotThrown = true;
	private boolean isPaused= false;
	private ArrayList<SimpleBrick> simpleBricksDrawed = new ArrayList<SimpleBrick>();
	private ArrayList<Ball> ballsDrawed = new ArrayList<Ball>();
	private Paddle paddle = new Paddle(200,290,680,0);
	private Ball ball = new Ball(paddle.getPaddleXCoordinate()+paddle.getLength()/2, paddle.getPaddleYCoordinate()-17,-1,-2,0);
	private SimpleBrick simplebrick = new SimpleBrick(0,0);
	
	public JFrame getF1() {
		return f1;
	}
	public void setF1(JFrame f1) {
		this.f1 = f1;
	}
	public boolean isBallNotThrown() {
		return ballNotThrown;
	}
	public void setBallNotThrown(boolean ballNotThrown) {
		this.ballNotThrown = ballNotThrown;
	}
	public boolean isPaused() {
		return isPaused;
	}
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	public ArrayList<SimpleBrick> getSimpleBricksDrawed() {
		return simpleBricksDrawed;
	}
	public void setSimpleBricksDrawed(ArrayList<SimpleBrick> simpleBricksDrawed) {
		this.simpleBricksDrawed = simpleBricksDrawed;
	}
	public ArrayList<Ball> getBallsDrawed() {
		return ballsDrawed;
	}
	public void setBallsDrawed(ArrayList<Ball> ballsDrawed) {
		this.ballsDrawed = ballsDrawed;
	}
	public Paddle getPaddle() {
		return paddle;
	}
	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}
	public Ball getBall() {
		return ball;
	}
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	public SimpleBrick getSimplebrick() {
		return simplebrick;
	}
	public void setSimplebrick(SimpleBrick simplebrick) {
		this.simplebrick = simplebrick;
	}
	public RunningMode() {
		setFocusable(true);
		addKeyListener(this);	
		f1.add(this);
		f1.setSize (1280,900);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);	
		f1.setResizable(false);
		paddle.setLength(f1.getWidth()/10);
		ballsDrawed.add(ball);
		////////SIMPLE BRICK INITIALIZING
		for(int i=1;i< 5;i++) {
			for(int j=1;j< 5;j++) {
				simplebrick= new SimpleBrick((135*i)+250,(135*j));
				simpleBricksDrawed.add(simplebrick);
			}
		}
		while (ballsDrawed.size()>0 && simpleBricksDrawed.size()>0) {
			this.repaint();
			for(int j=0;j<ballsDrawed.size();j++) {
				for(int i=0;i<simpleBricksDrawed.size();i++) {			
					Rectangle rect = new Rectangle(simpleBricksDrawed.get(i).getsBrickX(),simpleBricksDrawed.get(i).getsBrickY(),100,50);
					Rectangle ballRect = new Rectangle(ballsDrawed.get(j).getBallXcoor(),ballsDrawed.get(j).getBallYcoor(),17,17);
					Rectangle simpleBrickRect= rect;
					if(ballRect.intersects(simpleBrickRect)) {
						simpleBricksDrawed.remove(i);
						if(ballsDrawed.get(j).getBallXcoor() + 16 <= simpleBrickRect.x || ballsDrawed.get(j).getBallXcoor() + 1 >= simpleBrickRect.x + simpleBrickRect.width) {
							ballsDrawed.get(j).setBallXdir(ballsDrawed.get(j).getBallXdir()*-1);
						}else {
							ballsDrawed.get(j).setBallYdir(ballsDrawed.get(j).getBallYdir()*-1);
						}
					}
				}	
			}
		}
		if(ballsDrawed.size()==0) {
			JOptionPane.showMessageDialog(null,"Computer Wins!!");
			f1.setVisible(false);
			f1.dispose();
			System.exit(0);
		}
		if(simpleBricksDrawed.size()==0) {
			JOptionPane.showMessageDialog(null,"You win!!");
			f1.setVisible(false);
			f1.dispose();
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && paddle.getPaddleXCoordinate()+paddle.getLength() < f1.getWidth() ) {
			paddle.setPaddleXCoordinate(paddle.getPaddleXCoordinate()+paddle.getLength()/2);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT && paddle.getPaddleXCoordinate()>0 ) {
			paddle.setPaddleXCoordinate(paddle.getPaddleXCoordinate()-paddle.getLength()/2);
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			if(paddle.getRotateAngle() < 22.5)
			paddle.setRotateAngle(paddle.getRotateAngle()+10);
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			if(paddle.getRotateAngle() > -22.5) {
				paddle.setRotateAngle(paddle.getRotateAngle()-10);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			if(this.ballNotThrown==true) {
				this.ballNotThrown = false;
				ball.setBallXdir(-1);
				ball.setBallYdir(-2);
			}
		}		
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			if(isPaused==false) {
				this.isPaused = true;
			}else {
			    this.isPaused=false;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_D) {
			while(paddle.getRotateAngle()!=0)
			paddle.setRotateAngle(paddle.getRotateAngle()-10);
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			while(paddle.getRotateAngle()!=0) {
				paddle.setRotateAngle(paddle.getRotateAngle()+10);
			}
		}
	}
	public void paint(Graphics g) {
		g.drawImage(background.getImage(),0,0,null);
		paddle.draw(g);
		for(SimpleBrick obj : simpleBricksDrawed) {
			obj.draw(g);
		}
		for(Ball obj : ballsDrawed) {
			obj.draw(g);
		}
	}



}
