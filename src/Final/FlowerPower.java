package Final;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


class FlowerPower extends JPanel implements KeyListener{
	
	private static final int MAIN_LOOP = 1;
	private static final int ENDGAME = 0;
	private int GAME_STATE;
	private Garden garden;
	private MathProblem problem;
	String name;
	
	private int score = 0;
	
	//Game state continues until user is done
	FlowerPower(){
		
		GAME_STATE = MAIN_LOOP;
		garden = new Garden();
		problem = new MathProblem();
		addKeyListener(this);
		name = JOptionPane.showInputDialog("Please enter your name");
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
	requestFocusInWindow();
	//use R,G,B to define custom colors.
	g.setColor(new Color(51, 204, 255));
	
	//draw a solid background
	g.fillRect(0,0,800,600);
	
	ImageIcon solo = new ImageIcon("C:/Users/Treys/Downloads/bird.png");
	solo.paintIcon(null,g,100,60);
	solo.paintIcon(null,g,230,140);
	
	//grass
	g.setColor(new Color(128, 255, 0));
	g.fillRect(0,400,800,200);
	
	//sun
	g.setColor(new Color(255,255,0));
	g.fillOval(0, 0, 100, 100);
	
	
	g.setColor(new Color(0,0,0));
	g.drawString("Score: " + score, 50, 20);
	g.drawString("Name: " + name, 250, 20);
	
	//Garden
	garden.draw(g);
	if(GAME_STATE == MAIN_LOOP)
	{
		problem.draw(g);
	}
	else {
		g.drawString("GAME OVER", 400, 300);
	}
	
	}
	// Main Method
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,600);
		window.setContentPane(new FlowerPower());
		window.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	//This method detects userinput
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (GAME_STATE == ENDGAME)
		{
			
			int value =  e.getKeyCode();
			if (value == KeyEvent.VK_Y)
			{
				garden.clear();
				GAME_STATE = MAIN_LOOP;
				score = 0;
	
			}
			if (value == KeyEvent.VK_N)
			{
				System.exit(0);
			}
			
		}
		
		// TODO Auto-generated method stub
		int gardenSize = garden.plants.size();	
		
		int value = problem.receiveUserInput(e);
		if(value == Garden.FLOWER)
		{
			garden.newFlower();
			score = score  + 10;
		}
		if(value == Garden.WEED)
		{
			garden.newWeed();
			score = score  - 5;
		}
		if(value!= Garden.CONTINUE) {
			if( gardenSize == 15 )
			{
				GAME_STATE = ENDGAME;
				repaint();
			}
			else 
			{
				problem = new MathProblem();
				repaint();
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
	
	
}
