package gui;

import model.Die;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Luke Mann on 6/2/17.
 */
class TurnManager {

    private boolean hasPresentedWinMessage = false;

    static TurnManager singleton = new TurnManager();

    private ArrayList<ScoreboardGUI> scoreboards = new ArrayList<>();

    private TurnManager() {
        tabbedPane.addChangeListener(new changeListener());
        scoreboards.add(new ScoreboardGUI());
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
        containerFrame.add(DiceBarGUI.singleton);
        frame.getContentPane().add(containerFrame);
        frame.setVisible(true);

        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
    }

    ScoreboardGUI getCurrentScoreBoard() {
        return scoreboards.get(tabbedPane.getSelectedIndex());
    }

    private class changeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            DiceBarGUI diceBar = DiceBarGUI.singleton;
            if (scoreboards.get(tabbedPane.getSelectedIndex()).rollsRemaining > 0) {
//                diceBar.reloadDice();
                diceBar.reloadButton.setEnabled(true);
                int i = 0;
                for (Die die : diceBar.dice) {
                    die.held = false;
                    diceBar.realignDice();
//                    DiceBarGUI.singleton.buttons[i].setEnabled(true);
                    i++;
                }
            } else {
                diceBar.reloadButton.setEnabled(false);
                int i = 0;
                for (Die die : diceBar.dice) {
                    die.held = true;
                    diceBar.realignDice();
//                    DiceBarGUI.singleton.buttons[i].setEnabled(false);
                    i++;
                }
            }
        }
    }

    private JPanel makeFrame() {
        ScoreboardGUI scoreboard = new ScoreboardGUI();
        scoreboards.add(scoreboard);
        return scoreboard;
    }

    void checkWin() {
        Boolean isDone = true;
        for (ScoreboardGUI scoreboard : scoreboards)
            if (scoreboard.getCurrentTurnCount()>0)
                isDone = false;
        if (isDone) {
            String highestPlayer = "Player 0";
            ArrayList<ScoreboardGUI> ties = new ArrayList<>();
            int highestScore = 0;
            for (ScoreboardGUI scoreboard : scoreboards) {
                Integer value = scoreboard.getCurrentScore();
                if (value > highestScore) {
                    highestScore = value;
                    highestPlayer = "Player" + (scoreboards.indexOf(scoreboard) + 1);
                }
                if (value == highestScore){
                    ties.add(scoreboard);
                }
            }
            if (!ties.isEmpty()){
                ArrayList<Integer> indexes = new ArrayList<>();
                for (ScoreboardGUI scoreboard: ties){
                    indexes.add(scoreboards.indexOf(scoreboard)+1);
                }
                String labelText = "It's a tie between ";
                for (int i = 0; i<indexes.size();i++){
                    if (i<indexes.size()-1)
                        labelText += "Player " + indexes.get(i) + ", ";
                    else
                        labelText += "and Player " + indexes.get(i) + "!";
                }
                hasPresentedWinMessage = true;
            }
            if (!hasPresentedWinMessage) {
                DiceBarGUI.singleton.add(new Label(highestPlayer + " is the winner!"));
                hasPresentedWinMessage = true;
            }

        }

    }

}
