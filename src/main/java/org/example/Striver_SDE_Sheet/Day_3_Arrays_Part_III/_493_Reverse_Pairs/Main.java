package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._493_Reverse_Pairs;

class Solution {

    public void merge(int[] nums, int left, int mid, int right) {
        int start = left;
        int end = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;

        while (start <= mid && end <= right) {
            if (nums[start] <= nums[end]) {
                temp[tempIndex++] = nums[start++];
            } else {
                temp[tempIndex++] = nums[end++];
            }
        }

        while (start <= mid) {
            temp[tempIndex++] = nums[start++];
        }

        while (end <= right) {
            temp[tempIndex++] = nums[end++];
        }

        tempIndex = 0;
        for (int i = left; i <= right; i++, tempIndex++) {
            nums[i] = temp[tempIndex];
        }
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftSortReversePairs = mergeSort(nums, left, mid);
        int rightSortReversePairs = mergeSort(nums, mid + 1, right);
        int leftAndRightReversePairs = reversePairsCalculator(nums, left, mid, right);
        merge(nums, left, mid, right);
        return leftSortReversePairs + rightSortReversePairs + leftAndRightReversePairs;
    }

    public int reversePairsCalculator(int[] nums, int left, int mid, int right) {
        int start = left;
        int end = mid + 1;
        int totalCount = 0;


        while (start <= mid && end <= right) {
            // if nums[start] is less than 2*nums[end] then it will also be
            // smaller for index end+1 to right
            // So no reverse pair for nums[start]
            long rightSide = 2L * nums[end];
            long leftSide = nums[start];
            if (leftSide > rightSide) {
                // Calculate till what index arr[start]>2*arr[end] by incrementing end
                int count = 0;
                while (end <= right && leftSide > rightSide) {
                    end++;
                    if (end <= right) {
                        rightSide = 2L * nums[end];
                    }
                    count++;
                }
                int leftRemainingSize = mid - start + 1;
                totalCount += (leftRemainingSize * count);
            }
            start++;
        }

        return totalCount;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        System.out.println(new Solution().reversePairs(nums));
    }
}
