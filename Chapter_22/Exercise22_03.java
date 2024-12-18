/*
Author: Charles Carter
Date: 12/17/2024

Description:  This program allows the user to enter a string, and then a second string,
and checks if the pattern of the second string is found in the first string.

It uses O(n) for time complexity
 */


import java.util.Scanner;

public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string s1: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter a string s2: ");
        String s2 = scanner.nextLine();

        int index = findSubstring(s1, s2);

        if (index != -1) {
            System.out.println("Matched at index " + index);
        } else {
            System.out.println("No match found.");
        }

        scanner.close();
    }

    // Method to find substring without using indexOf
    public static int findSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (m > n) {
            return -1; // s2 cannot be a substring of s1 if it is longer
        }

        // Sliding window to check for substring match
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // Found a match at index i
            }
        }
        return -1; // No match found
    }
}
