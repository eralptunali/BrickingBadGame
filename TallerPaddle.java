package powerups;

import javax.swing.ImageIcon;

public class TallerPaddle extends PowerUp {

	public TallerPaddle(int pXCoor, int pYCoor) {
		super(pXCoor, pYCoor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		super.setpYCoor(super.getpYCoor()+2);
	}
	private ImageIcon i = new ImageIcon("src/images/tallerPaddle.jpg");
	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}
	
}
