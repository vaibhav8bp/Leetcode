package org.example.Daily._2024.December._14;

// Most Optimal Solution - O(N^2)

public class _2762_Continuous_Subarrays {

    public long continuousSubarrays(int[] nums) {
        long answer = 0;

        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                min = Math.min(nums[endIndex], min);
                max = Math.max(nums[endIndex], max);

                if (Math.abs(max - min) <= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

// More Optimal Solution - O(N^2)

//class Solution {
//
//    public long continuousSubarrays(int[] nums) {
//        long answer = 0;
//
//        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
//                min = Math.min(nums[endIndex], min);
//                max = Math.max(nums[endIndex], max);
//
//                if (Math.abs(max - min) <= 2) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
//}

// Slightly Optimized - O(N^3)
//class Solution {
//
//    private boolean isCurrentSubarrayContinous(int[] nums, int startIndex, int endingIndex) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//
//        for (int currentIndex = startIndex; currentIndex <= endingIndex; currentIndex++) {
//min = Math.min(nums[endIndex], min);
//max = Math.max(nums[endIndex], max);
//        }
//
//        return (Math.abs(max - min) <= 2);
//    }
//
//    public long continuousSubarrays(int[] nums) {
//        int answer = 0;
//        Map<Integer, Boolean> mapping = new HashMap<>();
//
//        for (int currentLength = 1; currentLength <= nums.length; currentLength++) {
//            for (int startingIndex = 0; startingIndex + currentLength - 1 < nums.length; startingIndex++) {
//                if (mapping.containsKey(startingIndex) && !mapping.get(startingIndex)) {
//                    continue;
//                }
//                if (isCurrentSubarrayContinous(nums, startingIndex, startingIndex + currentLength - 1)) {
//                    answer++;
//                    mapping.put(startingIndex, true);
//                } else {
//                    mapping.put(startingIndex, false);
//                }
//            }
//        }
//        return answer;
//    }
//}

// Brute Force Solution - O(N^4)
//class Solution {
//
//    private boolean isCurrentSubarrayContinous(int[] nums, int startIndex, int endingIndex) {
//        for (int currentIndex = startIndex + 1; currentIndex <= endingIndex; currentIndex++) {
//            for (int comparingIndex = startIndex; comparingIndex < currentIndex; comparingIndex++) {
//                if (Math.abs(nums[currentIndex] - nums[comparingIndex]) > 2) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    public long continuousSubarrays(int[] nums) {
//        int answer = 0;
//        for (int currentLength = 1; currentLength <= nums.length; currentLength++) {
//            for (int startingIndex = 0; startingIndex + currentLength - 1 < nums.length; startingIndex++) {
//                if (isCurrentSubarrayContinous(nums, startingIndex, startingIndex + currentLength - 1)) {
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
//}

