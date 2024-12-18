/*
Author: Charles Carter
Date: 12/17/2024

Description:  "This program finds the longest substring with characters in strictly
increasing order from a given input string.

The time complexity is O(n)
 */

import java.util.Scanner;

public class Exercise22_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with no spaces: ");
        String input = scanner.nextLine();
        String result = findMaxConsecutiveSubstring(input);

        System.out.println("Maximum consecutive substring: " + result);
    }

    //Method for finding the maximum consecutive Substring within the string given
    public static String findMaxConsecutiveSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";  //Return empty string for invalid input
        }
        int maxStart = 0, maxLength = 0; //Indices for maximum substring
        int currentStart = 0;  //Start index for current substring

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) <= input.charAt(i - 1)) {
                //Check if current substring is currently the longest
                int currentLength = i - currentStart;
                if (currentLength > maxLength) {
                    maxStart = currentStart;
                    maxLength = currentLength;
                }
                //Reset current start index
                currentStart = i;
            }
        }


        //Final check for last substring
        int currentLength = input.length() - currentStart;
        if (currentLength > maxLength) {
            maxStart = currentStart;
            maxLength = currentLength;
        }


        //Return the max consecutive substring using the starting and ending indices
        return input.substring(maxStart, maxStart + maxLength);
    }
}
