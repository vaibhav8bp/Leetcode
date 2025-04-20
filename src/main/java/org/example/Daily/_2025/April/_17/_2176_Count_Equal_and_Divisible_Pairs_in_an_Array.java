package org.example.Daily._2025.April._17;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/
public class _2176_Count_Equal_and_Divisible_Pairs_in_an_Array {

    public int countPairs(int[] nums, int k) {

        Map<Integer, Map<Integer, Integer>> mapping = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int iModuloK = i % k;

            if (mapping.containsKey(nums[i])) {
                for (Map.Entry<Integer, Integer> currentEntry : mapping.get(nums[i]).entrySet()) {
                    int jModuloK = currentEntry.getKey() % k;
                    int jModuloKCount = currentEntry.getValue();
                    if ((iModuloK * jModuloK) % k == 0) {
                        answer += jModuloKCount;
                    }
                }
            } else {
                mapping.put(nums[i], new HashMap<>());
            }

            mapping.get(nums[i]).put(iModuloK, mapping.get(nums[i]).getOrDefault(iModuloK, 0) + 1);
        }

        return answer;
    }

//    public int countPairs(int[] nums, int k) {
//
//        Map<Integer, List<Integer>> numberToIndicesMapping = new HashMap<>();
//
//        int answer = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!numberToIndicesMapping.containsKey(nums[i])) {
//                numberToIndicesMapping.put(nums[i], new ArrayList<>());
//            }
//            numberToIndicesMapping.get(nums[i]).add(i);
//
//            List<Integer> previousIndices = numberToIndicesMapping.get(nums[i]);
//
//            for (int j = 0; j < previousIndices.size() - 1; j++) {
//                if ((i * previousIndices.get(j)) % k == 0) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
}
