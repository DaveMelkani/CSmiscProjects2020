package frogger1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Background {
	private int zx,zy;
	private int zwidth=100;
	private int zheight=800;
	private Image zimg;
public Background(String background){
		zx=8;
		zy=8;
		zimg=getImage(background);
	}
private AffineTransform tx= AffineTransform.getTranslateInstance(zx, zy);

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(zimg, tx, null);
	}
	private void init(double a, double b){
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	
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

}

