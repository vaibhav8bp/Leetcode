package org.example.Daily._2025.February._6;

import java.util.*;

// https://leetcode.com/problems/tuple-with-same-product/description/
public class _1726_Tuple_with_Same_Product {

    // No need of checking for duplicates , as in the question it is clearly mentioned as
    // nums in an array of distinct of elements.
    public int tupleSameProduct(int[] nums) {

        int answer = 0;

        Map<Integer, Integer> productToIndicesMapping = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                answer += (8 * productToIndicesMapping.getOrDefault(product, 0));
                productToIndicesMapping.put(product, productToIndicesMapping.getOrDefault(product, 0) + 1);
            }
        }

        return answer;
    }
}
