package org.example.Striver_SDE_Sheet.Day_1_Arrays._118_Pascal_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> currentRowList = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                if (j == 1 || (j == i)) {
                    currentRowList.add(1);
                } else {
                    currentRowList.add((currentRowList.get(j - 2) * ((i - 1) - (j - 1) + 1)) / (j - 1));
                }
            }
            pascalList.add(currentRowList);
        }
        return pascalList;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
}
