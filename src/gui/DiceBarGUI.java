package gui;

import model.Combination;
import model.CombinationType;
import model.Dice;

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
public class DiceBarGUI extends Applet{
    private int width = 300;
    private int height = 75;

    ArrayList<Dice> dice = new ArrayList<>();

    private JFrame frame;
    private JPanel panel = new JPanel();
    private JButton[] buttons = new JButton[6];
//            = {new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
    private JLabel label;
    private JButton reloadButton = new JButton();

    public DiceBarGUI() throws IOException {
        frame = new JFrame(("Dice"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Possibilities");
        for (int i = 1;i<7;i++){
//            String path = "/Users/lukemann/YahtzeeGame/src/gui/dice-" + String.valueOf(i) + ".png";
//            Image image = ImageIO.read(new File(path));
//            Image scaled = image.getScaledInstance(50,50,Image.SCALE_SMOOTH);
//            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton(String.valueOf(i));
            panel.add(button);
            button.setPreferredSize( new Dimension(50, 50));
            panel.add(reloadButton);
            reloadButton.setPreferredSize(new Dimension(50,20));
            reloadButton.setText("Reload");
            reloadButton.addActionListener(new reloadButtonList());
            buttons[i-1] = button;
        }
        panel.setPreferredSize(new Dimension(width,height));
        frame.getContentPane().add(panel);
    }

   public void reloadDice() {
       ArrayList<Integer> nums = new ArrayList<>();

       dice.clear();
        for (JButton button : buttons){
            Dice die = new Dice();
            button.setText(String.valueOf(die.value));
            dice.add(die);
            nums.add(die.value);
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
        Combination.arrayToString(combos);


   }






    public void display() {
        frame.pack();
        frame.setVisible(true);
    }

    private class reloadButtonList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reloadDice();
        }
    }



}
