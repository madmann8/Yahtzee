package gui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Luke Mann on 5/24/17.
 */


class Scoreboard extends JPanel {


    private AcesPanel acesPanel = new AcesPanel();
    private ThreeOfAKindPanel threeOfAKindPanel = new ThreeOfAKindPanel();
    private TwosPanel twosPanel = new TwosPanel();
    private FourOfAKindPanel fourOfAKindPanel = new FourOfAKindPanel();
    private ThreesPanel threesPanel = new ThreesPanel();
    private FullHousePanel fullHousePanel = new FullHousePanel();
    private FoursPanel foursPanel = new FoursPanel();
    private SmallStraightPanel smallStraightPanel = new SmallStraightPanel();
    private FivesPanel fivesPanel = new FivesPanel();
    private LargeStraightPanel largeStraightPanel = new LargeStraightPanel();
    private SixesPanel sixesPanel = new SixesPanel();
    private YahtzeePanel yahtzeePanel = new YahtzeePanel();
    private ChancePanel chancePanel = new ChancePanel();
    private ScorePanel scorePanel = new ScorePanel();
    private TurnsPanel turnPanel = new TurnsPanel();
    private SkipTurnPanel skipTurnPanel = new SkipTurnPanel();
    Integer rollsRemaining = 3;
    private ArrayList<CellPanel> panels = new ArrayList<>();


    Scoreboard() {
        setupViews();
        panels.add(acesPanel);
        panels.add(threeOfAKindPanel);
        panels.add(twosPanel);
        panels.add(fourOfAKindPanel);
        panels.add(threesPanel);
        panels.add(fullHousePanel);
        panels.add(foursPanel);
        panels.add(smallStraightPanel);
        panels.add(fivesPanel);
        panels.add(largeStraightPanel);
        panels.add(sixesPanel);
        panels.add(yahtzeePanel);
        panels.add(chancePanel);
    }

    private void setupViews() {
        GridLayout layout = new GridLayout(8, 2);
        setLayout(layout);
        add(acesPanel);
        add(threeOfAKindPanel);
        add(twosPanel);
        add(fourOfAKindPanel);
        add(threesPanel);
        add(fullHousePanel);
        add(foursPanel);
        add(smallStraightPanel);
        add(fivesPanel);
        add(largeStraightPanel);
        add(sixesPanel);
        add(yahtzeePanel);
        add(chancePanel);
        add(scorePanel);
        add(skipTurnPanel);
        add(turnPanel);
    }


    private class CellPanel extends JPanel {
        JLabel label = new JLabel();
        JButton button = new JButton();
        ArrayList<CombinationType> queuedCombos = new ArrayList<>();
        Boolean canSet = true;

        CellPanel() {
            button.setEnabled(false);
            add(label);
            add(button);
            button.setText("Add");
            button.setBackground(Color.darkGray);
        }

        public void setEnabled(boolean b) {
            button.setEnabled(b);
            if (!canSet) {
                button.setEnabled(false);
            }
        }
    }

    private Integer lValue(CellPanel panel) {
        if (!Objects.equals(panel.button.getText(), "Add")) {
            return Integer.valueOf(panel.button.getText());
        }
        return 0;
    }

    private void updateRollsRemaining() {
        if (rollsRemaining <=0){
            clearPanels();
            scorePanel.countLabel.setText("0");

            int i =0;
            for (Dice die : DiceBarGUI.singelton.dice){
                die.held = true;
                DiceBarGUI.singelton.buttons[i].setEnabled(false);
                i++;
            }
            DiceBarGUI.singelton.reloadButton.setEnabled(false);
            for (CellPanel panel:panels){
                panel.button.setEnabled(false);
            }
            return;
        }
        scorePanel.countLabel.setText(String.valueOf(rollsRemaining));

    }


    private class ScorePanel extends JPanel {

        void update() {
            Integer totalScore = 0;
            for (CellPanel panel : panels) {
                totalScore += lValue(panel);
            }
            scoreLabel.setText(String.valueOf(totalScore));
            countLabel.setText("3");
            turnPanel.update();
            rollsRemaining = 3;
            updateRollsRemaining();
            DiceBarGUI.singelton.reloadButton.setEnabled(true);
            int i =0;
            for (Dice die : DiceBarGUI.singelton.dice){
                die.held = false;
                DiceBarGUI.singelton.buttons[i].setEnabled(true);
                i++;
            }
            DiceBarGUI.singelton.reloadDice();


        }

        private JLabel scoreLabel = new JLabel("0");
        private JLabel countLabel = new JLabel("3");

        ScorePanel() {
            add(new JLabel("Total Score:"));
            add(scoreLabel);
            add(new JLabel("Rolls Remaining"));
            add(countLabel);
        }
    }
    private class TurnsPanel extends JPanel {

        void update() {
            Integer currentScore = Integer.valueOf(countLabel.getText());
            currentScore -= 1;
            countLabel.setText(String.valueOf(currentScore));
            if (currentScore <= 0) {
                for (CellPanel panel : panels) {
                    panel.canSet = false;
                    panel.setEnabled(false);
                }
                skipTurnPanel.canSet = false;
                skipTurnPanel.setEnabled(false);

            }

            }



        private JLabel countLabel = new JLabel("13");

        TurnsPanel() {
            add(new JLabel("Turns Remaining:"));
            add(countLabel);
        }
    }

    private Integer bestValue(ArrayList<CombinationType> queuedCombos) {
        Integer result = 0;
        if (queuedCombos.size() == 1) {
            result = Combination.getValue(queuedCombos.get(0));
        } else if (queuedCombos.size() > 1) {
            Integer greatestValue = 0;
            for (CombinationType combo : queuedCombos) {
                Integer value = Combination.getValue(combo);
                if (value > greatestValue) {
                    greatestValue = value;
                }
            }
            result = greatestValue;
        }
        queuedCombos.clear();
        return result;
    }

    private class AcesPanel extends CellPanel {

        AcesPanel() {
            super();
            label.setText("Aces");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }


        }

    }

    private class TwosPanel extends CellPanel {
        TwosPanel() {
            super();
            label.setText("Twos");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class ThreesPanel extends CellPanel {
        ThreesPanel() {
            super();
            label.setText("Threes");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FoursPanel extends CellPanel {
        FoursPanel() {
            super();
            label.setText("Fours");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FivesPanel extends CellPanel {
        FivesPanel() {
            super();
            label.setText("Fives");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class SixesPanel extends CellPanel {
        SixesPanel() {
            super();
            label.setText("Sixes");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class ThreeOfAKindPanel extends CellPanel {
        ThreeOfAKindPanel() {
            super();
            label.setText("Three of A Kind");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = 0;
                for (Integer num : DiceBarGUI.singelton.nums) {
                    value += num;
                }
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FourOfAKindPanel extends CellPanel {
        FourOfAKindPanel() {
            super();
            label.setText("Four of A Kind");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = 0;
                for (Integer num : DiceBarGUI.singelton.nums) {
                    value += num;
                }
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FullHousePanel extends CellPanel {
        FullHousePanel() {
            super();
            label.setText("Full House");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class SmallStraightPanel extends CellPanel {
        SmallStraightPanel() {
            super();
            label.setText("Small Straight");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class LargeStraightPanel extends CellPanel {
        LargeStraightPanel() {
            super();
            label.setText("Large Straight");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class YahtzeePanel extends CellPanel {
        YahtzeePanel() {
            super();
            label.setText("Yahtzee");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class SkipTurnPanel extends CellPanel {
        SkipTurnPanel() {
            super();
            label.setText("Skip Turn");
            button.setText("Skip");
            setEnabled(true);
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                scorePanel.update();
            }
        }
    }

    private class ChancePanel extends CellPanel {
        ChancePanel() {
            super();
            label.setText("Chance");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = 0;
                for (Integer num : DiceBarGUI.singelton.nums) {
                    value += num;
                }
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private void clearPanels() {
        for (CellPanel panel : panels) {
            panel.setEnabled(false);
            panel.queuedCombos.clear();
        }
    }


    void update(ArrayList<CombinationType> list) {
        rollsRemaining -=1;
        updateRollsRemaining();
        clearPanels();
        for (CombinationType combo : list) {

            if (combo == (CombinationType.ONEACE) || combo == (CombinationType.TWOACES) || combo == (CombinationType.THREEACES) || combo == (CombinationType.FOURACES) || combo == (CombinationType.FIVEACES)) {
                acesPanel.setEnabled(true);
                acesPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.ONETWO) || combo == (CombinationType.TWOTWOS) || combo == (CombinationType.THREETWOS) || combo == (CombinationType.FOURTWOS) || combo == (CombinationType.FIVETWOS)) {
                twosPanel.setEnabled(true);
                twosPanel.queuedCombos.add(combo);

            }
            if (combo == (CombinationType.ONETHREES) || combo == (CombinationType.TWOTHREES) || combo == (CombinationType.THREETHREES) || combo == (CombinationType.FOURTHREES) || combo == (CombinationType.FIVETHREES)) {
                threesPanel.setEnabled(true);
                threesPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.ONEFOUR) || combo == (CombinationType.TWOFOURS) || combo == (CombinationType.THREEFOURS) || combo == (CombinationType.FOURFOURS) || combo == (CombinationType.FIVEFOURS)) {
                foursPanel.setEnabled(true);
                foursPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.ONEFIVE) || combo == (CombinationType.TWOFIVES) || combo == (CombinationType.THREEFIVES) || combo == (CombinationType.FOURFIVES) || combo == (CombinationType.FIVEFIVES)) {
                fivesPanel.setEnabled(true);
                fivesPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.ONESIX) || combo == (CombinationType.TWOSIXES) || combo == (CombinationType.THREESIXES) || combo == (CombinationType.FOURSIXES) || combo == (CombinationType.FIVESIXES)) {
                sixesPanel.setEnabled(true);
                sixesPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.CHANCE)) {
                chancePanel.setEnabled(true);
                chancePanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.FULLHOUSE1) || combo == (CombinationType.FULLHOUSE2) || combo == (CombinationType.FULLHOUSE3) || combo == (CombinationType.FULLHOUSE4) || combo == (CombinationType.FULLHOUSE5) || combo == (CombinationType.FULLHOUSE6) || combo == (CombinationType.FULLHOUSE7) || combo == (CombinationType.FULLHOUSE8) || combo == (CombinationType.FULLHOUSE9) || combo == (CombinationType.FULLHOUSE10) || combo == (CombinationType.FULLHOUSE11) || combo == (CombinationType.FULLHOUSE12) || combo == (CombinationType.FULLHOUSE13) || combo == (CombinationType.FULLHOUSE14) || combo == (CombinationType.FULLHOUSE15) || combo == (CombinationType.FULLHOUSE16) || combo == (CombinationType.FULLHOUSE17) || combo == (CombinationType.FULLHOUSE18) || combo == (CombinationType.FULLHOUSE19) || combo == (CombinationType.FULLHOUSE20) || combo == (CombinationType.FULLHOUSE21) || combo == (CombinationType.FULLHOUSE22) || combo == (CombinationType.FULLHOUSE23) || combo == (CombinationType.FULLHOUSE24) || combo == (CombinationType.FULLHOUSE25) || combo == (CombinationType.FULLHOUSE26) || combo == (CombinationType.FULLHOUSE27) || combo == (CombinationType.FULLHOUSE28) || combo == (CombinationType.FULLHOUSE29) || combo == (CombinationType.FULLHOUSE30)) {
                fullHousePanel.setEnabled(true);
                fullHousePanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.SMALLSTRAIGHT1) || combo == (CombinationType.SMALLSTRAIGHT2) || combo == (CombinationType.SMALLSTRAIGHT3)) {
                smallStraightPanel.setEnabled(true);
                smallStraightPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.LARGESTRAIGHT1) || combo == (CombinationType.LARGESTRAIGHT2)) {
                largeStraightPanel.setEnabled(true);
                largeStraightPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.YATZEE1) || combo == (CombinationType.YATZEE2) || combo == (CombinationType.YATZEE3) || combo == (CombinationType.YATZEE4) || combo == (CombinationType.YATZEE5)) {
                yahtzeePanel.setEnabled(true);
                yahtzeePanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.THREEOFAONES) || combo == (CombinationType.THREEOFATWOS) || combo == (CombinationType.THREEOFATHREES) || combo == (CombinationType.THREEOFAFOURS) || combo == (CombinationType.THREEOFAFIVES)) {
                threeOfAKindPanel.setEnabled(true);
                threeOfAKindPanel.queuedCombos.add(combo);
            }
            if (combo == (CombinationType.FOURACES) || combo == (CombinationType.FOURTWOS) || combo == (CombinationType.FOURTHREES) || combo == (CombinationType.FOURFOURS) || combo == (CombinationType.FOURFIVES) || combo == (CombinationType.FOURSIXES)) {
                fourOfAKindPanel.setEnabled(true);
                fourOfAKindPanel.queuedCombos.add(combo);
            }
        }
    }
}