package model;

import java.util.Random;

/**
 * Created by lukemann on 5/17/17.
 */
public class Dice {

    public boolean held = false;
    public int value;

    public Dice() {
        this.value = rollDie();
    }

    private Integer rollDie() {
        Random rand = new Random();

        return rand.nextInt(6) + 1;
//        return 1;
    }
}
