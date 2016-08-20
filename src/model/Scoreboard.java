package model;

/**
 * Created by madmann on 8/18/16.
 */
public class Scoreboard {
    public String name;

//    Upper Section
    private int mTurnsRemaining;
    private int mAces;
    private int mTwos;
    private int mThrees;
    private int mFours;
    private int mFives;
    private int mSixes;
//    Lower Section
    private int mThreeOfAKind;
    private int mFourOfAKind;
    private int mFullHouse;
    private int smallStraight;
    private int mLargeStright;
    private int mYahtzee;
    private int mChance;
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
        this.mAces = aces;
    }

    public int getTwos() {
        return mTwos;
    }

    public void setTwos(int twos) {
        this.mTwos = twos;
    }

    public int getThrees() {
        return mThrees;
    }

    public void setThrees(int threes) {
        this.mThrees = threes;
    }

    public int getFours() {
        return mFours;
    }

    public void setFours(int fours) {
        this.mFours = fours;
    }

    public int getFives() {
        return mFives;
    }

    public void setFives(int fives) {
        this.mFives = fives;
    }

    public int getSixes() {
        return mSixes;
    }

    public void setSixes(int sixes) {
        this.mSixes = sixes;
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
        this.mThreeOfAKind = threeOfAKind;
    }

    public int getFourOfAKind() {
        return mFourOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        this.mFourOfAKind = fourOfAKind;
    }

    public int getFullHouse() {
        return mFullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.mFullHouse = fullHouse;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public void setSmallStraight(int smallStraight) {
        this.smallStraight = smallStraight;
    }

    public int getLargeStright() {
        return mLargeStright;
    }

    public void setLargeStright(int largeStright) {
        this.mLargeStright = largeStright;
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
            return (50+(100* mYahtzee));
        }
        return mYahtzee;
    }

    public void setYahtzee(int yahtzee) {
        this.mYahtzee = yahtzee;
    }

    public int getChance() {
        return mChance;
    }

    public void setChance(int chance) {
        this.mChance = chance;
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
