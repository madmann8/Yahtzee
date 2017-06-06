package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main  {


    public static void main(String[] args) {
//        ArrayList<Integer> list= new ArrayList<>();
//        list.add(3);
//
//        for (Integer integer: list){
//            System.out.println(integer);
//        }
//        ArrayList<CombinationType> combo;
//        Combination combonation= new Combination();
//        combo= combonation.compareCombo(list);
//        combonation.arrayToString(combo);


        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Dice> dice = new ArrayList<>();
        for (int i = 0; i<5;i++){
            dice.add(new Dice());
        }


        for (int i = 0; i<5;i++){
            list.add(dice.get(i).value);
        }

        Combination combo = new Combination();

        ArrayList<CombinationType> result = combo.compareCombo(list);

        for (Integer num : list){
            System.out.print(num);
        }
        System.out.println();

        combo.arrayToString(result);

        System.out.println("Which die would you like to hold?");
        Scanner scanner = new Scanner(System.in);
        Integer response = scanner.nextInt();
        dice.get(response).held = true;
//        switch (response){
//            case 1: {
//                dice.get(0).held = true
//            }
//            case 2: {
//                dice.get(0).held = true
//            }
//            case 3: {
//
//            }
//            case 4: {
//
//            }
//            case 5: {
//
//            }
//            default:{
//
//            }
        list.remove(dice.indexOf(dice.get(response)));
        result = combo.compareCombo(list);

        for (Integer num : list){
            System.out.print(num);
        }
        System.out.println();

        combo.arrayToString(result);

    }


}

