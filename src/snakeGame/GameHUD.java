package snakeGame;

import javax.swing.*;
import java.awt.*;

public class GameHUD extends JPanel {
    MyPanel panel;
    final int SCREEN_WITDH = 750;
    final int SCREEN_HEIGHT = 750;
    Font font = new Font("Arial", Font.BOLD, 25);
    GameHUD(){

        panel = new MyPanel();
        this.add(panel);
        this.setPreferredSize(new Dimension(SCREEN_WITDH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
    }
    void Graphics(Graphics g){

    }





}
