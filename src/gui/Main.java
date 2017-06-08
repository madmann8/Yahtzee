package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Luke Mann on 5/24/17.
` */

// RUN THIS TO PLAY THE GAME
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new StartGameGUI());
        frame.setVisible(true);
        frame.pack();
    }
}
