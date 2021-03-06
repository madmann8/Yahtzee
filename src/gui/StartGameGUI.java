package gui;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Luke Mann on 6/2/17.
 */

// A popup that occurs when the game begins that asks for the number of players
class StartGameGUI extends JPanel{
    private JTextField numberOfPlayers = new JTextField();
    private JButton startButton = new JButton("Start");

    StartGameGUI() {
        add(new JLabel("Number Of Players:"));
        add(numberOfPlayers);
        add(startButton);
        startButton.addActionListener(new StartButtonListener());
        startButton.setPreferredSize(new Dimension(100,30));
        numberOfPlayers.setPreferredSize(new Dimension(40,30));
        setPreferredSize(new DimensionUIResource(400,100));
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TurnManager.singleton.setNumberPlayers(Integer.valueOf(numberOfPlayers.getText()));
            startButton.setEnabled(false);
            numberOfPlayers.setEnabled(false);
        }
    }


}
