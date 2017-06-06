package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Luke Mann on 5/24/17.
` */
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        GridLayout layout = new GridLayout(0, 1, 0, 2);
        frame.getContentPane().add(new StartGameGUI());
        frame.setLayout(layout);
        frame.setVisible(true);
        frame.pack();
    }
}
