package org.example.Random;

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/
public class _2874_Maximum_Value_of_an_Ordered_Triplet_II {
    public long maximumTripletValue(int[] nums) {

        long answer = 0;
        long maximumNumber = 0;
        long maximumDifference = 0;

        for (int currentNumber : nums) {
            answer = Math.max(answer, maximumDifference * currentNumber);
            // after let's say index =i is processed as k.
            // in next iteration this index can become j and cannot become i.
            // therefore update maximumDifference first in which we are updating j
            // keep i same and then updating maximumNumber which can be used from
            // next to next index.
            maximumDifference = Math.max(maximumDifference, maximumNumber - currentNumber);
            maximumNumber = Math.max(maximumNumber, currentNumber);
        }

        return answer;
    }
}