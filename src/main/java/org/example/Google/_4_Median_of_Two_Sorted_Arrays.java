package org.example.Google;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _4_Median_of_Two_Sorted_Arrays {

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//
//        if (n2 < n1) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int halfLength = (n1 + n2 + 1) / 2;
//        boolean isEvenLength = ((n1 + n2) % 2) == 0;
//        int num1LowIndex = 0;
//        int num1HighIndex = n1;
//
//        while (num1LowIndex <= num1HighIndex) {
//            int mid = (num1LowIndex + num1HighIndex) / 2;
//
//            int left1Value = (mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
//            int right1Value = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
//            int left2Value = (halfLength - (mid + 1)) >= 0 ? nums2[halfLength - (mid + 1)] : Integer.MIN_VALUE;
//            int right2Value = (halfLength - mid) < nums2.length ? nums2[halfLength - mid] : Integer.MAX_VALUE;
//
//            if (left1Value <= right2Value && left2Value <= right1Value) {
//                if (isEvenLength) {
//                    return (Math.max(left1Value, left2Value) + Math.min(right1Value, right2Value)) / 2.0;
//                } else {
//                    return (Math.max(left1Value, left2Value));
//                }
//            } else if (left1Value > right2Value) {
//                num1HighIndex = mid - 1;
//            } else {
//                num1LowIndex = mid + 1;
//            }
//        }
//
//        return -1;
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int totalLength = n1 + n2;

        int targetIndex;
        boolean isEvenLength = false;
        if (totalLength % 2 == 0) {
            targetIndex = totalLength / 2 - 1;
            isEvenLength = true;
        } else {
            targetIndex = totalLength / 2;
        }

        int nums1Index = 0;
        int nums2Index = 0;

        int overallIndex = 0;

        int firstNumber = 0;
        int secondNumber = 0;

        while (overallIndex != (targetIndex + 2)) {
            if (nums1Index < nums1.length && nums2Index < nums2.length) {
                if (nums1[nums1Index] <= nums2[nums2Index]) {
                    if (overallIndex == targetIndex) {
                        firstNumber = nums1[nums1Index];
                    } else if ((overallIndex - 1) == targetIndex) {
                        secondNumber = nums1[nums1Index];
                    }
                    nums1Index++;
                } else {
                    if (overallIndex == targetIndex) {
                        firstNumber = nums2[nums2Index];
                    } else if ((overallIndex - 1) == targetIndex) {
                        secondNumber = nums2[nums2Index];
                    }
                    nums2Index++;
                }
            } else if (nums1Index < nums1.length) {
                if (overallIndex == targetIndex) {
                    firstNumber = nums1[nums1Index];
                } else if ((overallIndex - 1) == targetIndex) {
                    secondNumber = nums1[nums1Index];
                }
                nums1Index++;
            } else if (nums2Index < nums2.length) {
                if (overallIndex == targetIndex) {
                    firstNumber = nums2[nums2Index];
                } else if ((overallIndex - 1) == targetIndex) {
                    secondNumber = nums2[nums2Index];
                }
                nums2Index++;
            } else {
                break;
            }
            overallIndex++;
        }

        if (isEvenLength) {
            return (firstNumber + secondNumber) / 2.0;
        } else {
            return firstNumber;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
