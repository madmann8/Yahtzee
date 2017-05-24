package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by lukemann on 5/24/17.
 */
public class DiceBarGUI {
    private int width = 300;
    private int height = 75;

    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons;
//            = {new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
    private JLabel label;

    public DiceBarGUI() {
        frame = new JFrame(("Dice"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Possibilities");
        for (int i = 1;i<7;i++){
            String path = "resources/dice-" + String.valueOf(i) + ".png";
            URL imgUrl = getClass().getClassLoader().getResource(path);
            ImageIcon image = new ImageIcon(imgUrl);
            JButton button = new JButton("",image);
            panel.add(button);
            button.setPreferredSize( new Dimension(50, 50));
        }


    }

    public void display() {
        frame.pack();
        frame.setVisible(true);
    }



}
