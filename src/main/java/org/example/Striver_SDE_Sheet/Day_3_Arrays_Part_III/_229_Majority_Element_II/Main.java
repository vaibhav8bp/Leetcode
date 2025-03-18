package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._229_Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int countOfElementA = 0;
        int countOfElementB = 0;
        int elementA = Integer.MIN_VALUE;
        int elementB = Integer.MIN_VALUE;

        for (int currentElement : nums) {
            if (countOfElementA == 0 && currentElement != elementB) {
                elementA = currentElement;
                countOfElementA = 1;
            } else if (countOfElementB == 0 && currentElement != elementA) {
                elementB = currentElement;
                countOfElementB = 1;
            } else if (currentElement == elementA) {
                // Here we are not decrementing countOfElementB because
                // there are 2 candidates straightaway unlike n/2 solution
                countOfElementA++;
            } else if (currentElement == elementB) {
                // Here we are not decrementing countOfElementA because
                // there are 2 candidates straightaway unlike n/2 solution
                countOfElementB++;
            } else {
                countOfElementA--;
                countOfElementB--;
            }
        }

        int minFrequencyRequired = (int) (Math.floor(nums.length / 3.0) + 1);
        int actualCountOfElementA = 0;
        int actualCountOfElementB = 0;

        for (int element : nums) {
            if (element == elementA) {
                actualCountOfElementA++;
            } else if (element == elementB) {
                actualCountOfElementB++;
            }
        }

        List<Integer> finalList = new ArrayList<>();

        if (actualCountOfElementA >= minFrequencyRequired) {
            finalList.add(elementA);
        }
        if (actualCountOfElementB >= minFrequencyRequired) {
            finalList.add(elementB);
        }

        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().majorityElement(nums));
    }
}
