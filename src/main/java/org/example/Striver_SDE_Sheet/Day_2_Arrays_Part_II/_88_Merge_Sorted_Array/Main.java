package org.example.Striver_SDE_Sheet.Day_2_Arrays_Part_II._88_Merge_Sorted_Array;

import java.util.Arrays;

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int nums1LeftIndex = 0;
//         int nums2LeftIndex = 0;

//         while (nums1LeftIndex != nums1.length) {
//             // nums2 is finished
//             if (nums2LeftIndex == n) {
//                 break;
//             }
//             // nums1 element is at it's correct position
//             else if (nums1[nums1LeftIndex] <= nums2[nums2LeftIndex]) {
//                 nums1LeftIndex++;
//             } else {
//                 for (int i = nums1.length - 1; i > nums1LeftIndex; i--) {
//                     nums1[i] = nums1[i - 1];
//                 }
//                 nums1[nums1LeftIndex] = nums2[nums2LeftIndex];
//                 nums1LeftIndex++;
//                 nums2LeftIndex++;
//             }
//         }

//         if (nums2LeftIndex != n) {
//             // No. of elements left in nums 2 =
//             int numberOfElementsLeftInnums2 = n - nums2LeftIndex;
//             for (int i = (m + n - numberOfElementsLeftInnums2); i < (m + n); i++) {
//                 nums1[i] = nums2[nums2LeftIndex++];
//             }
//         }
//     }
// }

// Shell Sort
class Solution {
   private void swap(int[] nums1, int[] nums2, int nums1Index, int nums2index) {
       int temp = nums1[nums1Index];
       nums1[nums1Index] = nums2[nums2index];
       nums2[nums2index] = temp;
   }

   public void merge(int[] nums1, int m, int[] nums2, int n) {
       double result = (m + n) / 2.0;
       int gap = (int) Math.ceil(result);
       while (gap != 0) {
           int left = 0;
           int right = left + gap;
           while (right < (m + n)) {
               // Case 1: left in nums1 and right in nums2
               if (left < m && right >= m) {
                   if (nums1[left] > nums2[right - m]) {
                       swap(nums1, nums2, left, right - m);
                   }
               }
               // Case 2: both left and right in nums1
               else if (left < m && right < m) {
                   if (nums1[left] > nums1[right]) {
                       swap(nums1, nums1, left, right);
                   }
               }
               // Case 2: both right are in nums2
               else if (left >= m && right >= m) {
                   if (nums2[left - m] > nums2[right - m]) {
                       swap(nums2, nums2, left - m, right - m);
                   }
               }
               left++;
               right++;
           }
           if (gap == 1) {
               break;
           }
           gap = (int) Math.ceil(gap / 2.0);
       }

       for (int i = m, j = 0; i < m + n ; i++, j++) {
           nums1[i] = nums2[j];
       }
   }
}

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


}
