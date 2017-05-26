package model;

/**
 * Created by madmann on 8/18/16.
 */
public class Scoreboard {
    public String name;

//    Upper Section
    private int mTurnsRemaining;
    private int mAces;
    private boolean canSetAces = true;
    private int mTwos;
    private boolean canSetTwo = true;
    private int mThrees;
    private boolean canSetThrees = true;
    private int mFours;
    private boolean canSetFours = true;
    private int mFives;
    private boolean canSetFives = true;
    private int mSixes;
    private boolean canSetSixes = true;
//    Lower Section
    private int mThreeOfAKind;
    private boolean canSetThreeOfAKind = true;
    private int mFourOfAKind;
    private boolean canSetFourOfAKind = true;
    private int mFullHouse;
    private boolean canSetFullHouse = true;
    private int smallStraight;
    private boolean canSetSmallStraight = true;
    private int mLargeStright;
    private boolean canSetLargeStaight = true;
    private int mYahtzee;
    private boolean canSetYahtzee = true;
    private int mChance;
    private boolean canSetChance = true;
    private int mTotalScore;



    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public int getTurnsRemaining() {
        return mTurnsRemaining;
    }

    public void setTurnsRemaining(int turnsRemaining) {
        this.mTurnsRemaining = turnsRemaining;
    }

    public int getAces() {
        return mAces;
    }

    public void setAces(int aces) {
        if (canSetAces) {
        this.mAces = aces;}
        canSetAces = false;
    }

    public int getTwos() {
        return mTwos;
    }

    public void setTwos(int twos) {
        if (canSetTwo) {
        this.mTwos = twos;}
        canSetTwo = false;
    }

    public int getThrees() {
        return mThrees;
    }

    public void setThrees(int threes) {
        if (canSetThrees) {
        this.mThrees = threes;}
        canSetThrees = false;
    }

    public int getFours() {
        return mFours;
    }

    public void setFours(int fours) {
        if (canSetFours) {
        this.mFours = fours;}
        canSetFours = false;
    }

    public int getFives() {
        return mFives;
    }

    public void setFives(int fives) {
        if (canSetFives) {
        this.mFives = fives;}
        canSetFives = false;
    }

    public int getSixes() {
        return mSixes;
    }

    public void setSixes(int sixes) {
        if (canSetSixes) {
        this.mSixes = sixes;}
        canSetSixes = false;
    }
// TODO: FIX getBonus
    public int getBonus() {
        int i = mAces + mTwos + mThrees + mFours + mFives + mSixes;
        if (i >=63) {
            return 35;
        }
        else {
            return 0;
        }
    }

    public int getThreeOfAKind() {
        return mThreeOfAKind;
    }

    public void setThreeOfAKind(int threeOfAKind) {
        if (canSetThreeOfAKind) {
        this.mThreeOfAKind = threeOfAKind;}
        canSetThreeOfAKind = false;
    }

    public int getFourOfAKind() {
        return mFourOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        if (canSetFourOfAKind) {
        this.mFourOfAKind = fourOfAKind;}
        canSetFourOfAKind = false;
    }

    public int getFullHouse() {
        return mFullHouse;
    }

    public void setFullHouse(int fullHouse) {
        if (canSetFullHouse) {
        this.mFullHouse = fullHouse;}
        canSetFullHouse = false;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public void setSmallStraight(int smallStraight) {
        if (canSetSmallStraight) {
        this.smallStraight = smallStraight;}
        canSetSmallStraight = false;
    }

    public int getLargeStright() {
        return mLargeStright;
    }

    public void setLargeStright(int largeStright) {
        if (canSetLargeStaight) {
        this.mLargeStright = largeStright;}
        canSetLargeStaight = false;
    }

    public int getYahtzee() {
        int result;
        if (mYahtzee ==0){
            result=0;
        }
        if (mYahtzee ==1){
            result=50;
        }
        else {
            return (50 + (100 * mYahtzee));
        }
        return mYahtzee;
    }

    public void setYahtzee(int yahtzee) {
        this.mYahtzee = yahtzee;
        canSetYahtzee = false;
    }

    public int getChance() {
        return mChance;
    }

    public void setChance(int chance) {
        if (canSetChance) {
        this.mChance = chance;}
        canSetChance = false;
    }

    public int getTotalScore() {
        int result;
        result= mAces + mTwos + mThrees + mFours + mFives + mSixes +getBonus()+ mThreeOfAKind + mFourOfAKind +
                mFullHouse +smallStraight+ mLargeStright +getYahtzee();

        return mTotalScore;
    }

    public void setTotalScore(int totalScore) {
        this.mTotalScore = totalScore;
    }

}
