package com.hansonslogic.codility.practice;

import java.util.Arrays;

/**
 * You are given a string consisting of lowercase letters of the English alphabet. You must split this string into
 * a minimal number of substrings in such a way that no letter occurs more than once in each substring.
 *
 * For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and
 * ('ab', 'ac', 'dec').
 *
 * Write a function:
 * class Solution { public int solution(String S); }
 * that, given a string S of length N, returns the minimum number of substrings into which the string has to be split.
 *
 * Examples:
 * 	1. Given 'world', your function should return 1.
 * 	There is no need to split the string into substrings as all letters occur just once.
 *
 * 	2. Given 'dddd', your function should return 4.
 * 	The result can be achieved by splitting the string into four substrings ('d', 'd', 'd', 'd').
 *
 * 	3. Given 'cycle', your function should return 2.
 * 	The result can be achieved by splitting the string into two substrings ('cy', 'cle') or ('c', 'ycle').
 *
 * 	4. Given 'abba', your function should return 2.
 * 	The result can be achieved by splitting the string into two substrings ('ab', 'ba').
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..1,000,000]
 * string S is made only of lowercase letters (a−z).
 */
public class EnglishAlphabetLowerCaseSplit {

    // if we use the value of count instead of just 0 or 1, we don't need to reallocate the array each time
    // this idea was suggested by Jody Mueller.  Original code based off demo by Brad Lory
    public int solution(String S) {
        int[] alphabet = new int[26];
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (alphabet[index] == count) {
                count++;
                // alphabet = new int[26];
            }
            alphabet[index] = count; // this always happens and IDE suggested we refactor it out of the if-else
        }
        System.out.println(Arrays.toString(alphabet));

        return count;
    }

    public static void main(String[] args) {
        EnglishAlphabetLowerCaseSplit solution = new EnglishAlphabetLowerCaseSplit();
        System.out.println(solution.solution("world")); // 1
        System.out.println(solution.solution("dddd")); // 4
        System.out.println(solution.solution("cycle")); // 2
        System.out.println(solution.solution("abba")); // 2
        System.out.println(solution.solution("abcdefgabcdefghijklmnophijklmnopqrsqrsabc")); // 4?
        System.out.println(solution.solution("abbaabbaabbaabbaabbaabbaabbaaaababbbabbaaabb")); // 2
    }
}
