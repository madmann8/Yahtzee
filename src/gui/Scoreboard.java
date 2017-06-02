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
public class Scoreboard extends JPanel{
    private int width = 500;
    private int height = 500;

    public static Scoreboard singleton = new Scoreboard();
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


    public Scoreboard() {
        setupViews();
    }

    public void setupViews() {
       GridLayout layout = new GridLayout(7,2);
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

    }

   private class CellPanel extends JPanel {
       Scoreboard scoreboard;
       JLabel label = new JLabel();
       JButton button = new JButton();
       ArrayList<CombinationType> queuedCombos = new ArrayList<>();

       public CellPanel() {
           button.setEnabled(false);
           add(label);
           add(button);
           button.setText("Add");
           button.setBackground(Color.darkGray);
       }

   }

   private class AcesPanel extends CellPanel{
       public AcesPanel() {
           super();
           label.setText("Aces");
       button.addActionListener(new Listener());}

       private class Listener implements ActionListener {
           @Override
           public void actionPerformed(ActionEvent e) {
               Integer value = bestValue(queuedCombos);
               scoreboardModel.setAces(value);
               button.setText(String.valueOf(value));
           }
       }


   }

   private Integer bestValue(ArrayList<CombinationType> queuedCombos) {
        Integer result = 0;
       if (queuedCombos.size() == 1){
           result =  Combination.getValue(queuedCombos.get(0));
       }
       else if (queuedCombos.size() > 1){
           Integer greatestValue = 0;
           for (CombinationType combo : queuedCombos){
               Integer value = Combination.getValue(combo);
               if (value>greatestValue){
                   greatestValue = value;
               }
           }
           result = greatestValue;
       }
       queuedCombos.clear();
       return result;
   }

    private class TwosPanel extends CellPanel{
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
           }
       }
    }
    private class ThreesPanel extends CellPanel{
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
           }
       }
    }
    private class FoursPanel extends CellPanel{
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
           }
       }
    }
    private class FivesPanel extends CellPanel{
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
           }
       }
    }
    private class SixesPanel extends CellPanel{
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
           }
       }
    }
    private class ThreeOfAKindPanel extends CellPanel{
        public ThreeOfAKindPanel() {
            super();
            label.setText("Three of A Kind");
        button.addActionListener(new Listener());
        }
       private class Listener implements ActionListener {
           @Override
           public void actionPerformed(ActionEvent e) {
               Integer value = bestValue(queuedCombos);
               scoreboardModel.setThreeOfAKind(value);
               button.setText(String.valueOf(value));
           }
       }
    }
    private class FourOfAKindPanel extends CellPanel{
        public FourOfAKindPanel() {
            super();
            label.setText("Four of A Kind");
        button.addActionListener(new Listener());
        }
       private class Listener implements ActionListener {
           @Override
           public void actionPerformed(ActionEvent e) {
               Integer value = bestValue(queuedCombos);
               scoreboardModel.setFourOfAKind(value);
               button.setText(String.valueOf(value));
           }
       }
    }
    private class FullHousePanel extends CellPanel{
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
           }
       }
    }
    private class SmallStraightPanel extends CellPanel{
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
           }
       }
    }
    private class LargeStraightPanel extends CellPanel{
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
           }
       }
    }
    private class YahtzeePanel extends CellPanel{
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
           }
       }
    }
    private class ChancePanel extends CellPanel{
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
           }
       }
    }



    public void update(ArrayList<CombinationType> list) {
        acesPanel.button.setEnabled(false);
        twosPanel.button.setEnabled(false);
        threesPanel.button.setEnabled(false);
        foursPanel.button.setEnabled(false);
        fivesPanel.button.setEnabled(false);
        chancePanel.button.setEnabled(false);
        sixesPanel.button.setEnabled(false);
        chancePanel.button.setEnabled(false);
        fullHousePanel.button.setEnabled(false);
        smallStraightPanel.button.setEnabled(false);
        largeStraightPanel.button.setEnabled(false);
        yahtzeePanel.button.setEnabled(false);
        threeOfAKindPanel.button.setEnabled(false);
        fourOfAKindPanel.button.setEnabled(false);

        for (CombinationType combo:list) {

            if (combo==(CombinationType.ONEACE) || combo==(CombinationType.TWOACES) || combo==(CombinationType.THREEACES) || combo==(CombinationType.FOURACES) || combo==(CombinationType.FIVEACES)) {
                acesPanel.button.setEnabled(true);
                acesPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.ONETWO) || combo==(CombinationType.TWOTWOS) || combo==(CombinationType.THREETWOS) || combo==(CombinationType.FOURTWOS) || combo==(CombinationType.FIVETWOS)) {
                twosPanel.button.setEnabled(true);
                twosPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.ONETHREES) || combo==(CombinationType.TWOTHREES) || combo==(CombinationType.THREETHREES) || combo==(CombinationType.FOURTHREES) || combo==(CombinationType.FIVETHREES)) {
                threesPanel.button.setEnabled(true);
                threesPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.ONEFOUR) || combo==(CombinationType.TWOFOURS) || combo==(CombinationType.THREEFOURS) || combo==(CombinationType.FOURFOURS) || combo==(CombinationType.FIVEFOURS)) {
                foursPanel.button.setEnabled(true);
                foursPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.ONEFIVE) || combo==(CombinationType.TWOFIVES) || combo==(CombinationType.THREEFIVES) || combo==(CombinationType.FOURFIVES) || combo==(CombinationType.FIVEFIVES)) {
                fivesPanel.button.setEnabled(true);
                fivesPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.ONESIX) || combo==(CombinationType.TWOSIXES) || combo==(CombinationType.THREESIXES) || combo==(CombinationType.FOURSIXES) || combo==(CombinationType.FIVESIXES)) {
                sixesPanel.button.setEnabled(true);
                sixesPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.CHANCE)) {
                chancePanel.button.setEnabled(true);
                chancePanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.FULLHOUSE1) || combo==(CombinationType.FULLHOUSE2) || combo==(CombinationType.FULLHOUSE3) || combo==(CombinationType.FULLHOUSE4) || combo==(CombinationType.FULLHOUSE5) || combo==(CombinationType.FULLHOUSE6) || combo==(CombinationType.FULLHOUSE7) || combo==(CombinationType.FULLHOUSE8) || combo==(CombinationType.FULLHOUSE9) || combo==(CombinationType.FULLHOUSE10) || combo==(CombinationType.FULLHOUSE11) || combo==(CombinationType.FULLHOUSE12) || combo==(CombinationType.FULLHOUSE13) || combo==(CombinationType.FULLHOUSE14) || combo==(CombinationType.FULLHOUSE15) || combo==(CombinationType.FULLHOUSE16) || combo==(CombinationType.FULLHOUSE17) || combo==(CombinationType.FULLHOUSE18) || combo==(CombinationType.FULLHOUSE19) || combo==(CombinationType.FULLHOUSE20) || combo==(CombinationType.FULLHOUSE21) || combo==(CombinationType.FULLHOUSE22) || combo==(CombinationType.FULLHOUSE23) || combo==(CombinationType.FULLHOUSE24) || combo==(CombinationType.FULLHOUSE25) || combo==(CombinationType.FULLHOUSE26) || combo==(CombinationType.FULLHOUSE27) || combo==(CombinationType.FULLHOUSE28) || combo==(CombinationType.FULLHOUSE29) || combo==(CombinationType.FULLHOUSE30)) {
                fullHousePanel.button.setEnabled(true);
                fullHousePanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.SMALLSTRAIGHT1) || combo==(CombinationType.SMALLSTRAIGHT2) || combo==(CombinationType.SMALLSTRAIGHT3)) {
                smallStraightPanel.button.setEnabled(true);
                smallStraightPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.LARGESTRAIGHT1) || combo==(CombinationType.LARGESTRAIGHT2)) {
                largeStraightPanel.button.setEnabled(true);
                largeStraightPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.YATZEE1) || combo==(CombinationType.YATZEE2) || combo==(CombinationType.YATZEE3) || combo==(CombinationType.YATZEE4) || combo==(CombinationType.YATZEE5)) {
                yahtzeePanel.button.setEnabled(true);
                yahtzeePanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.THREEOFAONES) || combo==(CombinationType.THREEOFATWOS) || combo==(CombinationType.THREEOFATHREES) || combo==(CombinationType.THREEOFAFOURS) || combo==(CombinationType.THREEOFAFIVES) || combo==(CombinationType.THREEOFAFOURS)) {
                threeOfAKindPanel.button.setEnabled(true);
                threeOfAKindPanel.queuedCombos.add(combo);
            }
            if (combo==(CombinationType.FOURACES) || combo==(CombinationType.FOURTWOS) || combo==(CombinationType.FOURTHREES) || combo==(CombinationType.FOURFOURS) || combo==(CombinationType.FOURFIVES) || combo==(CombinationType.FOURSIXES)) {
                fourOfAKindPanel.button.setEnabled(true);
                fourOfAKindPanel.queuedCombos.add(combo);
            }
        }
    }
}