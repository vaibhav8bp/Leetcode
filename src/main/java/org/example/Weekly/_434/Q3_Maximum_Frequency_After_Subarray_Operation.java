package org.example.Weekly._434;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3_Maximum_Frequency_After_Subarray_Operation {

    // [10,2,3,4,5,5,4,3,2,2], k = 10
    // [0 ,8,7,6,5,5,6,7,8,8]
    public int maxFrequency(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = k - nums[i];
        }

        List<int[]> partitionsList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int right = i;
            Map<Integer, Integer> relativeDifferenceToFrequencyMapping = new HashMap<>();
            int maxCount = 0;
            int differenceOfMaxCount = 0;
            while (right < nums.length && nums[right] != 0) {
                relativeDifferenceToFrequencyMapping.put(nums[right],
                        relativeDifferenceToFrequencyMapping.getOrDefault(nums[right], 0) + 1);

                if (relativeDifferenceToFrequencyMapping.get(nums[right]) > maxCount) {
                    maxCount = relativeDifferenceToFrequencyMapping.get(nums[right]);
                    differenceOfMaxCount = nums[right];
                }
                right++;
            }
            partitionsList.add(new int[]{differenceOfMaxCount, maxCount});

            int sameCount = 0;

            while (right < nums.length && nums[right] == 0) {
                sameCount++;
                right++;
            }
            partitionsList.add(new int[]{0, sameCount});
        }

//        for()
        return 0;
    }
}
