package model;

import java.util.ArrayList;
import java.util.Map;

public class Main  {


    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(3);

        for (Integer integer: list){
            System.out.println(integer);
        }
        ArrayList<Combonations> combo;
        Combonation combonation= new Combonation();
        combo= combonation.compareCombo(list);
        combonation.arrayToString(combo);
    }

}
