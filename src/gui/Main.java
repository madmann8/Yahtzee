package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by lukemann on 5/24/17.
` */
public class Main {
    public static void main(String[] args) throws IOException {
        JPanel main = new JPanel();
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(600,600));
        Scoreboard.singleton.setupViews();
//        scoreboard.setBackground(Color.black);
//        diceBar.setBackground(Color.BLUE);
        frame.getContentPane().add(Scoreboard.singleton);
        frame.getContentPane().add(DiceBarGUI.singelton);
        GridLayout layout = new GridLayout(0, 1, 0, 2);
        frame.setLayout(layout);
        frame.setVisible(true);
        frame.pack();
    }
}
