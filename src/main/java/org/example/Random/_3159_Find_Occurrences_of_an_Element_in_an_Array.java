package org.example.Random;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/
public class _3159_Find_Occurrences_of_an_Element_in_an_Array {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        List<Integer> occurrencesOfXInNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                occurrencesOfXInNums.add(i);
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > occurrencesOfXInNums.size()) {
                answer[i] = -1;
            } else {
                answer[i] = occurrencesOfXInNums.get(queries[i] - 1);
            }
        }

        return answer;
    }
}
