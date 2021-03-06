package frogger1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

/**
 * @author eagle
 *
 */
public class Car {
	private int x, y;
	public int width, height;
	private Image img;
	private double vx;
	private double vy;

	public Car(String fileName, int X, int Y,int vxstart) {
		x = X;
		y = Y;
		vy = 0;
		vx = vxstart;
		img = getImage(fileName);
		init(x, y);
		height = 20;
		width = 50;
	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	// draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		//g.fillRect(x, y, width, height);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		//tx.scale(.1, .1);
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

	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public int getHeight(){
		return height;
	}
	
	
	public void move() {
		tx.translate(vx, vy);
		x += vx;
		y += vy;
		System.out.println(x);
		
		
		if (x <0) {
			x = 900;
//import new image
			tx.setToTranslation(x, y);
		//tx.scale(.05, .05);
			System.out.println("yes");
		}
	}

	public void setVX(double vx) {
		this.vx = vx;
	}

}

