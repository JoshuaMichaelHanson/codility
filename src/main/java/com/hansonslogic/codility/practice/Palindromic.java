package com.hansonslogic.codility.practice;

import java.util.HashMap;

/**
 * You are given a string S, which consists entirely of decimal digits (0-9). Using digits from S,
 * Create a palindromic number with the largest possible decimal value.  You should use at least
 * one digit and you can reorder the digits.  A palindromic number remains the same when its digits
 * are reversed.  For instance 7, 44, 83238.  8832388 Any palindromic number you create should not, hovever,
 * have any leading zeros, such as 0990 or 010
 *
 * For example, decimal palindromic numbers that can be created from 8199 are 1, 8, 9, 99, 919, and 989.
 * Among them 989 has the largest value.
 *
 * Keep an unmatched = null;
 * Write a function
 * class Solution {public String solution(String S); }
 * That given a String S of N digits, returns the string representing the palindromic number with the largest value.
 *
 * Examples
 * Given 39878 return 898
 * Given 00900 return 9
 * Given 00000 return 0
 * Given 54321 return 5
 *
 * N is an integer within the range [1...100,000]
 *
 * string S is made only of digits (0-9)
 *
 * https://www.geeksforgeeks.org/rearrange-characters-form-palindrome-possible/
 *
 * Pseudocode
 * Put the string into a char array
 * Count each char (0-9)
 * Start with 9 and look for even / odd numbers
 * If even put that number of char into the middle
 * If odd put that number minus 1 in the middle
 * The leftover goes into the highest left over
 * Continue until zero
 * Put the highest left-over in the middle
 * Return
 * If all zeros return only 1 zero (convert to int if zero return zero right away)
 *
 */
public class Palindromic {

    public String solution(String S) {
        // convert to int and check if its zero
        int s = Integer.parseInt(S);
        if (s == 0) {
            return "0";
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        StringBuilder returnString = new StringBuilder("");
        int highestLeftOver = -1;
        // convert S to a char array
        char[] charArray = S.toCharArray();
        // put each char into charCount
        for (char c : charArray) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        // start with 9 and look for even / odd numbers.  If even put that number of char into the middle
        // If odd and not zero put that number minus 1 in the middle
        for(int i = 9; i >= 0; i--) {
            String left = "";
            String right = "";
            StringBuilder middle = new StringBuilder("");
            char fillChar = (char) (i + '0'); // convert int to char
            if (returnString.length() > 0) {
                left = returnString.substring(0, returnString.length() / 2);
                right = returnString.substring(returnString.length() / 2);
            }
            if (charCount.containsKey(fillChar)) {
                int count = charCount.get(fillChar);
                if (count % 2 == 0) {
                    for(int j = 0; j < count; j++) {
                        middle.append(fillChar);
                    }
                } else {
                    if (count > 1) {
                        for(int j = 0; j < count - 1; j++) {
                            middle.append(fillChar);
                        }
                    }
                    if(i > highestLeftOver) {
                        highestLeftOver = i;
                    }
                } // end if even / odd
                // put the left, middle, right together
                returnString = new StringBuilder(left + middle + right);
            } // end if charCount contains key
        }

        // remove leading zeros
        while(returnString.length() > 0 && returnString.charAt(0) == '0') {
            returnString.deleteCharAt(0);
        }
        // remove trailing zeros
        while(returnString.length() > 0 && returnString.charAt(returnString.length() - 1) == '0') {
            returnString.deleteCharAt(returnString.length() - 1);
        }

        // put the highest left-over in the middle
        if (highestLeftOver > -1) {
            char fillChar = (char) (highestLeftOver + '0'); // convert int to char
            if (returnString.length() > 0) {
                returnString.insert(returnString.length() / 2, fillChar);
            } else {
                returnString.append(fillChar);
            }
        }

        return returnString.toString();
    }

    // add main function to run this program
    public static void main(String[] args) {
        Palindromic palindromic = new Palindromic();
        System.out.println(palindromic.solution("39878"));
        System.out.println(palindromic.solution("00900"));
        System.out.println(palindromic.solution("00000"));
        System.out.println(palindromic.solution("54321"));
        // 111,111,111,111
        System.out.println(palindromic.solution("1231234564"));
        System.out.println(palindromic.solution("0102030102"));
    }
}
