package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Luke Mann on 5/17/17.
 */
public class Die {

    public boolean held = false;
    public int value;
    public Listener listener = new Listener();

    public Die() {
       rollDie();
    }

    public void rollDie() {
        Random rand = new Random();

        value=rand.nextInt(6) + 1;
    }


    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            held = !held;
        }
    }
}
