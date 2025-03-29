package org.example.Daily._2025.March._27;

import java.util.List;

// https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
public class _2780_Minimum_Index_of_a_Valid_Split {
    public int minimumIndex(List<Integer> nums) {
        int maxNumber = nums.getFirst();
        int maxNumberFrequency = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (maxNumber == nums.get(i)) {
                maxNumberFrequency++;
            } else {
                maxNumberFrequency--;
                if (maxNumberFrequency == 0) {
                    maxNumber = nums.get(i);
                    maxNumberFrequency = 1;
                }
            }
        }

        maxNumberFrequency = 0;

        for (Integer currentElement : nums) {
            if (currentElement == maxNumber) {
                maxNumberFrequency++;
            }
        }

        int frequencyOfMaxNumberInLeftPartition = 0;

        for (int partitionIndex = 0; partitionIndex < nums.size() - 1; partitionIndex++) {

            if (nums.get(partitionIndex) == maxNumber) {
                frequencyOfMaxNumberInLeftPartition++;
            }

            int leftPartitionSize = partitionIndex + 1;
            int minimumFrequencyRequiredInLeft = (leftPartitionSize / 2) + 1;
            int rightPartitionSize = nums.size() - leftPartitionSize;
            int minimumFrequencyRequiredInRight = (rightPartitionSize / 2) + 1;
            int frequencyOfMaxNumberInRightPartition = maxNumberFrequency - frequencyOfMaxNumberInLeftPartition;

            if (frequencyOfMaxNumberInLeftPartition >= minimumFrequencyRequiredInLeft && frequencyOfMaxNumberInRightPartition >= minimumFrequencyRequiredInRight) {
                return partitionIndex;
            }
        }

        return -1;
    }
}