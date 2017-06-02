package gui;

import model.Combination;
import model.CombinationType;
import model.Dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;



/**
 * Created by lukemann on 5/24/17.
 */
public class DiceBarGUI extends JPanel{
    private int width = 300;
    private int height = 75;

    private int index = 0;

    ArrayList<Dice> dice = new ArrayList<>();

    public static DiceBarGUI singelton = new DiceBarGUI();

    public ArrayList<Integer> nums = new ArrayList<>();

//    private static ArrayList<DiceBarGUI> diceBarGUIs  = new ArrayList<>(100);
//
//    public static DiceBarGUI getDiceBar(int index){
//        return diceBarGUIs.get(index);
//    }

    public JToggleButton[] buttons = new JToggleButton[5];
    private JLabel label;
    public JButton reloadButton = new JButton("Reload");

    public DiceBarGUI() {
//        this.index = index;
//        diceBarGUIs.add(this);
        label = new JLabel("Possibilities");
        for (int i = 1;i<6;i++){
//            String path = "/Users/lukemann/YahtzeeGame/src/gui/dice-" + String.valueOf(i) + ".png";
//            Image image = ImageIO.read(new File(path));
//            Image scaled = image.getScaledInstance(50,50,Image.SCALE_SMOOTH);
//            ImageIcon icon = new ImageIcon(image);
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

        GridLayout layout = new GridLayout(0, 1, 0, 2);

    }

   public void reloadDice() {
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
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       ArrayList<CombinationType> combos = Combination.compareCombo(nums);
       Scoreboard.getScoreBoard(index).update(combos);
   }


    private class reloadButtonList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reloadDice();
        }
    }




}
