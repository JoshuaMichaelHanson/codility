package com.hansonslogic.udemy;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0,
 * as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets1 {

    /**
     * @param S - string containing "(", "{", "[", "]", "}" and/or ")"
     * @return 1 if properly nested otherwise 0
     *
     * Initial solution: Use a stack to push left brackets and pop when right bracket.  If they match keep going
     * If they do not match return 0;
     * We can use a CHAR stack to process the string
     *
     * Real Solution: I forgot to check if the stack was empty at the end of processing all the characters in the string
     * Got me again with a score of 62% before making this adjustment
     *
     */
    public static int solution(String S) {
        // if we create a stack in java with no size automatically set to 10
        // double each time needs more but does not automatically shrink if we remove elements
        // arrays are synchronized by default if we don't need synchronization should use a
        // ArrayDeque (ArrayDeck) instead
        // An ArrayDeque implementation can be used as a Stack (Last-In-First-Out)
        // or a Queue(First-In-First-Out).

        // for this example I am using a Stack since we are in the stack and queue section of Codility
        Stack<Character> charStack = new Stack<>();

        // use an iterator to keep space at O(1)
        CharacterIterator it = new StringCharacterIterator(S);
        char currentCharacter = it.current();
        char comparisonCharacter;

        while (currentCharacter != CharacterIterator.DONE) {
            if (currentCharacter == '{' || currentCharacter == '[' || currentCharacter == '(') {
                // need to push
                charStack.push(currentCharacter);
            } else {
                // need to pop and compare
                // need to make sure there is something to pop
                if (!charStack.empty()) {
                    // proceed
                    comparisonCharacter = charStack.pop();
                    if (comparisonCharacter == '{' && currentCharacter != '}') {
                        return 0;
                    } else if (comparisonCharacter == '[' && currentCharacter != ']') {
                        return 0;
                    } else if (comparisonCharacter == '(' && currentCharacter != ')') {
                        return 0;
                    }
                } else {
                    // we found a miss match
                    return 0;
                }
            }
            it.next();
            currentCharacter = it.current();
        } // end while

        // need to check if the stack is empty at this point
        // forgot to do this the first time I did it!!
        // this one thing got it to 100%
        if (!charStack.empty()) {
            return 0;
        }
        return 1; // properly nested
        // return charStack.empty() ? 1 : 0;
    }
}
