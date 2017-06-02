package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by lukemann on 5/17/17.
 */
public class Dice {

    public boolean held = false;
    public int value;
    public Listener listener = new Listener();

    public Dice() {
       rollDie();
    }

    public void rollDie() {
        Random rand = new Random();

        value=rand.nextInt(6) + 1;
    }


    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (held){
                held = false;
            }
            else {
                held = true;
            }
        }
    }
}
