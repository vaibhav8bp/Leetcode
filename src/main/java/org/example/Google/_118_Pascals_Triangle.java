package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class _118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> finalAnswer = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        finalAnswer.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(((i - j + 1) * currentRow.get(j - 1)) / j);
                }
            }

            finalAnswer.add(currentRow);
        }

        return finalAnswer;
    }
}
