package model;

import java.util.ArrayList;
import java.util.Random;

public class Turn {
    ScoreboardModel mScoreCard;

    public Turn(ScoreboardModel scorecard) {
        mScoreCard = scorecard;
    }

    public int rollDie() {
        Random rand = new Random();

        return rand.nextInt(6) + 1;
    }

    public void startTurn() {
        rollDice(5);

    }

    private ArrayList<Integer> rollDice(int n) {
        int i;
        ArrayList<Integer> list = new ArrayList<>();
        for (i=0;i<n;i++){
            list.add(rollDie());
        }
        return list;
    }
}

