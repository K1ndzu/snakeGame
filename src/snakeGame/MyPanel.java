package snakeGame;
// Criar um timer para segurar o movimento?
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.lang.Integer;
import java.lang.Boolean;
public class MyPanel extends JPanel implements KeyListener, ActionListener  {

	boolean Started = true;
	final int initialPosition = 125;
	final int screenWidth = 500;
	final int screenHeight = 500;
	final int tileSize = 25;
	Font font = new Font("Arial", Font.BOLD, 25);
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
		score = 0;
		direction = 'R';
		timer = new Timer(100,this);
		MyTimer();
		move = (Boolean) true;
		bodyParts = 3;
		xSnake = new Integer[400];
		ySnake = new Integer[400];
		xSnake[0] = (Integer) initialPosition;
		ySnake[0] = (Integer) initialPosition;
		
		
	}
	public void MyTimer(){
		if(Started == true) {
			timer.start();
		}else if (Started == false){
			timer.stop();
		}
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


		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Score:" + String.valueOf(score),0,tileSize*19);
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
			randomNumber();
			repaint();
		}
		
		if(xSnake[0] >= screenWidth || xSnake[0] < 0 || ySnake[0] >= screenHeight || ySnake[0] < 0) {
			Started = false;
			MyTimer();
		}
		for (int i = bodyParts; i > 0; i--) {
			
			if(Objects.equals(xSnake[0], xSnake[i]) && Objects.equals(ySnake[0], ySnake[i])) {
				Started = false;
				MyTimer();
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
			case 82:
				Started = true;
				xSnake[0] = (Integer) initialPosition;
				ySnake[0] = (Integer) initialPosition;
				bodyParts = 3;
				score =0;
				MyTimer();
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