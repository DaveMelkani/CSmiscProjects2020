/*
 * Plz don't be mean :(
 * 
 * 
 *comments:
	* runs well!
	 * randomize enemy movement
	 * cool enemy movement, implement eating
	 * good enemy movement, but the player randomly starts growing sometimes.
	 * the game looks good, but your player doesn't eat all the food it goes over, also it just gets bigger, also it is not centered
	 * 
	 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */









import java.applet.Applet;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener,
		MouseListener, MouseMotionListener {
	/*
	 * public void mouseGlide(int x1, int y1, int x2, int y2, int t, int n) {
	 * try { Robot r = new Robot(); double dx = (x2 - x1) / ((double) n); double
	 * dy = (y2 - y1) / ((double) n); double dt = t / ((double) n); for (int
	 * step = 1; step <= n; step++) { Thread.sleep((int) dt); r.mouseMove((int)
	 * (x1 + dx * step), (int) (y1 + dy * step)); } } catch (AWTException e) {
	 * e.printStackTrace(); } catch (InterruptedException e) {
	 * e.printStackTrace(); } } public static void main1 (String[] args) { //
	 * program initialization Driver x = new Driver(); // we declare what are we
	 * gonna use
	 * 
	 * x.mouseGlide(400,500,700,700,5000,10000);
	 */

	
	
	
	// size of jframe
	int screen_width = 800;
	int screen_height = 600;

	int max = 2500;
	int max2 = 3000;
	int enem = 3000;

	int[] rads = new int[max];

	int[] x = new int[max];
	int[] y = new int[max];

	Color[] colors = new Color[max];

	int[] enx = new int[enem];
	int[] eny = new int[enem];
	// player var
	int pw = 30;
	int px = screen_width / 2 - pw / 2;
	int py = screen_height / 2 - pw / 2;
	// declare a new set of array for food
	int[] foodx = new int[max];
	int[] foody = new int[max];
	// player velocity
	double pvx = 0;
	double pvy = 0;

	double newvx = 10;
	double newvy = 10;

	double distance;
	double sum;
	// enemies velocity
	int envx = 2;
	int envy = 2;

	// reading a val from a 1d array
	// System.out.print( x[0]); //reading value
	// x[0] = 5; //writing is similar to regular variables but now you have to
	// specify WHERE
	public void paint(Graphics g) {
		super.paintComponent(g);

		// gridlines
		for (int i = 0; i < screen_width; i++) {
			g.drawLine(0, i * 30, screen_width, i * 30);
		}
		for (int i = 0; i < screen_height; i++) {
			g.drawLine(i * 30, 0, i * 30, screen_height);
		}

		// write loop setup to visit every possible index in x
		for (int i = 0; i < x.length; i++) {
			g.setColor(colors[i]);
			g.fillOval(x[i], y[i], rads[i], rads[i]);

			// draw food
			g.setColor(Color.blue);
			g.fillOval(foodx[i], foody[i], 10, 10);
		}

		// draw people
		g.setColor(Color.red);
		g.fillOval(px, py, pw, pw);

	}// end of paint method - put code above for anything dealing with drawing -

	Font font = new Font("Courier New", 1, 50);

	public void update() {
		// px += pvx;
		// py += pvy;
		// System.out.println(pw);
		// moving the background (enemies and food)
		for (int i = 0; i < foodx.length; i++) {
			foodx[i] += pvx;
			foody[i] += pvy;

			x[i] += enx[i] + pvx;
			y[i] += eny[i] + pvy;

			x[i] += pvx;
			y[i] += pvy;

			// x[i]+=5;
			// y[i]+= 5;

			// if it gets too small
			if (pw <= 0) {
				pw = 30;
			}

			// distance formula, food:fx, fy player px py
			double dist = Math.sqrt(Math.pow((foodx[i]) - (px), 2)
					+ Math.pow((foody[i]) - (py), 2));
			double sumRad = (10 + pw) / 2;
			if (dist < pw / 2 - 2) {

				pw = pw + 1;

				// pvx -= .1;
				// pvy -= .1;

				foodx[i] += 900;
				foody[i] += 900;

				newvx *= 0.999;
				newvy *= 0.999;
				break;
			}
			// enemy
			double distE = Math.sqrt(Math.pow((x[i]) - (px), 2)
					+ Math.pow((y[i]) - (py), 2));
			// double sumRad = (10+pw)/2;
			if (distE < pw / 2 - 2) {

				pw += 1;

				// pvx -= .1;
				// pvy -= .1;

				x[i] += 900;
				y[i] += 900;

				newvx *= 0.999;
				newvy *= 0.999;
				break;
			}

			// see if you eat an enemy

		}

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("DJDave123 <3 Tpuh");
		f.setSize(screen_width, screen_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);

		// this special "method" is called the Constructor
		// initialized structures here!

		// this entir block generates random values
		// arrays which are teh properties of the cells
		// enemy
		int counter = 0;
		while (counter < max) {

			enx[counter] = (int) (Math.random() * 5 + 0);
			eny[counter] = (int) (Math.random() * 5 + 0);

			// x->[-500000, 500000]
			// x->[-500000, 500000]
			foodx[counter] = (int) (Math.random() * (9001) - 4500);
			foody[counter] = (int) (Math.random() * (9001) - 4500);

			// create colors from your color lab
			Color newColor = new Color((int) (Math.random() * 256 + 0),
					(int) (Math.random() * 256 + 0),
					(int) (Math.random() * 256 + 0));
			colors[counter] = newColor;
			counter++;
		}
		int supers = 0;
		while (supers < 700) {
			rads[supers] = (int) (Math.random() * 30 + 5);
			x[supers] = (int) (Math.random() * max - 4500);
			y[supers] = (int) (Math.random() * max - 4500);
			supers++;
		}

		f.add(this);

		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case 38:
			pvy = 10;
			if (pvx != 0) {
				pvx = 0.75 * pvx;
				pvy = 0.75 * pvy;
			}

			break;
		case 40:
			if (pvx != 0) {
				if (pvx > 0) {
					pvx = +(int) Math.sqrt(50);
				} else {
					pvy = -(int) Math.sqrt(50);
				}
			} else {
				pvy = -10;
			}
			break;

		case 37:
			pvx = 10;
			break;
		case 39:
			pvx = -10;
			break;
		case 32:
			pw -= 5;
			newvx /= .998;
			newvy /= .998;
			/*
			 * case 87:
			 * 
			 * pvx = (int)(Math.sqrt(200)); pvy = (int)(Math.sqrt(200)); break;
			 */
		}
		if (pvx != 0 && pvy != 0) {
			if (pvx < 0) {
				pvx = -(Math.sqrt((Math.pow(newvx, 2)) / 2));
			}
			if (pvx > 0) {
				pvx = (Math.sqrt((Math.pow(newvx, 2)) / 2));
			}
			if (pvy < 0) {
				pvy = -(Math.sqrt((Math.pow(newvy, 2)) / 2));
			}
			if (pvy > 0) {
				pvy = (Math.sqrt((Math.pow(newvy, 2)) / 2));
				;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case 38:
			pvy = 0;
			break;
		case 40:
			pvy = 0;
			break;
		case 37:
			pvx = 0;
			break;
		case 39:
			pvx = 0;
			break;

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent m) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println(m.getX()+ ":" +m.getY());
		 * 
		 * if (m.getX()<px) { pvx = -3; } else { pvx = 3; } if (m.getY()<py) {
		 * pvy = -3; } else { pvy = 3; }
		 */
	}

}
