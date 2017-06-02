package gui;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lukemann on 6/2/17.
 */
public class PlayerControllerGUI extends JPanel{
    JLabel playerNumberLabel  = new JLabel("Player 1");
    JTextField numberOfPlayers = new JTextField();
    JButton nextPlayerButton = new JButton("Next Player");
    JButton startButton = new JButton("Start");
    private int index;

    public static PlayerControllerGUI singleton = new PlayerControllerGUI();

    public PlayerControllerGUI() {
//        this.index = index;
        add(new JLabel("Number Of Players:"));
        add(numberOfPlayers);
        add(startButton);
        add(nextPlayerButton);
        add(playerNumberLabel);
        startButton.addActionListener(new StartButtonListener());
        numberOfPlayers.addActionListener(new TextFieldListener());
        nextPlayerButton.setPreferredSize(new Dimension(100,30));
        startButton.setPreferredSize(new Dimension(100,30));
        playerNumberLabel.setPreferredSize(new Dimension(100,30));
        numberOfPlayers.setPreferredSize(new Dimension(40,30));
        setPreferredSize(new DimensionUIResource(400,100));
    }

    private class TextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberOfPlayers.setEnabled(false);
        }
    }

    private class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
        }
    }

}
