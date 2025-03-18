package org.example.Google;

// https://leetcode.com/problems/max-consecutive-ones-ii/description/
public class _487_Max_Consecutive_Ones_II {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;

        int left = 0;
        int right = 0;
        int zerosCountInCurrentWindow = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zerosCountInCurrentWindow++;
                if (zerosCountInCurrentWindow == 2) {
                    while (nums[left] != 0) {
                        left++;
                    }
                    left++;
                    zerosCountInCurrentWindow = 1;
                }
            }
            right++;
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left);
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
    }

//    public int findMaxConsecutiveOnes(int[] nums) {
//        int maxConsecutiveOnes = 0;
//
//        for (int i = 0; i < nums.length; ) {
//            if (nums[i] == 1) {
//                int j = i + 1;
//                while (j < nums.length && nums[j] == 1) {
//                    j++;
//                }
//                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, j - i);
//                i = j;
//            } else {
//                i++;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int length = 1;
//                for (int j = i - 1; j >= 0 && nums[j] == 1; j--, length++) {
//
//                }
//                for (int j = i + 1; j < nums.length && nums[j] == 1; j++, length++) {
//
//                }
//                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, length);
//            }
//        }
//
//        return maxConsecutiveOnes;
//    }
}
