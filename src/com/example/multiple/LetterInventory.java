package com.example.multiple;
// Programmer: Pepper Berry
// Class: CS &145
// Date: 5/10/23
//lab 3 letter inventory
// Purpose: allows you to add and subtrtact letter things
import java.util.*;


public class LetterInventory {
    static int[][] dataLetterLength = new int[26][4];//s
    static LetterInventory inventory;
    static LetterInventory other;

    public LetterInventory (String data, int t){
        //Constructs an inventory (a count) of the alphabetic letters in the given string,
        // ignoring the case of letters and ignoring any non-alphabetic characters.


        for (int i = 0; i < data.length(); i++) {
            //finds if it's a letter or a special character, deletes special characters
            char singularCharacter = data.charAt(i);

            if (singularCharacter < 122){
                if (singularCharacter > 65) {
                    if (singularCharacter < 90) {//this is a uppercase letter
                        //add 32
                        singularCharacter += 32;//this

                        int oldTotal = dataLetterLength[(singularCharacter - 97)][t];
                        dataLetterLength[(singularCharacter - 97)][t] = (oldTotal + 1);
                    } else if (singularCharacter > 96) {//this is a lowercase letter


                        int oldTotal = dataLetterLength[(singularCharacter - 97)][t];
                        dataLetterLength[(singularCharacter - 97)][t] = (oldTotal + 1);

                    }
                }

            }


        }


    }

    public static String toString(LetterInventory inventory, int t){
        String ofInventory = "";

        for (int i = 0; i < 26; i++){
            char newish = (char) (i+97);

            for (int l = 0; l < dataLetterLength[i][t]; l++){
                ofInventory += newish;
            }
        }
        return ofInventory;

    }

    public LetterInventory add (){
        String addInventory = toString(LetterInventory.inventory,1);
        String addOTher = toString(LetterInventory.inventory,2);
        LetterInventory add = new LetterInventory((addInventory+addOTher),3);



        return add;
    }

    public static int[][] subtract(){
        for (int i = 0; i < 26; i++){
            int subtracted = ((dataLetterLength[i][1])-(dataLetterLength[i][2]));
            if (subtracted < 0){
                subtracted = 0;
            }
            dataLetterLength[i][0] = subtracted;

        }
        return dataLetterLength;

    }


}
class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //asks for input
        System.out.println("type 1st text");
        String data = input.nextLine();
        LetterInventory.inventory = new LetterInventory(data,1);
        System.out.println("type 2nd text");
        data = input.nextLine();
        LetterInventory.other = new LetterInventory(data,2);
        System.out.println("the letters of the 1st text:");
        System.out.println(LetterInventory.toString(LetterInventory.inventory,1));
        System.out.println("the letters of the 2nd text:");
        System.out.println(LetterInventory.toString(LetterInventory.other, 2));
        System.out.println("the letters added together:");
        System.out.println(LetterInventory.toString(LetterInventory.inventory.add(), 3));
        System.out.println("the 2nd text letters subtracted from the first set letters:");
        LetterInventory.subtract();
        System.out.println(LetterInventory.toString(LetterInventory.inventory,0));



    }

}

