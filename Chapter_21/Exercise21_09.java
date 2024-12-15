/*
Author: Charles Carter
Date: 12/15/2024

Description: This program tests the user's knowledge of State Capitals.

It's been rewritten from Exercise08_37 to use a Map to store the States and Capitals,
I kept the array from the original program and used a loop to store it into a LinkedHashMap.
 */


import java.util.*;

public class Exercise21_09 {
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

        //Adding the array to a LinkedHashMap to preserve the order
        Map<String, String> stateCapitalMap = new LinkedHashMap<>();
        for (String[] entry : stateCapital) {
            stateCapitalMap.put(entry[0], entry[1]);
        }

        Scanner input = new Scanner(System.in);

        int correctCount = 0;

        // Iterate through the map for the test
        for (Map.Entry<String, String> entry : stateCapitalMap.entrySet()) {
            //Prompt the user with a question
            System.out.print("What is the capital of " + entry.getKey() + "? ");
            String capital = input.nextLine().trim().toLowerCase();

            if (capital.equals(entry.getValue().toLowerCase())) {
                System.out.println("Your answer is correct");
                correctCount++;
            } else {
                System.out.println("The correct answer should be " + entry.getValue());
            }
        }

        System.out.println("The correct count is " + correctCount);
    }
}
