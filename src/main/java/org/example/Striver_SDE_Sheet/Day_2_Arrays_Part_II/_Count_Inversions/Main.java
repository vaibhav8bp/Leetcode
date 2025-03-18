package org.example.Striver_SDE_Sheet.Day_2_Arrays_Part_II._Count_Inversions;


class Solution {
    private static long getInversionsHelper(long[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        long inversionCount = 0;
        long[] temp = new long[end - start + 1];
        int tempIndex = 0;

        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                temp[tempIndex++] = arr[right];
                inversionCount += (mid - left + 1);
                right++;
            } else {
                temp[tempIndex++] = arr[left];
                left++;
            }
        }

        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }

        while (right <= end) {
            temp[tempIndex++] = arr[right++];
        }

        tempIndex = 0;
        for (int i = start; i <= end; i++, tempIndex++) {
            arr[i] = temp[tempIndex];
        }

        return inversionCount;
    }

    private static long getInversionCountHelper(long[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        long leftInversions = getInversionCountHelper(arr, start, mid);
        long rightInversions = getInversionCountHelper(arr, mid + 1, end);
        long finalMergeInversions = getInversionsHelper(arr, start, mid, end);
        return leftInversions + rightInversions + finalMergeInversions;
    }

    public static long getInversions(long[] arr, int n) {
        return getInversionCountHelper(arr, 0, n - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        long[] arr = new long[]{2, 5, 1, 3, 4};
        System.out.println(Solution.getInversions(arr, arr.length));
    }
}
