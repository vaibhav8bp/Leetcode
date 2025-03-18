package org.example.Daily._2025.March._18;

// https://leetcode.com/problems/longest-nice-subarray/description/
public class _2401_Longest_Nice_Subarray {

    //         1 1 -> 3
    //     1 0 0 0 -> 8
    //     1 0 1 1 -> 3^8
    // 1 1 0 0 0 0 -> 48

    public static int longestNiceSubarray(int[] nums) {

        int maxLength = 1;
        int xor = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            if ((xor & nums[right]) == 0) {
                xor ^= nums[right];
            } else {
                xor ^= nums[left];
                left++;
                right--;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

//    private static boolean isCurrentSubarrayNice(int[] nums, int start, int end) {
//        for (int i = start; i <= end - 1; i++) {
//            if ((nums[i] & nums[end]) != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public static int longestNiceSubarray(int[] nums) {
//
//        int maxLength = 1;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (isCurrentSubarrayNice(nums, i, j)) {
//                    maxLength = Math.max(maxLength, j - i + 1);
//                } else {
//                    break;
//                }
//            }
//        }
//
//        return maxLength;
//    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }
}