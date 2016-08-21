package model;


import java.util.*;

/**
 * Created by madmann on 8/19/16.
 */


public class Combonation {

    private HashMap<Combonations, Integer[]> mDiceCombosMap = new HashMap<>();
    private HashMap<Combonations, Integer> mDiceComboValues = new HashMap<>();
    private HashMap<Combonations, String> mStringMap = new HashMap<>();

    public Combonation() {
        toMapDiceCombonations();
        toMapString();
        toMapCombonationValues();
    }

    private void toMapDiceCombonations() {
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

        mDiceCombosMap.put(Combonations.ONEACE, ONEACE);
        mDiceCombosMap.put(Combonations.TWOACES, TWOACES);
        mDiceCombosMap.put(Combonations.THREEACES, THREEACES);
        mDiceCombosMap.put(Combonations.FOURACES, FOURACES);
        mDiceCombosMap.put(Combonations.FIVEACES, FIVEACES);
        mDiceCombosMap.put(Combonations.ONETWO, ONETWO);
        mDiceCombosMap.put(Combonations.TWOTWOS, TWOTWOS);
        mDiceCombosMap.put(Combonations.THREETWOS, THREETWOS);
        mDiceCombosMap.put(Combonations.FOURTWOS, FOURTWOS);
        mDiceCombosMap.put(Combonations.FIVETWOS, FIVETWOS);
        mDiceCombosMap.put(Combonations.ONETHREES, ONETHREES);
        mDiceCombosMap.put(Combonations.TWOTHREES, TWOTHREES);
        mDiceCombosMap.put(Combonations.THREETHREES, THREETHREES);
        mDiceCombosMap.put(Combonations.FOURTHREES, FOURTHREES);
        mDiceCombosMap.put(Combonations.FIVETHREES, FIVETHREES);
        mDiceCombosMap.put(Combonations.ONEFOUR, ONEFOUR);
        mDiceCombosMap.put(Combonations.TWOFOURS, TWOFOURS);
        mDiceCombosMap.put(Combonations.THREEFOURS, THREEFOURS);
        mDiceCombosMap.put(Combonations.FOURFOURS, FOURFOURS);
        mDiceCombosMap.put(Combonations.FIVEFOURS, FIVEFOURS);
        mDiceCombosMap.put(Combonations.ONEFIVE, ONEFIVE);
        mDiceCombosMap.put(Combonations.TWOFIVES, TWOFIVES);
        mDiceCombosMap.put(Combonations.THREEFIVES, THREEFIVES);
        mDiceCombosMap.put(Combonations.FOURFIVES, FOURFIVES);
        mDiceCombosMap.put(Combonations.FIVEFIVES, FIVEFIVES);
        mDiceCombosMap.put(Combonations.ONESIX, ONESIX);
        mDiceCombosMap.put(Combonations.TWOSIXES, TWOSIXES);
        mDiceCombosMap.put(Combonations.THREESIXES, THREESIXES);
        mDiceCombosMap.put(Combonations.FOURSIXES, FOURSIXES);
        mDiceCombosMap.put(Combonations.FIVESIXES, FIVESIXES);
        mDiceCombosMap.put(Combonations.THREEOFAONES, THREEOFAONES);
        mDiceCombosMap.put(Combonations.THREEOFATWOS, THREEOFATWOS);
        mDiceCombosMap.put(Combonations.THREEOFATHREES, THREEOFATHREES);
        mDiceCombosMap.put(Combonations.THREEOFAFOURS, THREEOFAFOURS);
        mDiceCombosMap.put(Combonations.THREEOFAFIVES, THREEOFAFIVES);
        mDiceCombosMap.put(Combonations.THREEOFASIXES, THREEOFASIXES);
        mDiceCombosMap.put(Combonations.FOUROFAONES, FOUROFAONES);
        mDiceCombosMap.put(Combonations.FOUROFATWOS, FOUROFATWOS);
        mDiceCombosMap.put(Combonations.FOUROFATHREES, FOUROFATHREES);
        mDiceCombosMap.put(Combonations.FOUROFAFOURS, FOUROFAFOURS);
        mDiceCombosMap.put(Combonations.FOUROFAFIVES, FOUROFAFIVES);
        mDiceCombosMap.put(Combonations.FOUROFASIXES, FOUROFASIXES);
        mDiceCombosMap.put(Combonations.FULLHOUSE1, FULLHOUSE1);
        mDiceCombosMap.put(Combonations.FULLHOUSE2, FULLHOUSE2);
        mDiceCombosMap.put(Combonations.FULLHOUSE3, FULLHOUSE3);
        mDiceCombosMap.put(Combonations.FULLHOUSE4, FULLHOUSE4);
        mDiceCombosMap.put(Combonations.FULLHOUSE5, FULLHOUSE5);
        mDiceCombosMap.put(Combonations.FULLHOUSE6, FULLHOUSE6);
        mDiceCombosMap.put(Combonations.FULLHOUSE7, FULLHOUSE7);
        mDiceCombosMap.put(Combonations.FULLHOUSE8, FULLHOUSE8);
        mDiceCombosMap.put(Combonations.FULLHOUSE9, FULLHOUSE9);
        mDiceCombosMap.put(Combonations.FULLHOUSE10, FULLHOUSE10);
        mDiceCombosMap.put(Combonations.FULLHOUSE11, FULLHOUSE11);
        mDiceCombosMap.put(Combonations.FULLHOUSE12, FULLHOUSE12);
        mDiceCombosMap.put(Combonations.FULLHOUSE13, FULLHOUSE13);
        mDiceCombosMap.put(Combonations.FULLHOUSE14, FULLHOUSE14);
        mDiceCombosMap.put(Combonations.FULLHOUSE15, FULLHOUSE15);
        mDiceCombosMap.put(Combonations.FULLHOUSE16, FULLHOUSE16);
        mDiceCombosMap.put(Combonations.FULLHOUSE17, FULLHOUSE17);
        mDiceCombosMap.put(Combonations.FULLHOUSE18, FULLHOUSE18);
        mDiceCombosMap.put(Combonations.FULLHOUSE19, FULLHOUSE19);
        mDiceCombosMap.put(Combonations.FULLHOUSE20, FULLHOUSE20);
        mDiceCombosMap.put(Combonations.FULLHOUSE21, FULLHOUSE21);
        mDiceCombosMap.put(Combonations.FULLHOUSE22, FULLHOUSE22);
        mDiceCombosMap.put(Combonations.FULLHOUSE23, FULLHOUSE23);
        mDiceCombosMap.put(Combonations.FULLHOUSE24, FULLHOUSE24);
        mDiceCombosMap.put(Combonations.FULLHOUSE25, FULLHOUSE25);
        mDiceCombosMap.put(Combonations.FULLHOUSE26, FULLHOUSE26);
        mDiceCombosMap.put(Combonations.FULLHOUSE27, FULLHOUSE27);
        mDiceCombosMap.put(Combonations.FULLHOUSE28, FULLHOUSE28);
        mDiceCombosMap.put(Combonations.FULLHOUSE29, FULLHOUSE29);
        mDiceCombosMap.put(Combonations.FULLHOUSE30, FULLHOUSE30);
        mDiceCombosMap.put(Combonations.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mDiceCombosMap.put(Combonations.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mDiceCombosMap.put(Combonations.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mDiceCombosMap.put(Combonations.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mDiceCombosMap.put(Combonations.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mDiceCombosMap.put(Combonations.YATZEE1, YATZEE1);
        mDiceCombosMap.put(Combonations.YATZEE2, YATZEE2);
        mDiceCombosMap.put(Combonations.YATZEE3, YATZEE3);
        mDiceCombosMap.put(Combonations.YATZEE4, YATZEE4);
        mDiceCombosMap.put(Combonations.YATZEE5, YATZEE5);
        mDiceCombosMap.put(Combonations.YATZEE6, YATZEE6);
        mDiceCombosMap.put(Combonations.CHANCE, CHANCE);


    }

    //Test
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

        mStringMap.put(Combonations.ONEACE, ONEACE);
        mStringMap.put(Combonations.TWOACES, TWOACES);
        mStringMap.put(Combonations.THREEACES, THREEACES);
        mStringMap.put(Combonations.FOURACES, FOURACES);
        mStringMap.put(Combonations.FIVEACES, FIVEACES);
        mStringMap.put(Combonations.ONETWO, ONETWO);
        mStringMap.put(Combonations.TWOTWOS, TWOTWOS);
        mStringMap.put(Combonations.THREETWOS, THREETWOS);
        mStringMap.put(Combonations.FOURTWOS, FOURTWOS);
        mStringMap.put(Combonations.FIVETWOS, FIVETWOS);
        mStringMap.put(Combonations.ONETHREES, ONETHREES);
        mStringMap.put(Combonations.TWOTHREES, TWOTHREES);
        mStringMap.put(Combonations.THREETHREES, THREETHREES);
        mStringMap.put(Combonations.FOURTHREES, FOURTHREES);
        mStringMap.put(Combonations.FIVETHREES, FIVETHREES);
        mStringMap.put(Combonations.ONEFOUR, ONEFOUR);
        mStringMap.put(Combonations.TWOFOURS, TWOFOURS);
        mStringMap.put(Combonations.THREEFOURS, THREEFOURS);
        mStringMap.put(Combonations.FOURFOURS, FOURFOURS);
        mStringMap.put(Combonations.FIVEFOURS, FIVEFOURS);
        mStringMap.put(Combonations.ONEFIVE, ONEFIVE);
        mStringMap.put(Combonations.TWOFIVES, TWOFIVES);
        mStringMap.put(Combonations.THREEFIVES, THREEFIVES);
        mStringMap.put(Combonations.FOURFIVES, FOURFIVES);
        mStringMap.put(Combonations.FIVEFIVES, FIVEFIVES);
        mStringMap.put(Combonations.ONESIX, ONESIX);
        mStringMap.put(Combonations.TWOSIXES, TWOSIXES);
        mStringMap.put(Combonations.THREESIXES, THREESIXES);
        mStringMap.put(Combonations.FOURSIXES, FOURSIXES);
        mStringMap.put(Combonations.FIVESIXES, FIVESIXES);
        mStringMap.put(Combonations.THREEOFAONES, THREEOFAONES);
        mStringMap.put(Combonations.THREEOFATWOS, THREEOFATWOS);
        mStringMap.put(Combonations.THREEOFATHREES, THREEOFATHREES);
        mStringMap.put(Combonations.THREEOFAFOURS, THREEOFAFOURS);
        mStringMap.put(Combonations.THREEOFAFIVES, THREEOFAFIVES);
        mStringMap.put(Combonations.THREEOFASIXES, THREEOFASIXES);
        mStringMap.put(Combonations.FOUROFAONES, FOUROFAONES);
        mStringMap.put(Combonations.FOUROFATWOS, FOUROFATWOS);
        mStringMap.put(Combonations.FOUROFATHREES, FOUROFATHREES);
        mStringMap.put(Combonations.FOUROFAFOURS, FOUROFAFOURS);
        mStringMap.put(Combonations.FOUROFAFIVES, FOUROFAFIVES);
        mStringMap.put(Combonations.FOUROFASIXES, FOUROFASIXES);
        mStringMap.put(Combonations.FULLHOUSE1, FULLHOUSE1);
        mStringMap.put(Combonations.FULLHOUSE2, FULLHOUSE2);
        mStringMap.put(Combonations.FULLHOUSE3, FULLHOUSE3);
        mStringMap.put(Combonations.FULLHOUSE4, FULLHOUSE4);
        mStringMap.put(Combonations.FULLHOUSE5, FULLHOUSE5);
        mStringMap.put(Combonations.FULLHOUSE6, FULLHOUSE6);
        mStringMap.put(Combonations.FULLHOUSE7, FULLHOUSE7);
        mStringMap.put(Combonations.FULLHOUSE8, FULLHOUSE8);
        mStringMap.put(Combonations.FULLHOUSE9, FULLHOUSE9);
        mStringMap.put(Combonations.FULLHOUSE10, FULLHOUSE10);
        mStringMap.put(Combonations.FULLHOUSE11, FULLHOUSE11);
        mStringMap.put(Combonations.FULLHOUSE12, FULLHOUSE12);
        mStringMap.put(Combonations.FULLHOUSE13, FULLHOUSE13);
        mStringMap.put(Combonations.FULLHOUSE14, FULLHOUSE14);
        mStringMap.put(Combonations.FULLHOUSE15, FULLHOUSE15);
        mStringMap.put(Combonations.FULLHOUSE16, FULLHOUSE16);
        mStringMap.put(Combonations.FULLHOUSE17, FULLHOUSE17);
        mStringMap.put(Combonations.FULLHOUSE18, FULLHOUSE18);
        mStringMap.put(Combonations.FULLHOUSE19, FULLHOUSE19);
        mStringMap.put(Combonations.FULLHOUSE20, FULLHOUSE20);
        mStringMap.put(Combonations.FULLHOUSE21, FULLHOUSE21);
        mStringMap.put(Combonations.FULLHOUSE22, FULLHOUSE22);
        mStringMap.put(Combonations.FULLHOUSE23, FULLHOUSE23);
        mStringMap.put(Combonations.FULLHOUSE24, FULLHOUSE24);
        mStringMap.put(Combonations.FULLHOUSE25, FULLHOUSE25);
        mStringMap.put(Combonations.FULLHOUSE26, FULLHOUSE26);
        mStringMap.put(Combonations.FULLHOUSE27, FULLHOUSE27);
        mStringMap.put(Combonations.FULLHOUSE28, FULLHOUSE28);
        mStringMap.put(Combonations.FULLHOUSE29, FULLHOUSE29);
        mStringMap.put(Combonations.FULLHOUSE30, FULLHOUSE30);
        mStringMap.put(Combonations.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mStringMap.put(Combonations.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mStringMap.put(Combonations.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mStringMap.put(Combonations.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mStringMap.put(Combonations.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mStringMap.put(Combonations.YATZEE1, YATZEE1);
        mStringMap.put(Combonations.YATZEE2, YATZEE2);
        mStringMap.put(Combonations.YATZEE3, YATZEE3);
        mStringMap.put(Combonations.YATZEE4, YATZEE4);
        mStringMap.put(Combonations.YATZEE5, YATZEE5);
        mStringMap.put(Combonations.YATZEE6, YATZEE6);
        mStringMap.put(Combonations.CHANCE, CHANCE);

    }

    private void toMapCombonationValues() {
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

        mDiceComboValues.put(Combonations.ONEACE, ONEACE);
        mDiceComboValues.put(Combonations.TWOACES, TWOACES);
        mDiceComboValues.put(Combonations.THREEACES, THREEACES);
        mDiceComboValues.put(Combonations.FOURACES, FOURACES);
        mDiceComboValues.put(Combonations.FIVEACES, FIVEACES);
        mDiceComboValues.put(Combonations.ONETWO, ONETWO);
        mDiceComboValues.put(Combonations.TWOTWOS, TWOTWOS);
        mDiceComboValues.put(Combonations.THREETWOS, THREETWOS);
        mDiceComboValues.put(Combonations.FOURTWOS, FOURTWOS);
        mDiceComboValues.put(Combonations.FIVETWOS, FIVETWOS);
        mDiceComboValues.put(Combonations.ONETHREES, ONETHREES);
        mDiceComboValues.put(Combonations.TWOTHREES, TWOTHREES);
        mDiceComboValues.put(Combonations.THREETHREES, THREETHREES);
        mDiceComboValues.put(Combonations.FOURTHREES, FOURTHREES);
        mDiceComboValues.put(Combonations.FIVETHREES, FIVETHREES);
        mDiceComboValues.put(Combonations.ONEFOUR, ONEFOUR);
        mDiceComboValues.put(Combonations.TWOFOURS, TWOFOURS);
        mDiceComboValues.put(Combonations.THREEFOURS, THREEFOURS);
        mDiceComboValues.put(Combonations.FOURFOURS, FOURFOURS);
        mDiceComboValues.put(Combonations.FIVEFOURS, FIVEFOURS);
        mDiceComboValues.put(Combonations.ONEFIVE, ONEFIVE);
        mDiceComboValues.put(Combonations.TWOFIVES, TWOFIVES);
        mDiceComboValues.put(Combonations.THREEFIVES, THREEFIVES);
        mDiceComboValues.put(Combonations.FOURFIVES, FOURFIVES);
        mDiceComboValues.put(Combonations.FIVEFIVES, FIVEFIVES);
        mDiceComboValues.put(Combonations.ONESIX, ONESIX);
        mDiceComboValues.put(Combonations.TWOSIXES, TWOSIXES);
        mDiceComboValues.put(Combonations.THREESIXES, THREESIXES);
        mDiceComboValues.put(Combonations.FOURSIXES, FOURSIXES);
        mDiceComboValues.put(Combonations.FIVESIXES, FIVESIXES);
        mDiceComboValues.put(Combonations.THREEOFAONES, THREEOFAONES);
        mDiceComboValues.put(Combonations.THREEOFATWOS, THREEOFATWOS);
        mDiceComboValues.put(Combonations.THREEOFATHREES, THREEOFATHREES);
        mDiceComboValues.put(Combonations.THREEOFAFOURS, THREEOFAFOURS);
        mDiceComboValues.put(Combonations.THREEOFAFIVES, THREEOFAFIVES);
        mDiceComboValues.put(Combonations.THREEOFASIXES, THREEOFASIXES);
        mDiceComboValues.put(Combonations.FOUROFAONES, FOUROFAONES);
        mDiceComboValues.put(Combonations.FOUROFATWOS, FOUROFATWOS);
        mDiceComboValues.put(Combonations.FOUROFATHREES, FOUROFATHREES);
        mDiceComboValues.put(Combonations.FOUROFAFOURS, FOUROFAFOURS);
        mDiceComboValues.put(Combonations.FOUROFAFIVES, FOUROFAFIVES);
        mDiceComboValues.put(Combonations.FOUROFASIXES, FOUROFASIXES);
        mDiceComboValues.put(Combonations.FULLHOUSE1, FULLHOUSE1);
        mDiceComboValues.put(Combonations.FULLHOUSE2, FULLHOUSE2);
        mDiceComboValues.put(Combonations.FULLHOUSE3, FULLHOUSE3);
        mDiceComboValues.put(Combonations.FULLHOUSE4, FULLHOUSE4);
        mDiceComboValues.put(Combonations.FULLHOUSE5, FULLHOUSE5);
        mDiceComboValues.put(Combonations.FULLHOUSE6, FULLHOUSE6);
        mDiceComboValues.put(Combonations.FULLHOUSE7, FULLHOUSE7);
        mDiceComboValues.put(Combonations.FULLHOUSE8, FULLHOUSE8);
        mDiceComboValues.put(Combonations.FULLHOUSE9, FULLHOUSE9);
        mDiceComboValues.put(Combonations.FULLHOUSE10, FULLHOUSE10);
        mDiceComboValues.put(Combonations.FULLHOUSE11, FULLHOUSE11);
        mDiceComboValues.put(Combonations.FULLHOUSE12, FULLHOUSE12);
        mDiceComboValues.put(Combonations.FULLHOUSE13, FULLHOUSE13);
        mDiceComboValues.put(Combonations.FULLHOUSE14, FULLHOUSE14);
        mDiceComboValues.put(Combonations.FULLHOUSE15, FULLHOUSE15);
        mDiceComboValues.put(Combonations.FULLHOUSE16, FULLHOUSE16);
        mDiceComboValues.put(Combonations.FULLHOUSE17, FULLHOUSE17);
        mDiceComboValues.put(Combonations.FULLHOUSE18, FULLHOUSE18);
        mDiceComboValues.put(Combonations.FULLHOUSE19, FULLHOUSE19);
        mDiceComboValues.put(Combonations.FULLHOUSE20, FULLHOUSE20);
        mDiceComboValues.put(Combonations.FULLHOUSE21, FULLHOUSE21);
        mDiceComboValues.put(Combonations.FULLHOUSE22, FULLHOUSE22);
        mDiceComboValues.put(Combonations.FULLHOUSE23, FULLHOUSE23);
        mDiceComboValues.put(Combonations.FULLHOUSE24, FULLHOUSE24);
        mDiceComboValues.put(Combonations.FULLHOUSE25, FULLHOUSE25);
        mDiceComboValues.put(Combonations.FULLHOUSE26, FULLHOUSE26);
        mDiceComboValues.put(Combonations.FULLHOUSE27, FULLHOUSE27);
        mDiceComboValues.put(Combonations.FULLHOUSE28, FULLHOUSE28);
        mDiceComboValues.put(Combonations.FULLHOUSE29, FULLHOUSE29);
        mDiceComboValues.put(Combonations.FULLHOUSE30, FULLHOUSE30);
        mDiceComboValues.put(Combonations.SMALLSTRAIGHT1, SMALLSTRIGHT1);
        mDiceComboValues.put(Combonations.SMALLSTRAIGHT2, SMALLSTRAIGHT2);
        mDiceComboValues.put(Combonations.SMALLSTRAIGHT3, SMALLSTRAIGHT3);
        mDiceComboValues.put(Combonations.LARGESTRAIGHT1, LARGESTRAIGHT1);
        mDiceComboValues.put(Combonations.LARGESTRAIGHT2, LARGESTRAIGHT2);
        mDiceComboValues.put(Combonations.YATZEE1, YATZEE1);
        mDiceComboValues.put(Combonations.YATZEE2, YATZEE2);
        mDiceComboValues.put(Combonations.YATZEE3, YATZEE3);
        mDiceComboValues.put(Combonations.YATZEE4, YATZEE4);
        mDiceComboValues.put(Combonations.YATZEE5, YATZEE5);
        mDiceComboValues.put(Combonations.YATZEE6, YATZEE6);
        mDiceComboValues.put(Combonations.CHANCE, CHANCE);


    }

    public ArrayList<Combonations> compareCombo(ArrayList<Integer> list) {
        ArrayList<Combonations> results = new ArrayList<>();
        for (Map.Entry<Combonations, Integer[]> combo : mDiceCombosMap.entrySet()) {
            Combonations key = combo.getKey();
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

    public void arrayToString(ArrayList<Combonations> combos) {
        for (Combonations combo: combos){
            String words= mStringMap.get(combo);
            System.out.println(words);
        }
        return;
    }

    public boolean isSubset(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        Integer a1Size= a1.size();
// TODO: FIX THIS!!!
        for (Integer integer2:a2){
            for (Integer integer1: a1){
                if (integer1==integer2){
                    a1.remove(integer1);
                    if (a1Size==0){
                        return true;
                    }
                    break;
                }
            }
        }
return false;
    }


}