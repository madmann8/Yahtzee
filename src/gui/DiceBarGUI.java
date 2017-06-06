package gui;

import model.Combination;
import model.CombinationType;
import model.Dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by lukemann on 5/24/17.
 */

class DiceBarGUI extends JPanel{
    ArrayList<Dice> dice = new ArrayList<>();

    static DiceBarGUI singelton = new DiceBarGUI();

    ArrayList<Integer> nums = new ArrayList<>();

    JToggleButton[] buttons = new JToggleButton[5];
    private JLabel label = new JLabel("Possibilities");
    JButton reloadButton = new JButton("Reload");

    private DiceBarGUI() {
        for (int i = 1;i<6;i++){
            JToggleButton button = new JToggleButton(String.valueOf(i));
            add(button);
            button.setPreferredSize( new Dimension(50, 50));
            add(reloadButton);
            reloadButton.setPreferredSize(new Dimension(50,20));
            buttons[i-1] = button;
            Dice die = new Dice();
            button.setText(String.valueOf(die.value));
            button.addActionListener(die.listener);
            dice.add(die);
        }
        reloadButton.addActionListener(new reloadButtonList());

    }
    void reloadDice() {
        nums = new ArrayList<>();
       int i = 0;
        for (JToggleButton button : buttons){
           Dice die = dice.get(i);
           if (!die.held) {
               die.rollDie();
           }
            button.setText(String.valueOf(die.value));
            nums.add(die.value);
            i++;
        }

       ArrayList<CombinationType> combos = Combination.compareCombo(nums);
      TurnManager.singleton.getCurrentScoreBoard().update(combos);
   }


    private class reloadButtonList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reloadDice();
        }
    }
}
