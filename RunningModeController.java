package controllers;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


import game.RunningMode;

public class RunningModeController implements KeyListener {
	private RunningMode runningMode = new RunningMode();
	public RunningModeController(RunningMode runningMode) {
		super();
		this.runningMode = runningMode;
		this.start();
	}
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {	
			if(runningMode.isPaused()) {

			}else {
				if(runningMode.getBallsDrawed().size()>0) {
					if(runningMode.isBallNotThrown()) {
						runningMode.getBall().setBallXdir(0);
						runningMode.getBall().setBallYdir(0);
						runningMode.getBall().setBallXcoor(runningMode.getPaddle().getPaddleXCoordinate()+runningMode.getPaddle().getLength()/2);
						runningMode.getBall().setBallYcoor(runningMode.getPaddle().getPaddleYCoordinate()-17);
					}
					for(int i = 0;i<runningMode.getBallsDrawed().size();i++) {
						runningMode.getBallsDrawed().get(i).setBallXcoor(runningMode.getBallsDrawed().get(i).getBallXcoor()+runningMode.getBallsDrawed().get(i).getBallXdir());
						runningMode.getBallsDrawed().get(i).setBallYcoor(runningMode.getBallsDrawed().get(i).getBallYcoor()+runningMode.getBallsDrawed().get(i).getBallYdir());
						if(runningMode.getBallsDrawed().get(i).getBallXcoor()<0) {
							runningMode.getBallsDrawed().get(i).setBallXdir(runningMode.getBallsDrawed().get(i).getBallXdir()*-1);
						}
						if(runningMode.getBallsDrawed().get(i).getBallYcoor()<0) {
							runningMode.getBallsDrawed().get(i).setBallYdir(runningMode.getBallsDrawed().get(i).getBallYdir()*-1);
						}
						if(runningMode.getBallsDrawed().get(i).getBallXcoor() > 1270) {
							runningMode.getBallsDrawed().get(i).setBallXdir(runningMode.getBallsDrawed().get(i).getBallXdir()*-1);
						}
						if(new Rectangle(runningMode.getBallsDrawed().get(i).getBallXcoor(),runningMode.getBallsDrawed().get(i).getBallYcoor(),17,17).intersects(new Rectangle(runningMode.getPaddle().getPaddleXCoordinate(),680,200,20))) {
							if(runningMode.getBallsDrawed().get(i).getBallXcoor() + 16 <= runningMode.getPaddle().getPaddleXCoordinate() ||
									runningMode.getBallsDrawed().get(i).getBallXcoor() + 1 >= runningMode.getPaddle().getPaddleXCoordinate() + runningMode.getPaddle().getLength()) {
								runningMode.getBallsDrawed().get(i).setBallXdir(runningMode.getBallsDrawed().get(i).getBallXdir()*-1);
							}else {
								runningMode.getBallsDrawed().get(i).setBallYdir(runningMode.getBallsDrawed().get(i).getBallYdir()*-1);
							}
						}
						if(runningMode.getBallsDrawed().get(i).getBallYcoor()>750) {
							runningMode.getBallsDrawed().remove(i);
						}
					}
				}
			}
		}
	};	
	public void start() {
		myTimer.scheduleAtFixedRate(task,10,1000);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && runningMode.getPaddle().getPaddleXCoordinate()+runningMode.getPaddle().getLength() < runningMode.getF1().getWidth() ) {
			runningMode.getPaddle().setPaddleXCoordinate(runningMode.getPaddle().getPaddleXCoordinate()+runningMode.getPaddle().getLength()/2);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT && runningMode.getPaddle().getPaddleXCoordinate()>0 ) {
			runningMode.getPaddle().setPaddleXCoordinate(runningMode.getPaddle().getPaddleXCoordinate()-runningMode.getPaddle().getLength()/2);
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			if(runningMode.getPaddle().getRotateAngle() < 22.5)
				runningMode.getPaddle().setRotateAngle(runningMode.getPaddle().getRotateAngle()+10);
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			if(runningMode.getPaddle().getRotateAngle() > -22.5) {
				runningMode.getPaddle().setRotateAngle(runningMode.getPaddle().getRotateAngle()-10);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			if(runningMode.isBallNotThrown()==true) {
				runningMode.setBallNotThrown(false);
				runningMode.getBall().setBallXdir(-1);
				runningMode.getBall().setBallYdir(-2);
			}
		}		
		/*if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			if(isPaused==false) {
				this.isPaused = true;
			}else {
			    this.isPaused=false;
			}
		}*/
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
