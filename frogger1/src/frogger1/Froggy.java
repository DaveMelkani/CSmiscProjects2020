package frogger1;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

//class to a represent a frog object in a game of Frogger
public class Froggy {
	// atrivutes of a frog
	public int x, y;// position of Froggy!
	private boolean alive;//
	private int width, height;
	private Image img; // image for the Frog
	private double vx, vy;// speed
	int score = 0;

	// write the constructor for Froggy which takes in
	// a string fileName that will be used for the image setup
	// set x and y to be in the middle of a 400x400 screen
	// set width and height to 50

	// public nameOfClass(/any parametres for constructo/){
	// //assignment statements for attributes ( instance varibles)
	// }

	public Froggy(String fileName) {
		x = 400;
		y = 800;
		// x=400;
		// y=400;
		vx = 0;
		vy = 0;
		img = getImage(fileName);
		init(x, y);
		width = 30;
		height = 35;
	}

	public Froggy(String fileName, int startX, int startY) {
		x = startX;
		y = startY;
		vx = 0;
		vy = 0;

		// hlelper funciton

	}

	public void translatedWithStraws() {
		x += vx;
		tx.setToTranslation(x, y);
		tx.scale(.05, .05);
		if (x < 0) {
			resetXY();
			vx = 0;
			vy = 0;
		}
	}

	public void setXY(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	// draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		if (y < 100) {
			g.drawString(("Score:") + Integer.toString(score), 100, 870);
		}
		// g.fillRect(x, y, width, height);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.3, .3);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Froggy.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public void move() {
		tx.setToTranslation(x, y);
		tx.translate(.001, 5);
		tx.scale(.3, .3);

		x += vx;
		y += vy;
		// teleporation is real
		if (x < 0) {
			x = 450;
			y = 850;
			vx = 0;
			vy = 0;
			tx.setToTranslation(x, y);
			tx.scale(.3, .3);
		}
		if (x > 850) {
			x = 450;
			y = 850;
			tx.setToTranslation(x, y);
			tx.scale(.3, .3);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public void setVX(double vx) {
		this.vx = vx;
	}

	public void setVY(double vy) {
		this.vy = vy;
	}

	public void resetXY() {
		x = 500;
		y = 850;
	}

	public boolean collided(int ox, int oy, int ow, int oh) {
		Rectangle obs = new Rectangle(ox, oy, ow, oh);
		Rectangle froggy = new Rectangle(x, y, width, height);
		return obs.intersects(froggy);
	}

	/*
	 * private double getVX(){ return vx; } private double getVY(){ return vy; }
	 */

}
