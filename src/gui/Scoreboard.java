package gui;

import javafx.scene.control.Cell;
import model.Combination;
import model.CombinationType;
import model.Dice;
import model.ScoreboardModel;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lukemann on 5/24/17.
 */
public class Scoreboard extends JPanel {
    private int width = 500;
    private int height = 500;

    private int index;

    private static ArrayList<Scoreboard> scoreboards = new ArrayList<>(100);

    public static Scoreboard getScoreBoard(int index){
        return scoreboards.get(index);
    }

    private ScoreboardModel scoreboardModel = ScoreboardModel.singleton;

//    private JLabel acesLabel, twosLabel, threesLabel, foursLabel, fivesLabel, sixesLabel, threeOfAKindsLabel, fourOfAKindLabel, fullHouseLabel, smallStraightLabel, largeStraightLabel, yahtzeeLabel, chanceLabel;
//    private JButton acesButton, twosButton, threesButton, foursButton, fivesButton, sixesButton, threeOfAKindsButton, fourOfAKindButton, fullHouseButton, smallStraightButton, largeStraightButton, yahtzeeButton, chanceButton;

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
    private Integer turnsRemaining = 3;
    private ArrayList<CellPanel> panels = new ArrayList<>();


    public Scoreboard(int index) {
        this.index = index;
        scoreboards.add(this);
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

    public void setupViews() {
        GridLayout layout = new GridLayout(7, 2);
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


    }

    private class CellPanel extends JPanel {
        Scoreboard scoreboard;
        JLabel label = new JLabel();
        JButton button = new JButton();
        ArrayList<CombinationType> queuedCombos = new ArrayList<>();
        Boolean canSet = true;

        public CellPanel() {
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
        if (panel.button.getText() != "Add") {
            return Integer.valueOf(panel.button.getText());
        }
        return 0;
    }

    private void updateTurnsRemaining() {
        if (turnsRemaining<=0){
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
        scorePanel.countLabel.setText(String.valueOf(turnsRemaining));
    }


    private class ScorePanel extends JPanel {
        Integer finalScore = 0;

        public void update() {
            Integer totalScore = 0;
            for (CellPanel panel : panels) {
                totalScore += lValue(panel);
            }
            scoreLabel.setText(String.valueOf(totalScore));

        }

        private JLabel scoreLabel = new JLabel("0");
        private JLabel countLabel = new JLabel("3");

        public ScorePanel() {
            add(new JLabel("Total Score:"));
            add(scoreLabel);
            add(new JLabel("Rolls Remaining"));
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

        public AcesPanel() {
            super();
            label.setText("Aces");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setAces(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }


        }

    }

    private class TwosPanel extends CellPanel {
        public TwosPanel() {
            super();
            label.setText("Twos");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setTwos(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class ThreesPanel extends CellPanel {
        public ThreesPanel() {
            super();
            label.setText("Threes");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setThrees(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FoursPanel extends CellPanel {
        public FoursPanel() {
            super();
            label.setText("Fours");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setFours(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class FivesPanel extends CellPanel {
        public FivesPanel() {
            super();
            label.setText("Fives");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setFives(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class SixesPanel extends CellPanel {
        public SixesPanel() {
            super();
            label.setText("Sixes");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setSixes(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class ThreeOfAKindPanel extends CellPanel {
        public ThreeOfAKindPanel() {
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
        public FourOfAKindPanel() {
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
        public FullHousePanel() {
            super();
            label.setText("Full House");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setFullHouse(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class SmallStraightPanel extends CellPanel {
        public SmallStraightPanel() {
            super();
            label.setText("Small Straight");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setSmallStraight(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class LargeStraightPanel extends CellPanel {
        public LargeStraightPanel() {
            super();
            label.setText("Large Straight");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setLargeStright(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class YahtzeePanel extends CellPanel {
        public YahtzeePanel() {
            super();
            label.setText("Yahtzee");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setYahtzee(value);
                button.setText(String.valueOf(value));
                clearPanels();
                canSet = false;
                scorePanel.update();
            }
        }
    }

    private class ChancePanel extends CellPanel {
        public ChancePanel() {
            super();
            label.setText("Chance");
            button.addActionListener(new Listener());
        }

        private class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = bestValue(queuedCombos);
                scoreboardModel.setChance(value);
                button.setText(String.valueOf(value));
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


    public void update(ArrayList<CombinationType> list) {
        turnsRemaining -=1;
        updateTurnsRemaining();
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
            if (combo == (CombinationType.THREEOFAONES) || combo == (CombinationType.THREEOFATWOS) || combo == (CombinationType.THREEOFATHREES) || combo == (CombinationType.THREEOFAFOURS) || combo == (CombinationType.THREEOFAFIVES) || combo == (CombinationType.THREEOFAFOURS)) {
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