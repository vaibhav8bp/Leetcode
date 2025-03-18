package org.example.Striver_SDE_Sheet.Day_2_Arrays_Part_II._56_Merge_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> lists = Arrays
                .stream(intervals)
                .map(currentRow -> Arrays.stream(currentRow).boxed().collect(Collectors.toList()))
                .sorted(Comparator.comparingInt(List::getFirst)).collect(Collectors.toList());

        for (int i = 0; i < lists.size() - 1; i++) {
            if (lists.get(i).get(1) >= lists.get(i + 1).get(0)) {
                lists.get(i).set(1, Math.max(lists.get(i).get(1), lists.get(i + 1).get(1)));
                lists.remove(i + 1);
                i--;
            }
        }

        return lists.stream()
                .map(currentRow ->
                        currentRow.stream()
                                .mapToInt(Integer::intValue)
                                .toArray())
                .toArray(int[][]::new);
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {4, 5}};
        int[][] resultArr = new Solution().merge(arr);
        System.out.println(Arrays.deepToString(resultArr));
    }
}
