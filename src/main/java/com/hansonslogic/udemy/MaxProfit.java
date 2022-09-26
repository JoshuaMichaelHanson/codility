package com.hansonslogic.udemy;

/** ******************** HINT ***************************************************
 *
 * This type of problem is known as the Maximum Slice Problem
 * We solve at least 2 of these (codility practice problems)
 * with this 'hint' -> Keep Reading....
 * The array MUST contain negative values, if they are all positives we need
 * to use the DELTA of each pair of values in the array.
 *
 * Brute Force will work but is not efficient.
 * O(N^2) or O(N^3) depending on the loops chosen
 * Start at index 0 and add all possible combinations = BAD
 *
 * Can also use a divide and conquer solutions
 * Keep breaking the array in half until get to one element
 * Then MERGE them back together MAX(8, 7, 8, x)
 * Divide and Conquer ---> O(N log N)
 *
 * There is a way to make the solution O(N)
 * We need ot use the 'hint'
 * Kadane's Algorith
 *
 * This is an example of 'Dynamic Programming'
 * Technique for solving a problem by recursively breaking it down into simpler
 * subproblems and using the fact that the optimal solution to the overall problem
 * depends upon the optimal solution to it's individual subproblems
 * Developed by Richard Bellman in the 1950's
 * DP algorithm solves each subproblem just once and then remembers its answer,
 * thereby avoiding re-computation of the answer for similar subproblems every time
 *<a href="https://www.scaler.com/topics/data-structures/dynamic-programming/">...</a>
 *
 * Also see using a MEMO in the Big O examples found in this code repository
 *
 * We need to identify 'buying opportunities' and report back the BEST buying opp
 * Buy LOW sell HIGH = MAX Profit
 * ()
 * Since the array only holds positive number we need to find the DELTA
 *
 * Example with negative numbers already in the array
 * [5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3]
 * maxGlobal - stores the sum of the MAX sub array
 * maxLocal - used to process each sub array
 *
 * Each start with the value of index 0
 * maxGlobal = 5;
 * maxLocal = 5;
 *
 * Next we must choose either the next value or the next value plus the maxLocal
 * -4 OR (-4 + 5) = 1
 * We choose which ever is BIGGER so 1 is bigger than -4
 * The sub array now contains [5, -4]
 * localMax = 1;
 *
 * 8 OR (8 + 1) = 9
 * 9 is bigger so add 8 to the subArray [5, -4, 8]
 * localMax = 9;
 *
 * localMax is now bigger than maxGlobal so
 * maxGlobal = 9 -> [5, -4, 8]
 *
 * -10 OR (-10 + 9) = -1
 * localMax = -1; -> [5, -4, 8, -10] remember maxGlobal still contains [5, -4, 8]
 *
 * -2 OR (-2 + -1) = -3
 * This is our first time we will choose the LEFT side
 * We need to re-set the localMax to the value we are processing is lager than the sum
 *
 * localMax = -2; [-2] -> maxGlobal stays the same [5, -4, 8] = 9
 *
 * 4 OR (4 + -2) = 2
 * Left side again so re-set localMax
 *
 * maxLocal = 4; [4]
 *
 * -3 OR (-3 + 4) = 1
 * 1 is bigger so add it to the maxLocal
 * maxLocal = 1; [4, -3]
 *
 * 2 OR (2 + 1) = 3
 * 3 is bigger so add it to the maxLocal
 * maxLocal = 3; [4, -3, 2]
 *
 * 7 OR (7 + 3) = 10
 * 10 is bigge so add it to maxLocal
 * maxLocal = 10; [4, -3, 2, 7]
 *
 * Also notice 10 is larger than 9 so update maxGlobal
 * maxGlobal = maxLocal;
 *
 * -8 OR (-8 + 10) = 2
 * 2 is bigger so add it maxLocal
 * maxLocal = 2; [4, -3, 2, 7, -8]
 *
 * 3 or (3 + 2) = 5
 * 5 is larger so add it to our maxLocal
 * maxLocal = 5; [4, -3, 2, 7, -8, 3]
 *
 * -5 OR (-5 + 5) = 0
 * 0 is bigger than -5 so add -5 to maxLocal
 * maxLocal = 0; [4, -3, 2, 7, -8, 3, -5]
 *
 * 3 OR (3 + 0) = 3
 * They are equal so we reset the maxLocal
 * maxLocal = 3; [3]
 *
 * We are done processing so return maxGlobal = 10;
 *
 * So to apply to Max Profit
 * [114, 132, 119, 91, 84, 29, 61, 76, 38, 21, 9, 63, 45, 68, 81, ...]
 *
 * We start at position 1 and subtract it from position 0 all the way to the end of the array
 * [18, -13, -28, -7, -55, 32, 15, -38, -17, -12, 54, -18, 23, 13, 43, -6, -40, ....]
 *
 * Result = 115;
 *
 *
 *
 * ******************************** Problem *****************************************
 * Max Profit
 * An array A consisting of N integers is given. It contains daily prices of a stock share
 * for a period of N consecutive days. If a single share was bought on day P and sold on
 * day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P],
 * provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 *
 * For example, consider the following array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because
 * A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5,
 * a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible
 * profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
 *
 * Write a function,
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers containing daily prices of a stock share
 * for a period of N consecutive days, returns the maximum possible profit from one
 * transaction during this period. The function should return 0 if it was impossible to
 * gain any profit.
 *
 * For example, given array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * the function should return 356, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 */
public class MaxProfit {

    /**
     * @param A - the array of stock values per day
     * @return - max profit if we buy low and sell high
     *
     * This solution is pretty slick.  Need to add a few more solutions
     * That show brute force and
     * maybe the divide and conquer
     */
    public static int solution(int[] A) {
        int maxLocal = 0;
        int maxGlobal = 0;

        // start at 1 because we are calculating the Delta
        for(int i = 1; i < A.length; i++) {
            int delta = A[i] - A[i -1];
            maxLocal = Math.max(delta, maxLocal + delta);
            maxGlobal = Math.max(maxLocal, maxGlobal);
        }
        return maxGlobal;
    }

    /**
     * Brute Force is the easiest and most programmers will get this
     * If they don't know the 'hint' for this 'type' of problem
     * O(N^2)
     */
    public static int bruteForceSolution(int[] A) {
        int maxProfit = 0;  // profit can't be negative
        for (int i = 0; i < A.length; ++i) {
            for (int j = i; j < A.length; ++j) {
                maxProfit = Math.max(maxProfit, A[j] - A[i]);
            }
        }
        return maxProfit;
    }

    /**
     * O(N log N)
     * So way better than the brute force solution but man kinda janky
     * <a href="https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)">...</a>
     */
    public static int divideAndConquer(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }
        BuySell result = maxProfit(A, 0, A.length - 1);
        return A[result.sellTime] - A[result.buyTime];
    }

    private static BuySell maxProfit(int[] prices, int lo, int hi) {
        if (lo >= hi) { // base case: only one time
            return new BuySell(lo, lo, lo, lo);
        }
        int mid = lo + (hi - lo) / 2; // divide
        BuySell left = maxProfit(prices, lo, mid); //conquer
        BuySell right = maxProfit(prices, mid + 1, hi);
        return combine(prices, left, right);
    }

    private static BuySell combine(int[] prices, BuySell left, BuySell right) {
        // case 1: left
        int maxProfit = prices[left.sellTime] - prices[left.buyTime];
        int bestBuyTime = left.buyTime;
        int bestSellTime = left.sellTime;

        // case 2: right
        int case2Profit = prices[right.sellTime] - prices[right.buyTime];
        if (case2Profit > maxProfit) {
            maxProfit = case2Profit;
            bestBuyTime = right.buyTime;
            bestSellTime = right.sellTime;
        }

        // case 3: left.minTime, right.maxTime
        int case3Profit = prices[right.maxTime] - prices[left.minTime];
        if (case3Profit > maxProfit) {
            maxProfit = case3Profit;
            bestBuyTime = left.minTime;
            bestSellTime = right.maxTime;
        }

        // update min and max
        int newMinTime = (prices[left.minTime] < prices[right.minTime]) ? left.minTime : right.minTime;
        int newMaxTime = (prices[left.maxTime] > prices[right.maxTime]) ? left.maxTime : right.maxTime;

        return new BuySell(bestBuyTime, bestSellTime, newMinTime, newMaxTime);
    }

}

/**
 * Helper class to encapsulate variables used in the recursion
 * Leave them public to make the code faster :)
 */
class BuySell {
    int buyTime;
    int sellTime;
    int minTime;
    int maxTime;

    BuySell(int b, int s, int min, int max) {
        buyTime = b;
        sellTime = s;
        minTime = min;
        maxTime = max;
    }
}
