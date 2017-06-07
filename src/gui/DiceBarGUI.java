package gui;

import model.Combination;
import model.CombinationType;
import model.Die;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by lukemann on 5/24/17.
 */

class DiceBarGUI extends JPanel{
    ArrayList<Die> dice = new ArrayList<>();

    static DiceBarGUI singleton = new DiceBarGUI();

    ArrayList<Integer> nums = new ArrayList<>();

    JToggleButton[] buttons = new JToggleButton[5];
    JButton reloadButton = new JButton("Roll");

    private DiceBarGUI() {
        for (int i = 1;i<6;i++){
            JToggleButton button = new JToggleButton(String.valueOf(i));
            add(button);
            button.setPreferredSize( new Dimension(50, 50));
            add(reloadButton);
            reloadButton.setPreferredSize(new Dimension(50,20));
            buttons[i-1] = button;
            Die die = new Die();
            button.setText(String.valueOf(die.value));
            button.addActionListener(die.listener);
            dice.add(die);
        }
        reloadButton.addActionListener(new reloadButtonList());

    }
    void reloadDice() {
        realignDice();
        nums = new ArrayList<>();
       int i = 0;
        for (JToggleButton button : buttons){
           Die die = dice.get(i);
           if (!die.held) {
//               button.setEnabled(true);
               die.rollDie();
           }
//           else button.setEnabled(false);


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

    public void realignDice() {
        int i = 0;
        for (JToggleButton button : buttons){
            Die die = dice.get(i);
               button.setSelected(die.held);
            i++;
        }
    }

}
