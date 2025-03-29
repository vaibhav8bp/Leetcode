package org.example.Random;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/description/
public class _3434_Maximum_Frequency_After_Subarray_Operation {
    public int maxFrequency(int[] nums, int k) {
        Set<Integer> uniqueElements = new HashSet<>();

        int kCount = 0;

        for (int currentElement : nums) {
            if (currentElement == k) {
                kCount++;
            } else {
                uniqueElements.add(currentElement);
            }
        }

        int answer = kCount;

        for (int currentUniqueElement : uniqueElements) {

            int maxCount = 0;
            int currentCount = 0;

            for (int currentElement : nums) {
                if (currentElement == currentUniqueElement) {
                    currentCount++;
                } else if (currentElement == k) {
                    currentCount--;
                }
                if (currentCount == -1) {
                    currentCount = 0;
                }
                maxCount = Math.max(maxCount, currentCount);
            }

            answer = Math.max(answer, maxCount + kCount);
        }

        return answer;
    }
}
