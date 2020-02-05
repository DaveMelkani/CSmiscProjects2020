/*
a * Comments: 
 * PLZZ BE NICE :)
 * Use space bar to play
 * game is cool, would have been nice with the animation that shows that u lose the squares when you go over the tower
 * It's pretty cool, I like the name of the game :) and the sprite and the infinite scrolling background, score counter possibly to add more fun?, some blocks disappear almost
 * 
 * The concept was good but you can just spam the space bar and beat the game. You should have made it so that if you go too high you lose.
 * nice concept, very easy tho
 * good game but easy win
 * 
 * 
 * very cool but a little glitchy, lots of gaps in the tower
 * 
 * what is the objective    
 * cool mechanics but not sure what to do
 *little glitches in gameplay but the game works well as intended
 *interesting game
 *i like the picture
 *    
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

	int screen_width = 1200;
	int screen_height = 700;
//	Dashie dashie;
	Background b;
	
	int Max1 = (int)(Math.random()*7)+1;
	int Max2 = (int)(Math.random()*7)+1;
	int Max3 = (int)(Math.random()*7)+1;
	
	int maxDashies = 10;
	ArrayList<Dashie> dashies = new ArrayList<Dashie>();
	ArrayList<Dashie> dashiesInPlay = new ArrayList<Dashie>();
	int dashieCounter = 1;
	
	ArrayList<Stack> stack0 = new ArrayList<Stack>();
	ArrayList<Stack> stack1 = new ArrayList<Stack>();
	ArrayList<Stack> stack2 = new ArrayList<Stack>();
	
	
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
		b.paint(g);
		
		for(Dashie d:dashies){
			d.paint(g);
//			System.out.println(d.getY());
		}
		// g.drawString(("my_variable:") + Integer.toString(my_variable), 0, 870);

		for (int i = 0; i < stack0.size(); i++) {
			stack0.get(i).paint(g);
		}
		for (int i = 0; i < stack1.size(); i++) {
			stack1.get(i).paint(g);			
		}
		for (int i = 0; i < stack2.size(); i++) {
			stack2.get(i).paint(g);
		}
//79
	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	public void update() {
		
		Max3 = (int)(Math.random()*7)+1;
		//System.out.println("........././/////////./././."+Max2);
		//System.out.println("...................................lives"+lives);
		for(Dashie d: dashies) {
			d.move();
		}
		
		
		for (int i = 0; i < stack0.size(); i++) {
			stack0.get(i).move();
			
			System.out.println(dashieCounter);
			for(int k = 0; k< dashiesInPlay.size(); k++){
				if(dashiesInPlay.get(k).collided(stack0.get(i).getX(), stack0.get(i).getY(), stack0.get(i).getWidth(), stack0.get(i).getHeight())&&stack0.get(i).affect) {
//					d.setVx(stack2.get(i).getVx());
					dashiesInPlay.get(k).setXY(100, -100);
					dashiesInPlay.remove(k);
					dashieCounter = dashiesInPlay.size();
					for(int j = dashieCounter-1; j>=0; j--) {
						dashiesInPlay.get(j).setXY(100, 555-30*(dashieCounter-1-j));
					}
					stack0.get(i).affect = false;
				}
			}
			
			if (stack0.get(i).getX() < -20) {
				int tempx = stack0.get(i).getX();
				stack0.clear();
				Max3 = (int)(Math.random()*7)+1;
				for (int j = 0; j < Max3; j++) {
					stack0.add(new Stack("StacksBlock.png", 1300+tempx , (587-(Max3*29)+(j*29)), -5));	
				}
				break;
			}
			
		}
		

	
		for (int i = 0; i < stack1.size(); i++) {
			stack1.get(i).move();
			
			System.out.println(dashieCounter);
			for(int k = 0; k< dashiesInPlay.size(); k++){
				if(dashiesInPlay.get(k).collided(stack1.get(i).getX(), stack1.get(i).getY(), stack1.get(i).getWidth(), stack1.get(i).getHeight())&&stack1.get(i).affect) {
//					d.setVx(stack2.get(i).getVx());
					dashiesInPlay.get(k).setXY(100, -100);
					dashiesInPlay.remove(k);
					dashieCounter = dashiesInPlay.size();
					for(int j = dashieCounter-1; j>=0; j--) {
						dashiesInPlay.get(j).setXY(100, 555-30*(dashieCounter-1-j));
					}
					stack1.get(i).affect = false;
				}
			}
			
			if (stack1.get(i).getX() < -20) {
				int tempx = stack1.get(i).getX();
				stack1.clear();
				Max3 = (int)(Math.random()*7)+1;
				for (int j = 0; j < Max3; j++) {
					stack1.add(new Stack("StacksBlock.png", 1300+tempx , (587-(Max3*29)+(j*29)), -5));	
				}
				break;
			}
		}
		for (int i = 0; i < stack2.size(); i++) {
			stack2.get(i).move();
			
			System.out.println(dashieCounter);
			for(int k = 0; k< dashiesInPlay.size(); k++){
				if(dashiesInPlay.get(k).collided(stack2.get(i).getX(), stack2.get(i).getY(), stack2.get(i).getWidth(), stack2.get(i).getHeight())&&stack2.get(i).affect) {
//					d.setVx(stack2.get(i).getVx());
					dashiesInPlay.get(k).setXY(100, -100);
					dashiesInPlay.remove(k);
					dashieCounter = dashiesInPlay.size();
//					for(int j = dashieCounter-1; j>=0; j--) {
//						dashiesInPlay.get(j).setXY(100, 555-30*(dashieCounter-1-j));
//					}
					stack2.get(i).affect = false;
				}
			}
			
			if (stack2.get(i).getX() < -20) {
				int tempx = stack2.get(i).getX();
				stack2.clear();
				Max3 = (int)(Math.random()*7)+1;
				for (int j = 0; j < Max3; j++) {
					stack2.add(new Stack("StacksBlock.png", 1300+tempx , (587-(Max3*29)+(j*29)), -5));	
				}
				break;
			}
		}
		
		
		for(int l =0; l< maxDashies; l ++) {
			dashiesInPlay.remove(null);
		}
		
		for(int l =0; l< dashiesInPlay.size(); l ++) {
			dashiesInPlay.get(l).setXY(100, 555-30*(dashiesInPlay.size()-1-l));
			System.out.println(l + ": " +dashiesInPlay.get(l).getY());
		}
		
		if(dashieCounter == 0) {
			System.exit(-1);
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
		f.setTitle("DashieStacks");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);

		b = new Background("Dashiebackground.jpg");
        
		// sprite instantiation
//		dashie = new Dashie("Dashie3.png");
//		dashie.setXY(100, 555);
//		dashies.add(dashie);
		for(int i = 0; i< maxDashies; i++){
			dashies.add(new Dashie("DashieArt.png"));
		}
		dashiesInPlay.add(dashies.get(0));
		
		
		// create the instances of objects for your specific arrays
    	
    	//int start = (int)(Math.random()*4+1);
    	//Max1 = (int)(Math.random()*7)+1;
    	//System.out.println("............max1 "+Max1);
		for (int i = 0; i < Max1; i++) {
			stack0.add(new Stack("StacksBlock.png", 900, (587-(Max1*29)+(i*29)), -5));
			//System.out.println("........................max1 "+Max1);

		}
		//start = (int)(Math.random()*4+1);
		//Max2 = (int)(Math.random()*7)+1;
		//System.out.println("........................max2 "+Max2);
		for(int j=0; j<Max2;j++){
			stack1.add(new Stack("StacksBlock.png", 1300, (587-(Max2*29)+(j*29)), -5));
		}
		//start = (int)(Math.random()*4+1);
		//Max3 = (int)(Math.random()*7)+1;
		//System.out.println("...................................max3 "+Max3);

		for(int k=0; k<Max3;k++){
			stack2.add(new Stack("StacksBlock.png", 1700,(587-(Max3*29)+(k*29)), -5));
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
		
	/*	System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 38) {
			dashie.setVY(-5);
			dashie.setVX(0);
		}
		if (e.getKeyCode() == 40) {
			dashie.setVY(5);
			dashie.setVX(0);
		}
		if (e.getKeyCode() == 37) {
			dashie.setVX(-5);
			dashie.setVY(0);

		}
		if (e.getKeyCode() == 39) {
			dashie.setVX(5);
			dashie.setVY(0);
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==32){
			if(dashieCounter<10){
				dashiesInPlay.add(dashies.get(dashieCounter));
				dashieCounter++;
				for(int i = 0; i < dashiesInPlay.size(); i++) {
					
					dashiesInPlay.get(i).setXY(100, 555-30*(dashieCounter-1-i));
					
				}
				dashiesInPlay.get((dashieCounter)).setVx(0);
				
			}
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








