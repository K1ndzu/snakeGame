package snakeGame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class frame extends JFrame {
	MyPanel panel;
	Image icon;
	frame(){
		icon = new ImageIcon("C:/Users/Pichau/eclipse-workspace/Growing/snakeGame/src/snakeGame/apple.png").getImage();
		panel = new MyPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setIconImage(icon);
		this.setTitle("SNAKE GAME");
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new frame();
		
		
	}
	
}
