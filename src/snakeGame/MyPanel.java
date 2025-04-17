package snakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements KeyListener, ActionListener  {
	
	
	final int screenWidth = 500;
	final int screenHeight = 500;
	final int tileSize = 25;
	int score;
	Boolean move;
	int bodyParts;
	Integer[] xSnake;
	Integer[] ySnake;
	int xApple;
	int yApple;
	char direction;
	Timer timer;
	Random random = new Random();
	MyPanel(){
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.addKeyListener(this);
		randomNumber();
		
		direction = 'R';
		timer = new Timer(200,this);
		timer.start();
		move = true;
		bodyParts = 3;
		xSnake = new Integer[400];
		ySnake = new Integer[400];
		xSnake[0] =	125;
		ySnake[0] = 125;
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//*g.setColor(Color.gray);
		//for(int i = 0; i < 20; i++) {
		//g.drawLine(0, i*tileSize, screenWidth, i*tileSize);
		//g.drawLine(i*tileSize, 0, i*tileSize, screenHeight);
		//}
		//
		
		g.setColor(Color.red);
		g.fillOval(xApple, yApple, tileSize, tileSize);
		
		
		g.setColor(Color.decode("#008000"));
		g.fillRect(xSnake[0], ySnake[0], tileSize, tileSize);
		
		g.setColor(Color.decode("#006400"));
		
		for(int i = 1; i < bodyParts; i++) {
			
			g.fillRect(xSnake[i], ySnake[i], tileSize, tileSize);
		}

		
		
	}
	public void MyForLoop() {
		for (int i = bodyParts; i > 0; i--) {
			xSnake[i] = xSnake[i-1];
			ySnake[i] = ySnake[i-1];
			
 		}
	}
	public void randomNumber() {
		xApple = (random.nextInt(0, screenWidth)/tileSize)*tileSize;
		yApple = (random.nextInt(0, screenHeight)/tileSize)*tileSize;
		
	}
	
	public void collision() {
		
		if (xSnake[0] == xApple && ySnake[0] == yApple) {
			bodyParts++;
			score++;
			System.out.println(xSnake.length);
			randomNumber();
			repaint();
		}
		
		if(xSnake[0] >= screenWidth || xSnake[0] < 0 || ySnake[0] >= screenHeight || ySnake[0] < 0) {
			timer.stop();
		}
		for (int i = bodyParts; i > 0; i--) {
			
			if(xSnake[0] == xSnake[i] && ySnake[0] == ySnake[i]) {
				
			}
		}
		
		
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		MyForLoop();
		switch(direction) {
		case 'U':
			ySnake[0] -= tileSize;
			repaint();
			break;
		case 'D':
			ySnake[0] += tileSize;
			repaint();
			break;
		case 'L':
			xSnake[0] -= tileSize;
			repaint();
			break;
		case 'R':
			xSnake[0] += tileSize;
			repaint();
			break;
			
		}
		collision();

	}


	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 83:
			if (direction != 'U') {
			direction = 'D';
			}
			break;
		case 87:
			if (direction != 'D') {
			direction = 'U';
			
			}
			break;
		case 65:
			if (direction != 'R') {
			direction = 'L';
			}
			break;
		case 68:
			if (direction != 'L') {
			direction = 'R';
			}
			break;
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	
	
	
	
}