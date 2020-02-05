 
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dashie {
	public int x, y;// position of Dashie!
	double vx = 0;
	double vy = 0;
	
	private boolean alive;//
	private int width, height;
	private Image img; // image for the Dashie
	// private double vx, vy;// speed
	int score = 0;

	public Dashie(String fileName) {
		// TODO Auto-generated constructor stub
		x = 100;
		y = -100;
		// x=400;
		// y=400;
		// vx = 0;
		// vy = 0;
		img = getImage(fileName);
		init(x, y);
		width = 30;
		height = 35;
	}

	public Dashie(String fileName, int startX, int startY) {
		x = startX;
		y = startY;
		// vx = 0;
		// vy = 0;

		// hlelper funciton

	}

	public void setXY(int xpos, int ypos) {
		x = xpos;
		y = ypos;
		init(x,y); // updates the displacement translation (aka the position of a Dashie object)
	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		g.drawRect(x,y,width,height);

		if (y < 100) {
			g.drawString(("Score:") + Integer.toString(score), 100, 870);
		}
//		 g.fillRect(x, y, width, height);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Dashie.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public void move() {
		tx.setToTranslation(x, y);
		tx.translate(vx, vy);
		x+= vx;
		y += vy;
		
//		//tx.scale(.1, .1);
//
//		// x += vx;
//		// y += vy;
//		// teleporation is real
//		if (x < 0) {
//			x = 450;
//			y = 850;
//			// vx = 0;
//			// vy = 0;
//			tx.setToTranslation(x, y);
//			tx.scale(.1, .1);
//		}
//		if (x > 850) {
//			x = 450;
//			y = 850;
//			tx.setToTranslation(x, y);
//			tx.scale(.3, .3);
//		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// public double getVx() {
	// return vx;
	// }

	/*
	 * public void setVx(double vx) { this.vx = vx; }
	 * 
	 * public void setVX(double vx) { this.vx = vx; }
	 * 
	 * public void setVY(double vy) { this.vy = vy; }
	 */
	public void resetXY() {
		x = 100;
		y = 555;
	}

	public boolean collided(int ox, int oy, int ow, int oh) {
		Rectangle obs = new Rectangle(ox, oy, ow, oh);
		Rectangle dashie = new Rectangle(x, y, width, height);
		//System.out.println(obs+":"+dashie);
		return obs.intersects(dashie);
	}

	public void setVx(double d) {
		// TODO Auto-generated method stub
		vx = d;
	}

}









