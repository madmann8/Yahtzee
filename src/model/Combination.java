package model;


import java.util.*;

/**
 * Created by lukemann on 5/19/17
 */


public class Combination {

    private HashMap<CombinationType, Integer[]> mDiceCombosMap = new HashMap<>();
    private HashMap<CombinationType, Integer> mDiceComboValues = new HashMap<>();
    private HashMap<CombinationType, String> mStringMap = new HashMap<>();

    public Combination() {
        toMapDiceCombinations();
        toMapString();
        toMapCombinationValues();
    }

    private void toMapDiceCombinations() {
        Integer[] ONEACE = new Integer[]{1};
        Integer[] TWOACES = {1, 1};
        Integer[] THREEACES = {1, 1, 1};
        Integer[] FOURACES = {1, 1, 1, 1};
        Integer[] FIVEACES = {1, 1, 1, 1, 1};
        Integer[] ONETWO = {2};
        Integer[] TWOTWOS = {2, 2};
        Integer[] THREETWOS = {2, 2, 2};
        Integer[] FOURTWOS = {2, 2, 2, 2};
        Integer[] FIVETWOS = {2, 2, 2, 2, 2};
        Integer[] ONETHREES = {3};
        Integer[] TWOTHREES = {3, 3};
        Integer[] THREETHREES = {3, 3, 3};
        Integer[] FOURTHREES = {3, 3, 3, 3};
        Integer[] FIVETHREES = {3, 3, 3, 3, 3};
        Integer[] ONEFOUR = {4};
        Integer[] TWOFOURS = {4, 4};
        Integer[] THREEFOURS = {4, 4, 4};
        Integer[] FOURFOURS = {4, 4, 4, 4};
        Integer[] FIVEFOURS = {4, 4, 4, 4, 4};
        Integer[] ONEFIVE = {5};
        Integer[] TWOFIVES = {5, 5};
        Integer[] THREEFIVES = {5, 5, 5};
        Integer[] FOURFIVES = {5, 5, 5, 5};
        Integer[] FIVEFIVES = {5, 5, 5, 5, 5};
        Integer[] ONESIX = {6};
        Integer[] TWOSIXES = {6, 6};
        Integer[] THREESIXES = {6, 6, 6};
        Integer[] FOURSIXES = {6, 6, 6, 6};
        Integer[] FIVESIXES = {6, 6, 6, 6, 6};
        Integer[] THREEOFAONES = {1, 1, 1};
        Integer[] THREEOFATWOS = {2, 2, 2};
        Integer[] THREEOFATHREES = {3, 3, 3};
        Integer[] THREEOFAFOURS = {4, 4, 4};
        Integer[] THREEOFAFIVES = {5, 5, 5,};
        Integer[] THREEOFASIXES = {6, 6, 6};
        Integer[] FOUROFAONES = {1, 1, 1, 1};
        Integer[] FOUROFATWOS = {2, 2, 2, 2};
        Integer[] FOUROFATHREES = {3, 3, 3, 3};
        Integer[] FOUROFAFOURS = {4, 4, 4, 4};
        Integer[] FOUROFAFIVES = {5, 5, 5, 5};
        Integer[] FOUROFASIXES = {6, 6, 6, 6};
        Integer[] FULLHOUSE1 = {1, 1, 2, 2, 2};
        Integer[] FULLHOUSE2 = {1, 1, 3, 3, 3};
        Integer[] FULLHOUSE3 = {1, 1, 4, 4, 4};
        Integer[] FULLHOUSE4 = {1, 1, 5, 5, 5};
        Integer[] FULLHOUSE5 = {1, 1, 6, 6, 6};
        Integer[] FULLHOUSE6 = {2, 2, 1, 1, 1};
        Integer[] FULLHOUSE7 = {2, 2, 3, 3, 3};
        Integer[] FULLHOUSE8 = {2, 2, 4, 4, 4};
        Integer[] FULLHOUSE9 = {2, 2, 5, 5, 5};
        Integer[] FULLHOUSE10 = {2, 2, 6, 6, 6};
        Integer[] FULLHOUSE11 = {3, 3, 1, 1, 1};
        Integer[] FULLHOUSE12 = {3, 3, 2, 2, 2};
        Integer[] FULLHOUSE13 = {3, 3, 4, 4, 4};
        Integer[] FULLHOUSE14 = {3, 3, 5, 5, 5};
        Integer[] FULLHOUSE15 = {3, 3, 6, 6, 6};
        Integer[] FULLHOUSE16 = {4, 4, 1, 1, 1};
        Integer[] FULLHOUSE17 = {4, 4, 2, 2, 2};
        Integer[] FULLHOUSE18 = {4, 4, 3, 3, 3};
        Integer[] FULLHOUSE19 = {4, 4, 5, 5, 5};
        Integer[] FULLHOUSE20 = {4, 4, 6, 6, 6};
        Integer[] FULLHOUSE21 = {5, 5, 1, 1, 1};
        Integer[] FULLHOUSE22 = {5, 5, 2, 2, 2};
        Integer[] FULLHOUSE23 = {5, 5, 3, 3, 3};
        Integer[] FULLHOUSE24 = {5, 5, 4, 4, 4};
        Integer[] FULLHOUSE25 = {5, 5, 6, 6, 6};
        Integer[] FULLHOUSE26 = {6, 6, 1, 1, 1};
        Integer[] FULLHOUSE27 = {6, 6, 2, 2, 2};
        Integer[] FULLHOUSE28 = {6, 6, 3, 3, 3};
        Integer[] FULLHOUSE29 = {6, 6, 4, 4, 4};
        Integer[] FULLHOUSE30 = {6, 6, 5, 5, 5};
        Integer[] SMALLSTRIGHT1 = {1, 2, 3, 4};
        Integer[] SMALLSTRAIGHT2 = {2, 3, 4, 5};
        Integer[] SMALLSTRAIGHT3 = {3, 4, 5, 6};
        Integer[] LARGESTRAIGHT2 = {2, 3, 4, 5, 6};
        Integer[] LARGESTRAIGHT1 = {1, 2, 3, 4, 5};
        Integer[] YATZEE6 = {6, 6, 6, 6, 6};
        Integer[] YATZEE3 = {3, 3, 3, 3, 3};
        Integer[] YATZEE1 = {1, 1, 1, 1, 1};
        Integer[] YATZEE2 = {2, 2, 2, 2, 2};
        Integer[] YATZEE4 = {4, 4, 4, 4, 4};
        Integer[] YATZEE5 = {5, 5, 5, 5, 5};
        Integer[] CHANCE = {1, 2};

        mDiceCombosMap.put(CombinationType.ONEACE, ONEACE);
        mDiceCombosMap.put(CombinationType.TWOACES, TWOACES);
        mDiceCombosMap.put(CombinationType.THREEACES, THREEACES);
        mDiceCombosMap.put(CombinationType.FOURACES, FOURACES);
        mDiceCombosMap.put(CombinationType.FIVEACES, FIVEACES);
        mDiceCombosMap.put(CombinationType.ONETWO, ONETWO);
        mDiceCombosMap.put(CombinationType.TWOTWOS, TWOTWOS);
        mDiceCombosMap.put(CombinationType.THREETWOS, THREETWOS);
        mDiceCombosMap.put(CombinationType.FOURTWOS, FOURTWOS);
        mDiceCombosMap.put(CombinationType.FIVETWOS, FIVETWOS);
        mDiceCombosMap.put(CombinationType.ONETHREES, ONETHREES);
        mDiceCombosMap.put(CombinationType.TWOTHREES, TWOTHREES);
        mDiceCombosMap.put(CombinationType.THREETHREES, THREETHREES);
        mDiceCombosMap.put(CombinationType.FOURTHREES, FOURTHREES);
        mDiceCombosMap.put(CombinationType.FIVETHREES, FIVETHREES);
        mDiceCombosMap.put(CombinationType.ONEFOUR, ONEFOUR);
        mDiceCombosMap.put(CombinationType.TWOFOURS, TWOFOURS);
        mDiceCombosMap.put(CombinationType.THREEFOURS, THREEFOURS);
        mDiceCombosMap.put(CombinationType.FOURFOURS, FOURFOURS);
        mDiceCombosMap.put(CombinationType.FIVEFOURS, FIVEFOURS);
        mDiceCombosMap.put(CombinationType.ONEFIVE, ONEFIVE);
        mDiceCombosMap.put(CombinationType.TWOFIVES, TWOFIVES);
        mDiceCombosMap.put(CombinationType.THREEFIVES, THREEFIVES);
        mDiceCombosMap.put(CombinationType.FOURFIVES, FOURFIVES);
        mDiceCombosMap.put(CombinationType.FIVEFIVES, FIVEFIVES);
        mDiceCombosMap.put(CombinationType.ONESIX, ONESIX);
        mDiceCombosMap.put(CombinationType.TWOSIXES, TWOSIXES);
        mDiceCombosMap.put(CombinationType.THREESIXES, THREESIXES);
        mDiceCombosMap.put(CombinationType.FOURSIXES, FOURSIXES);
        mDiceCombosMap.put(CombinationType.FIVESIXES, FIVESIXES);
        mDiceCombosMap.put(CombinationType.THREEOFAONES, THREEOFAONES);
        mDiceCombosMap.put(CombinationType.THREEOFATWOS, THREEOFATWOS);
        mDiceCombosMap.put(CombinationType.THREEOFATHREES, THREEOFATHREES);
        mDiceCombosMap.put(CombinationType.THREEOFAFOURS, THREEOFAFOURS);
        mDiceCombosMap.put(CombinationType.THREEOFAFIVES, THREEOFAFIVES);
        mDiceCombosMap.put(CombinationType.THREEOFASIXES, THREEOFASIXES);
        mDiceCombosMap.put(CombinationType.FOUROFAONES, FOUROFAONES);
        mDiceCombosMap.put(CombinationType.FOUROFATWOS, FOUROFATWOS);
        mDiceCombosMap.put(CombinationType.FOUROFATHREES, FOUROFATHREES);
        mDiceCombosMap.put(CombinationType.FOUROFAFOURS, FOUROFAFOURS);
        mDiceCombosMap.put(CombinationType.FOUROFAFIVES, FOUROFAFIVES);
        mDiceCombosMap.put(CombinationType.FOUROFASIXES, FOUROFASIXES);
        mDiceCombosMap.put(CombinationType.FULLHOUSE1, FULLHOUSE1);
        mDiceCombosMap.put(CombinationType.FULLHOUSE2, FULLHOUSE2);
        mDiceCombosMap.put(CombinationType.FULLHOUSE3, FULLHOUSE3);
        mDiceCombosMap.put(CombinationType.FULLHOUSE4, FULLHOUSE4);
        mDiceCombosMap.put(CombinationType.FULLHOUSE5, FULLHOUSE5);
        mDiceCombosMap.put(CombinationType.FULLHOUSE6, FULLHOUSE6);
        mDiceCombosMap.put(CombinationType.FULLHOUSE7, FULLHOUSE7);
        mDiceCombosMap.put(CombinationType.FULLHOUSE8, FULLHOUSE8);
        mDiceCombosMap.put(CombinationType.FULLHOUSE9, FULLHOUSE9);
        mDiceCombosMap.put(CombinationType.FULLHOUSE10, FULLHOUSE10);
        mDiceCombosMap.put(CombinationType.FULLHOUSE11, FULLHOUSE11);
        mDiceCombosMap.put(CombinationType.FULLHOUSE12, FULLHOUSE12);
        mDiceCombosMap.put(CombinationType.FULLHOUSE13, FULLHOUSE13);
        mDiceCombosMap.put(CombinationType.FULLHOUSE14, FULLHOUSE14);
        mDiceCombosMap.put(CombinationType.FULLHOUSE15, FULLHOUSE15);
        mDiceCombosMap.put(CombinationType.FULLHOUSE16, FULLHOUSE16);
        mDiceCombosMap.put(CombinationType.FULLHOUSE17, FULLHOUSE17);
        mDiceCombosMap.put(CombinationType.FULLHOUSE18, FULLHOUSE18);
        mDiceCombosMap.put(CombinationType.FULLHOUSE19, FULLHOUSE19);
        mDiceCombosMap.put(CombinationType.FULLHOUSE20, FULLHOUSE20);
        mDiceCombosMap.put(CombinationType.FULLHOUSE21, FULLHOUSE21);
        mDiceCombosMap.put(CombinationType.FULLHOUSE22, FULLHOUSE22);
        mDiceCombosMap.put(CombinationType.FULLHOUSE23, FULLHOUSE23);
        mDiceCombosMap.put(CombinationType.FULLHOUSE24, FULLHOUSE24);
        mDiceCombosMap.put(CombinationType.FULLHOUSE25, FULLHOUSE25);
        mDiceCombosMap.put(CombinationType.FULLHOUSE26, FULLHOUSE26);
        mDiceCombosMap.put(CombinationType.FULLHOUSE27, FULLHOUSE27);
        mDiceCombosMap.put(CombinationType.FULLHOUSE28, FULLHOUSE28);
        mDiceCombosMap.put(CombinationType.FULLHOUSE29, FULLHOUSE29);
        mDiceCombosMap.put(CombinationType.FULLHOUSE30, FULLHOUSE30);
        mDiceCombosMap.put(CombinationType.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mDiceCombosMap.put(CombinationType.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mDiceCombosMap.put(CombinationType.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mDiceCombosMap.put(CombinationType.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mDiceCombosMap.put(CombinationType.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mDiceCombosMap.put(CombinationType.YATZEE1, YATZEE1);
        mDiceCombosMap.put(CombinationType.YATZEE2, YATZEE2);
        mDiceCombosMap.put(CombinationType.YATZEE3, YATZEE3);
        mDiceCombosMap.put(CombinationType.YATZEE4, YATZEE4);
        mDiceCombosMap.put(CombinationType.YATZEE5, YATZEE5);
        mDiceCombosMap.put(CombinationType.YATZEE6, YATZEE6);
        mDiceCombosMap.put(CombinationType.CHANCE, CHANCE);


    }

    private void toMapString() {
        String ONEACE ="One Ace";
        String TWOACES ="Two Aces";
        String THREEACES ="Three Aces";
        String FOURACES ="Four Aces";
        String FIVEACES ="Five Aces";
        String ONETWO ="One Two";
        String TWOTWOS ="Two Twos";
        String THREETWOS ="Three Twos";
        String FOURTWOS ="Four Twos";
        String FIVETWOS ="Five Twos";
        String ONETHREES ="One Three";
        String TWOTHREES ="Two Threes";
        String THREETHREES ="Three Threes";
        String FOURTHREES ="Four Threes";
        String FIVETHREES ="Five Threes";
        String ONEFOUR ="One Four";
        String TWOFOURS ="Two Fours";
        String THREEFOURS ="Three Fours";
        String FOURFOURS ="Four Fours";
        String FIVEFOURS ="Five Twos";
        String ONEFIVE ="One Five";
        String TWOFIVES ="Two Fives";
        String THREEFIVES ="Three Fives";
        String FOURFIVES ="Four Fives";
        String FIVEFIVES ="Five Fives";
        String ONESIX ="One Six";
        String TWOSIXES ="Two Sixes";
        String THREESIXES ="Three Sixes";
        String FOURSIXES ="Four Sixes";
        String FIVESIXES ="Five Sixes";
        String THREEOFAONES ="Three of a Kind: Ones";
        String THREEOFATWOS ="Three of a Kind: Twos";
        String THREEOFATHREES ="Three of a Kind: Threes";
        String THREEOFAFOURS ="Three of a Kind: Fours";
        String THREEOFAFIVES ="Three of a Kind: Fives";
        String THREEOFASIXES ="Three of a Kind: Sixes";
        String FOUROFAONES ="Four of a Kind: Ones";
        String FOUROFATWOS ="Four of a Kind: Twos";
        String FOUROFATHREES ="Four of a Kind: Threes";
        String FOUROFAFOURS ="Four of a Kind: Fours";
        String FOUROFAFIVES ="Four of a Kind: Fives";
        String FOUROFASIXES ="Four of a Kind: Sixes";
        String FULLHOUSE1 ="Full House";
        String FULLHOUSE2 ="Full House";
        String FULLHOUSE3 ="Full House";
        String FULLHOUSE4 ="Full House";
        String FULLHOUSE5 ="Full House";
        String FULLHOUSE6 ="Full House";
        String FULLHOUSE7 ="Full House";
        String FULLHOUSE8 ="Full House";
        String FULLHOUSE9 ="Full House";
        String FULLHOUSE10 ="Full House";
        String FULLHOUSE11 ="Full House";
        String FULLHOUSE12 ="Full House";
        String FULLHOUSE13 ="Full House";
        String FULLHOUSE14 ="Full House";
        String FULLHOUSE15 ="Full House";
        String FULLHOUSE16 ="Full House";
        String FULLHOUSE17 ="Full House";
        String FULLHOUSE18 ="Full House";
        String FULLHOUSE19 ="Full House";
        String FULLHOUSE20 ="Full House";
        String FULLHOUSE21 ="Full House";
        String FULLHOUSE22 ="Full House";
        String FULLHOUSE23 ="Full House";
        String FULLHOUSE24 ="Full House";
        String FULLHOUSE25 ="Full House";
        String FULLHOUSE26 ="Full House";
        String FULLHOUSE27 ="Full House";
        String FULLHOUSE28 ="Full House";
        String FULLHOUSE29 ="Full House";
        String FULLHOUSE30 ="Full House";
        String SMALLSTRIGHT1 ="Small Straight: 1,2,3,4";
        String SMALLSTRAIGHT2 ="Small Straight: 2,3,4,5";
        String SMALLSTRAIGHT3 ="Small Straight: 3,4,5,6";
        String LARGESTRAIGHT1 ="Large Straight: 1,2,3,4,5";
        String LARGESTRAIGHT2 ="Large Straight: 2,3,4,5,6";
        String YATZEE1 ="Yahtzee!";
        String YATZEE2 ="Yahtzee!";
        String YATZEE3 ="Yahtzee!";
        String YATZEE4 ="Yahtzee!";
        String YATZEE5 ="Yahtzee!";
        String YATZEE6 ="Yahtzee!";
        String CHANCE ="Chance";

        mStringMap.put(CombinationType.ONEACE, ONEACE);
        mStringMap.put(CombinationType.TWOACES, TWOACES);
        mStringMap.put(CombinationType.THREEACES, THREEACES);
        mStringMap.put(CombinationType.FOURACES, FOURACES);
        mStringMap.put(CombinationType.FIVEACES, FIVEACES);
        mStringMap.put(CombinationType.ONETWO, ONETWO);
        mStringMap.put(CombinationType.TWOTWOS, TWOTWOS);
        mStringMap.put(CombinationType.THREETWOS, THREETWOS);
        mStringMap.put(CombinationType.FOURTWOS, FOURTWOS);
        mStringMap.put(CombinationType.FIVETWOS, FIVETWOS);
        mStringMap.put(CombinationType.ONETHREES, ONETHREES);
        mStringMap.put(CombinationType.TWOTHREES, TWOTHREES);
        mStringMap.put(CombinationType.THREETHREES, THREETHREES);
        mStringMap.put(CombinationType.FOURTHREES, FOURTHREES);
        mStringMap.put(CombinationType.FIVETHREES, FIVETHREES);
        mStringMap.put(CombinationType.ONEFOUR, ONEFOUR);
        mStringMap.put(CombinationType.TWOFOURS, TWOFOURS);
        mStringMap.put(CombinationType.THREEFOURS, THREEFOURS);
        mStringMap.put(CombinationType.FOURFOURS, FOURFOURS);
        mStringMap.put(CombinationType.FIVEFOURS, FIVEFOURS);
        mStringMap.put(CombinationType.ONEFIVE, ONEFIVE);
        mStringMap.put(CombinationType.TWOFIVES, TWOFIVES);
        mStringMap.put(CombinationType.THREEFIVES, THREEFIVES);
        mStringMap.put(CombinationType.FOURFIVES, FOURFIVES);
        mStringMap.put(CombinationType.FIVEFIVES, FIVEFIVES);
        mStringMap.put(CombinationType.ONESIX, ONESIX);
        mStringMap.put(CombinationType.TWOSIXES, TWOSIXES);
        mStringMap.put(CombinationType.THREESIXES, THREESIXES);
        mStringMap.put(CombinationType.FOURSIXES, FOURSIXES);
        mStringMap.put(CombinationType.FIVESIXES, FIVESIXES);
        mStringMap.put(CombinationType.THREEOFAONES, THREEOFAONES);
        mStringMap.put(CombinationType.THREEOFATWOS, THREEOFATWOS);
        mStringMap.put(CombinationType.THREEOFATHREES, THREEOFATHREES);
        mStringMap.put(CombinationType.THREEOFAFOURS, THREEOFAFOURS);
        mStringMap.put(CombinationType.THREEOFAFIVES, THREEOFAFIVES);
        mStringMap.put(CombinationType.THREEOFASIXES, THREEOFASIXES);
        mStringMap.put(CombinationType.FOUROFAONES, FOUROFAONES);
        mStringMap.put(CombinationType.FOUROFATWOS, FOUROFATWOS);
        mStringMap.put(CombinationType.FOUROFATHREES, FOUROFATHREES);
        mStringMap.put(CombinationType.FOUROFAFOURS, FOUROFAFOURS);
        mStringMap.put(CombinationType.FOUROFAFIVES, FOUROFAFIVES);
        mStringMap.put(CombinationType.FOUROFASIXES, FOUROFASIXES);
        mStringMap.put(CombinationType.FULLHOUSE1, FULLHOUSE1);
        mStringMap.put(CombinationType.FULLHOUSE2, FULLHOUSE2);
        mStringMap.put(CombinationType.FULLHOUSE3, FULLHOUSE3);
        mStringMap.put(CombinationType.FULLHOUSE4, FULLHOUSE4);
        mStringMap.put(CombinationType.FULLHOUSE5, FULLHOUSE5);
        mStringMap.put(CombinationType.FULLHOUSE6, FULLHOUSE6);
        mStringMap.put(CombinationType.FULLHOUSE7, FULLHOUSE7);
        mStringMap.put(CombinationType.FULLHOUSE8, FULLHOUSE8);
        mStringMap.put(CombinationType.FULLHOUSE9, FULLHOUSE9);
        mStringMap.put(CombinationType.FULLHOUSE10, FULLHOUSE10);
        mStringMap.put(CombinationType.FULLHOUSE11, FULLHOUSE11);
        mStringMap.put(CombinationType.FULLHOUSE12, FULLHOUSE12);
        mStringMap.put(CombinationType.FULLHOUSE13, FULLHOUSE13);
        mStringMap.put(CombinationType.FULLHOUSE14, FULLHOUSE14);
        mStringMap.put(CombinationType.FULLHOUSE15, FULLHOUSE15);
        mStringMap.put(CombinationType.FULLHOUSE16, FULLHOUSE16);
        mStringMap.put(CombinationType.FULLHOUSE17, FULLHOUSE17);
        mStringMap.put(CombinationType.FULLHOUSE18, FULLHOUSE18);
        mStringMap.put(CombinationType.FULLHOUSE19, FULLHOUSE19);
        mStringMap.put(CombinationType.FULLHOUSE20, FULLHOUSE20);
        mStringMap.put(CombinationType.FULLHOUSE21, FULLHOUSE21);
        mStringMap.put(CombinationType.FULLHOUSE22, FULLHOUSE22);
        mStringMap.put(CombinationType.FULLHOUSE23, FULLHOUSE23);
        mStringMap.put(CombinationType.FULLHOUSE24, FULLHOUSE24);
        mStringMap.put(CombinationType.FULLHOUSE25, FULLHOUSE25);
        mStringMap.put(CombinationType.FULLHOUSE26, FULLHOUSE26);
        mStringMap.put(CombinationType.FULLHOUSE27, FULLHOUSE27);
        mStringMap.put(CombinationType.FULLHOUSE28, FULLHOUSE28);
        mStringMap.put(CombinationType.FULLHOUSE29, FULLHOUSE29);
        mStringMap.put(CombinationType.FULLHOUSE30, FULLHOUSE30);
        mStringMap.put(CombinationType.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mStringMap.put(CombinationType.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mStringMap.put(CombinationType.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mStringMap.put(CombinationType.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mStringMap.put(CombinationType.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mStringMap.put(CombinationType.YATZEE1, YATZEE1);
        mStringMap.put(CombinationType.YATZEE2, YATZEE2);
        mStringMap.put(CombinationType.YATZEE3, YATZEE3);
        mStringMap.put(CombinationType.YATZEE4, YATZEE4);
        mStringMap.put(CombinationType.YATZEE5, YATZEE5);
        mStringMap.put(CombinationType.YATZEE6, YATZEE6);
        mStringMap.put(CombinationType.CHANCE, CHANCE);

    }

    private void toMapCombinationValues() {
        Integer ONEACE = 1;
        Integer TWOACES = 2;
        Integer THREEACES = 3;
        Integer FOURACES = 4;
        Integer FIVEACES = 5;
        Integer ONETWO = 2;
        Integer TWOTWOS = 4;
        Integer THREETWOS = 6;
        Integer FOURTWOS = 8;
        Integer FIVETWOS = 10;
        Integer ONETHREES = 3;
        Integer TWOTHREES = 6;
        Integer THREETHREES = 9;
        Integer FOURTHREES = 12;
        Integer FIVETHREES = 15;
        Integer ONEFOUR = 4;
        Integer TWOFOURS = 8;
        Integer THREEFOURS = 12;
        Integer FOURFOURS = 8;
        Integer FIVEFOURS = 20;
        Integer ONEFIVE = 5;
        Integer TWOFIVES = 10;
        Integer THREEFIVES = 15;
        Integer FOURFIVES = 20;
        Integer FIVEFIVES = 25;
        Integer ONESIX = 6;
        Integer TWOSIXES = 12;
        Integer THREESIXES = 18;
        Integer FOURSIXES = 24;
        Integer FIVESIXES = 30;
        Integer THREEOFAONES = 3;
        Integer THREEOFATWOS = 6;
        Integer THREEOFATHREES = 9;
        Integer THREEOFAFOURS = 12;
        Integer THREEOFAFIVES = 15;
        Integer THREEOFASIXES = 18;
        Integer FOUROFAONES = 4;
        Integer FOUROFATWOS = 8;
        Integer FOUROFATHREES = 12;
        Integer FOUROFAFOURS = 16;
        Integer FOUROFAFIVES = 20;
        Integer FOUROFASIXES = 24;
        Integer FULLHOUSE1 = 25;
        Integer FULLHOUSE2 = 25;
        Integer FULLHOUSE3 = 25;
        Integer FULLHOUSE4 = 25;
        Integer FULLHOUSE5 = 25;
        Integer FULLHOUSE6 = 25;
        Integer FULLHOUSE7 = 25;
        Integer FULLHOUSE8 = 25;
        Integer FULLHOUSE9 = 25;
        Integer FULLHOUSE10 = 25;
        Integer FULLHOUSE11 = 25;
        Integer FULLHOUSE12 = 25;
        Integer FULLHOUSE13 = 25;
        Integer FULLHOUSE14 = 25;
        Integer FULLHOUSE15 = 25;
        Integer FULLHOUSE16 = 25;
        Integer FULLHOUSE17 = 25;
        Integer FULLHOUSE18 = 25;
        Integer FULLHOUSE19 = 25;
        Integer FULLHOUSE20 = 25;
        Integer FULLHOUSE21 = 25;
        Integer FULLHOUSE22 = 25;
        Integer FULLHOUSE23 = 25;
        Integer FULLHOUSE24 = 25;
        Integer FULLHOUSE25 = 25;
        Integer FULLHOUSE26 = 25;
        Integer FULLHOUSE27 = 25;
        Integer FULLHOUSE28 = 25;
        Integer FULLHOUSE29 = 25;
        Integer FULLHOUSE30 = 25;
        Integer SMALLSTRIGHT1 = 30;
        Integer SMALLSTRAIGHT2 = 30;
        Integer SMALLSTRAIGHT3 = 30;
        Integer LARGESTRAIGHT1 = 40;
        Integer LARGESTRAIGHT2 = 40;
        Integer YATZEE1 = 50;
        Integer YATZEE2 = 50;
        Integer YATZEE3 = 50;
        Integer YATZEE4 = 50;
        Integer YATZEE5 = 50;
        Integer YATZEE6 = 50;
        Integer CHANCE = 0;

        mDiceComboValues.put(CombinationType.ONEACE, ONEACE);
        mDiceComboValues.put(CombinationType.TWOACES, TWOACES);
        mDiceComboValues.put(CombinationType.THREEACES, THREEACES);
        mDiceComboValues.put(CombinationType.FOURACES, FOURACES);
        mDiceComboValues.put(CombinationType.FIVEACES, FIVEACES);
        mDiceComboValues.put(CombinationType.ONETWO, ONETWO);
        mDiceComboValues.put(CombinationType.TWOTWOS, TWOTWOS);
        mDiceComboValues.put(CombinationType.THREETWOS, THREETWOS);
        mDiceComboValues.put(CombinationType.FOURTWOS, FOURTWOS);
        mDiceComboValues.put(CombinationType.FIVETWOS, FIVETWOS);
        mDiceComboValues.put(CombinationType.ONETHREES, ONETHREES);
        mDiceComboValues.put(CombinationType.TWOTHREES, TWOTHREES);
        mDiceComboValues.put(CombinationType.THREETHREES, THREETHREES);
        mDiceComboValues.put(CombinationType.FOURTHREES, FOURTHREES);
        mDiceComboValues.put(CombinationType.FIVETHREES, FIVETHREES);
        mDiceComboValues.put(CombinationType.ONEFOUR, ONEFOUR);
        mDiceComboValues.put(CombinationType.TWOFOURS, TWOFOURS);
        mDiceComboValues.put(CombinationType.THREEFOURS, THREEFOURS);
        mDiceComboValues.put(CombinationType.FOURFOURS, FOURFOURS);
        mDiceComboValues.put(CombinationType.FIVEFOURS, FIVEFOURS);
        mDiceComboValues.put(CombinationType.ONEFIVE, ONEFIVE);
        mDiceComboValues.put(CombinationType.TWOFIVES, TWOFIVES);
        mDiceComboValues.put(CombinationType.THREEFIVES, THREEFIVES);
        mDiceComboValues.put(CombinationType.FOURFIVES, FOURFIVES);
        mDiceComboValues.put(CombinationType.FIVEFIVES, FIVEFIVES);
        mDiceComboValues.put(CombinationType.ONESIX, ONESIX);
        mDiceComboValues.put(CombinationType.TWOSIXES, TWOSIXES);
        mDiceComboValues.put(CombinationType.THREESIXES, THREESIXES);
        mDiceComboValues.put(CombinationType.FOURSIXES, FOURSIXES);
        mDiceComboValues.put(CombinationType.FIVESIXES, FIVESIXES);
        mDiceComboValues.put(CombinationType.THREEOFAONES, THREEOFAONES);
        mDiceComboValues.put(CombinationType.THREEOFATWOS, THREEOFATWOS);
        mDiceComboValues.put(CombinationType.THREEOFATHREES, THREEOFATHREES);
        mDiceComboValues.put(CombinationType.THREEOFAFOURS, THREEOFAFOURS);
        mDiceComboValues.put(CombinationType.THREEOFAFIVES, THREEOFAFIVES);
        mDiceComboValues.put(CombinationType.THREEOFASIXES, THREEOFASIXES);
        mDiceComboValues.put(CombinationType.FOUROFAONES, FOUROFAONES);
        mDiceComboValues.put(CombinationType.FOUROFATWOS, FOUROFATWOS);
        mDiceComboValues.put(CombinationType.FOUROFATHREES, FOUROFATHREES);
        mDiceComboValues.put(CombinationType.FOUROFAFOURS, FOUROFAFOURS);
        mDiceComboValues.put(CombinationType.FOUROFAFIVES, FOUROFAFIVES);
        mDiceComboValues.put(CombinationType.FOUROFASIXES, FOUROFASIXES);
        mDiceComboValues.put(CombinationType.FULLHOUSE1, FULLHOUSE1);
        mDiceComboValues.put(CombinationType.FULLHOUSE2, FULLHOUSE2);
        mDiceComboValues.put(CombinationType.FULLHOUSE3, FULLHOUSE3);
        mDiceComboValues.put(CombinationType.FULLHOUSE4, FULLHOUSE4);
        mDiceComboValues.put(CombinationType.FULLHOUSE5, FULLHOUSE5);
        mDiceComboValues.put(CombinationType.FULLHOUSE6, FULLHOUSE6);
        mDiceComboValues.put(CombinationType.FULLHOUSE7, FULLHOUSE7);
        mDiceComboValues.put(CombinationType.FULLHOUSE8, FULLHOUSE8);
        mDiceComboValues.put(CombinationType.FULLHOUSE9, FULLHOUSE9);
        mDiceComboValues.put(CombinationType.FULLHOUSE10, FULLHOUSE10);
        mDiceComboValues.put(CombinationType.FULLHOUSE11, FULLHOUSE11);
        mDiceComboValues.put(CombinationType.FULLHOUSE12, FULLHOUSE12);
        mDiceComboValues.put(CombinationType.FULLHOUSE13, FULLHOUSE13);
        mDiceComboValues.put(CombinationType.FULLHOUSE14, FULLHOUSE14);
        mDiceComboValues.put(CombinationType.FULLHOUSE15, FULLHOUSE15);
        mDiceComboValues.put(CombinationType.FULLHOUSE16, FULLHOUSE16);
        mDiceComboValues.put(CombinationType.FULLHOUSE17, FULLHOUSE17);
        mDiceComboValues.put(CombinationType.FULLHOUSE18, FULLHOUSE18);
        mDiceComboValues.put(CombinationType.FULLHOUSE19, FULLHOUSE19);
        mDiceComboValues.put(CombinationType.FULLHOUSE20, FULLHOUSE20);
        mDiceComboValues.put(CombinationType.FULLHOUSE21, FULLHOUSE21);
        mDiceComboValues.put(CombinationType.FULLHOUSE22, FULLHOUSE22);
        mDiceComboValues.put(CombinationType.FULLHOUSE23, FULLHOUSE23);
        mDiceComboValues.put(CombinationType.FULLHOUSE24, FULLHOUSE24);
        mDiceComboValues.put(CombinationType.FULLHOUSE25, FULLHOUSE25);
        mDiceComboValues.put(CombinationType.FULLHOUSE26, FULLHOUSE26);
        mDiceComboValues.put(CombinationType.FULLHOUSE27, FULLHOUSE27);
        mDiceComboValues.put(CombinationType.FULLHOUSE28, FULLHOUSE28);
        mDiceComboValues.put(CombinationType.FULLHOUSE29, FULLHOUSE29);
        mDiceComboValues.put(CombinationType.FULLHOUSE30, FULLHOUSE30);
        mDiceComboValues.put(CombinationType.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mDiceComboValues.put(CombinationType.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mDiceComboValues.put(CombinationType.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mDiceComboValues.put(CombinationType.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mDiceComboValues.put(CombinationType.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mDiceComboValues.put(CombinationType.YATZEE1, YATZEE1);
        mDiceComboValues.put(CombinationType.YATZEE2, YATZEE2);
        mDiceComboValues.put(CombinationType.YATZEE3, YATZEE3);
        mDiceComboValues.put(CombinationType.YATZEE4, YATZEE4);
        mDiceComboValues.put(CombinationType.YATZEE5, YATZEE5);
        mDiceComboValues.put(CombinationType.YATZEE6, YATZEE6);
        mDiceComboValues.put(CombinationType.CHANCE, CHANCE);


    }

    public static ArrayList<CombinationType> compareCombo(ArrayList<Integer> list) {
        Combination combination = new Combination();
        ArrayList<CombinationType> results = new ArrayList<>();
        for (Map.Entry<CombinationType, Integer[]> combo : combination.mDiceCombosMap.entrySet()) {
            CombinationType key = combo.getKey();
            Integer[] value = combo.getValue();
            ArrayList<Integer> betterList = new ArrayList<Integer>();
            for (Integer integer : value) {
                betterList.add(integer);
            }
            if (isSubset(betterList,list)){
                results.add(key);
            }
        }
        return results;
    }

    public String getValue(CombinationType combinationType) {
        return mStringMap.get(combinationType);
    }

    public static void arrayToString(ArrayList<CombinationType> combinationTypes) {
        Combination combination = new Combination();
        for (CombinationType combinationType : combinationTypes){
            String words= combination.mStringMap.get(combinationType);
            System.out.println(words);
        }
        return;
    }

    private static boolean isSubset(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> copy1 = new ArrayList<>();
        ArrayList<Integer> copy2 = new ArrayList<>();
        for (Integer num: a1){
            copy1.add(num);
        }
        for (Integer num: a2){
            copy2.add(num);
        }


        for(int e = 0;e<copy1.size();e+=1){
            Integer a1Int = copy1.get(e);
            for (int i = 0; i<copy2.size();i+=1) {
                if (copy2.get(i).equals(a1Int)) {
                    if (i < copy2.size() && e< copy1.size()) {
                        copy1.remove(e);
                        copy2.remove(i);
                        e--;
                        i--;
                    }
                    break;
                }
            }
            if (copy1.size()== 0) {
                return true;
            }
        }
        return false;
    }


}