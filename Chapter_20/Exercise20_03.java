/*
Author: Charles Carter
Date: 12/3/2024

This program is a modification of Exercise08_37.java that gives a quiz of U.S. State Capitals.
It has been modified to display the questions in random order using ArrayList and Collections to shuffle the list.

Exercise 20-3 from Intro to Java by Daniel Liang
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise20_03 {
    public static void main(String[] args) {
        String[][] stateCapital = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        //Create an ArrayList to store the stateCapital array of State and State Capital pairs
        ArrayList<String[]> stateCapitalList = new ArrayList<String[]>();
        Collections.addAll(stateCapitalList, stateCapital);

        //Shuffle the list
        Collections.shuffle(stateCapitalList);

        Scanner input = new Scanner(System.in);

        int correctCount = 0;

        for (String[] pair : stateCapitalList) {
            //Prompt the user with a question
            System.out.print("What is the capital of " + pair[0] + "? ");
            String capital = input.nextLine().trim().toLowerCase();

            if (capital.equalsIgnoreCase(pair[1])) {
                System.out.println("Your answer is correct.");
                correctCount++;
            } else {
                System.out.println("The answer should be: " + pair[1]);
            }

        }

        System.out.println("The correct count is " + correctCount);
    }
}
