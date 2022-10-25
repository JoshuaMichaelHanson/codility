package com.hansonslogic.codility.practice;

import java.util.Arrays;

/**
 * There are N guests (numbered from 0 to N-1) in a sanatorium
 * waiting to be assigned a room.
 *
 * In each room, any number of guests can be accommodated.
 * However, not all guests like to have a lot of roommates.
 *
 * You are given an array A of N integers: the K-th guest wants
 * to be in a room that contains at most A[K] guests, including themselves.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * Given that, given the array A, returns the minimum number of rooms needed to
 * accommodate all guests.
 *
 * Examples:
 *
 * 1. Given A = [1, 1, 1, 1, 1], your function should return 5.
 * Each guest should be accommodated in their own separate room.
 *
 * 2. Given A = [2, 1, 4], your function should return 2.
 * The second guest should be accommodated in one room and the
 * other two guests in another room.
 *
 * 3. Given A = [2, 7, 2, 9, 8], your function should return 2.
 * The first and the third guests should be accommodated in one
 * room and the other three guests in another room.
 *
 * 4. Given A = [7, 3, 1, 1, 4, 5, 4, 9], your function should return 4.
 * The guests can be accommodated as follows: the first two guests in one room,
 * the third and the fourth guests in two single rooms, and the other guests
 * in another room.
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..100,000].
 *
 */
public class RoomsInSanatorium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // sort the array
        Arrays.sort(A);
        // loop through the array
        int rooms = 0;
        int numberInRoom = 0;
        int roomSize = A[0];
        for (int j : A) {
            if(numberInRoom < roomSize) {
                numberInRoom++;
            } else {
                rooms++;
                roomSize = j;
                numberInRoom = 1;
            }
        }

        return rooms + 1; // add one for the last room
    }

    public static void main(String[] args) {
        RoomsInSanatorium roomsInSanatorium = new RoomsInSanatorium();
        int[] A = {1, 1, 1, 1, 1}; // 5
        System.out.println(roomsInSanatorium.solution(A));
        int[] B = {2, 1, 4}; // 2
        System.out.println(roomsInSanatorium.solution(B));
        int[] C = {2, 7, 2, 9, 8}; // 2
        System.out.println(roomsInSanatorium.solution(C));
        int[] D = {7, 3, 1, 1, 4, 5, 4, 9}; // 4
        System.out.println(roomsInSanatorium.solution(D));

    }
}
