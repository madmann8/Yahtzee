package gui;

import model.Dice;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Luke Mann on 6/2/17.
 */
class TurnManager {

    static TurnManager singleton = new TurnManager();

    private ArrayList<Scoreboard> scoreboards = new ArrayList<>();

    private TurnManager() {
        tabbedPane.addChangeListener(new changeListener());
        scoreboards.add(new Scoreboard());
    }


    private JTabbedPane tabbedPane = new JTabbedPane();

    void setNumberPlayers(int number) {
        scoreboards.clear();
        JFrame frame = new JFrame();
        for (int i = 0; i < number; i++) {
            String labelText = "Player " + String.valueOf(i + 1);
            tabbedPane.add(labelText, makeFrame());
        }
        GridLayout layout = new GridLayout(0, 1, 0, 2);
        frame.setLayout(layout);
        frame.getContentPane().add(tabbedPane);
        JPanel containerFrame = new JPanel();
        containerFrame.add(DiceBarGUI.singelton);
        frame.getContentPane().add(containerFrame);


        frame.setVisible(true);

        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
    }

    Scoreboard getCurrentScoreBoard() {
        return scoreboards.get(tabbedPane.getSelectedIndex());
    }

    private class changeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (scoreboards.get(tabbedPane.getSelectedIndex()).rollsRemaining > 0) {
                DiceBarGUI.singelton.reloadButton.setEnabled(true);
                int i = 0;
                for (Dice die : DiceBarGUI.singelton.dice) {
                    die.held = true;
                    DiceBarGUI.singelton.buttons[i].setEnabled(true);
                    i++;
                }
            } else {
                DiceBarGUI.singelton.reloadButton.setEnabled(false);
                int i = 0;
                for (Dice die : DiceBarGUI.singelton.dice) {
                    die.held = true;
                    DiceBarGUI.singelton.buttons[i].setEnabled(false);
                    i++;
                }
            }
        }
    }

    private JPanel makeFrame() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboards.add(scoreboard);
        return scoreboard;
    }
}
