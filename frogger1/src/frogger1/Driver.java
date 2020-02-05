package frogger1;


/*
 * please don't roast JP 
 * if it says you lost then just rerun it
 * 
 * saucy
 * 
 * I like the text when you lose in the first row of cars and the graphics are nice and I like how the cars have different spacing
 * pretty art :)))))))
 * 
 * collisions work pretty well 
 * but the first row of logs are hard to pass but that makes it fun and challenging :)
 * 
 * p challenging and fun, collisions work nicely (except for the blue cars)
 * log makes u go flying its them knockback sticks
 * 
 * the game is unwinnable
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	int screen_width = 900;
	int screen_height = 900;
	Froggy froggy;
	Background background;
	Car[] carRow0 = new Car[6];
	Car[] carRow1 = new Car[6];
	Car[] carRow2 = new Car[6];
	Straw[] strawRow0 = new Straw[10];
	Straw[] strawRow1 = new Straw[10];
	// Background bg;
	int my_variable = 0; // example
	int lives = 3;
	int score = 0;

	public void paint(Graphics g) {

		super.paintComponent(g);
		// bg.paint(g);

		g.setFont(font);
		g.setColor(Color.RED);
		// g.drawString(("my_variable:") + Integer.toString(my_variable), 0, 870);
		g.setFont(font2);
		g.setColor(Color.CYAN);
		// Car f = new Car("background.png");
		// paint sprite
		// froggy.paint(g);
		background.paint(g);
		// g.drawString(("my_variable:") + Integer.toString(my_variable), 0, 870);

		for (int i = 0; i < carRow0.length; i++) {
			carRow0[i].paint(g);
			carRow1[i].paint(g);
			carRow2[i].paint(g);
			if (froggy.collided(carRow0[i].getX(), carRow0[i].getY(), carRow0[i].getWidth(), carRow0[i].getHeight())) {
				froggy.resetXY();
				lives--;
			}
			if (froggy.collided(carRow1[i].getX(), carRow1[i].getY(), carRow1[i].getWidth(), carRow1[i].getHeight())) {
				froggy.resetXY();
				lives--;
			}
			if (froggy.collided(carRow2[i].getX(), carRow2[i].getY(), carRow2[i].getWidth(), carRow2[i].getHeight())) {
				froggy.resetXY();
				lives--;
			}

		}
			if (froggy.getY()<80) {
					score++;
					froggy.resetXY();
					froggy.setVx(0);
				}
			if (froggy.getX()<1) {
				lives--;
							}
			if (froggy.getX()>890) {
				lives--;
							}
		for (int i = 0; i < strawRow0.length; i++) {
			strawRow0[i].paint(g);
			strawRow1[i].paint(g);
			if (froggy.collided(strawRow0[i].getX(), strawRow0[i].getY(), strawRow0[i].getWidth(),
					strawRow0[i].getHeight())) {
				// froggy.setVX(-.25);
				froggy.setVX(-5);
				// froggy.translatedWithStraws();

				//froggy.setXY(strawRow0[i].getX(), 100);
				// froggy.translatedWithStraws();
			}
			if (froggy.collided(strawRow1[i].getX(), strawRow1[i].getY(), strawRow1[i].getWidth(),
					strawRow1[i].getHeight())) {
				froggy.setVX(-10);
				// froggy.translatedWithStraws();
				//System.out.println(froggy.getVx() + "V");
				//froggy.setXY(strawRow0[i].getX(), 200);
				// System.exit(-1);
			}

		}
		g.drawString(("Lives:") + Integer.toString(lives), 0, 870);
		g.drawString(("score:") + Integer.toString(score), 200, 870);

		froggy.paint(g);
		if (lives == 0) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 900, 900);
			g.setColor(Color.white);
			g.drawString("come on man", 300, 400);
			g.drawString(("Lives:") + Integer.toString(lives), 0, 870);

		}
		if (score == 2) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 900, 900);
			g.setColor(Color.black);
			g.drawString("you win", 300, 400);
			//.drawString(("Lives:") + Integer.toString(lives), 0, 870);

		}
	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	public void update() {
		froggy.move();
		for (int i = 0; i < strawRow0.length; i++) {
			strawRow0[i].move();
			strawRow1[i].move();
		}
		for (int i = 0; i < carRow0.length; i++) {
			carRow0[i].move();
			carRow1[i].move();
			carRow2[i].move();
		}
	}

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
		f.setTitle("Frogger");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);

		background = new Background("background.png");

		// sprite instantiation
		froggy = new Froggy("BigFrog.png");

		// create the instances of objects for your specific arrays
		for (int i = 0; i < carRow0.length; i++) {
			carRow0[i] = new Car("supper.png", i * 100, 720, -5);
			carRow1[i] = new Car("superract.png", i * 230, 700, -10);
			carRow2[i] = new Car("crazy.png", i * 150, 600, -2);

		}

		for (int i = 0; i < strawRow0.length; i++) {
			strawRow0[i] = new Straw("fire.png", i * 100, 100, -5);
			strawRow1[i] = new Straw("fire.png", i * 230, 200, -10);

		}
		

		// player.addMouseListener(this);
		// bg = new Background("background.png");
		// do not add to frame, call paint on
		// these objects in paint method

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
		if (e.getKeyCode() == 38) {
			froggy.setVY(-5);
			froggy.setVX(0);
		}
		if (e.getKeyCode() == 40) {
			froggy.setVY(5);
			froggy.setVX(0);
		}
		if (e.getKeyCode() == 37) {
			froggy.setVX(-5);
			froggy.setVY(0);

		}
		if (e.getKeyCode() == 39) {
			froggy.setVX(5);
			froggy.setVY(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38) {
			froggy.setVY(0);

		}
		if (e.getKeyCode() == 40) {
			froggy.setVY(0);
		}
		if (e.getKeyCode() == 37) {
			froggy.setVX(0);
		}
		if (e.getKeyCode() == 39) {
			froggy.setVX(0);
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

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void reset() {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

