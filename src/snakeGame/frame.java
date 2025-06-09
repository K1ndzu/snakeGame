package snakeGame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class frame extends JFrame {
	MyPanel panel;
	GameHUD gameHUD;
	Image icon;
	frame(){

		panel = new MyPanel();
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
