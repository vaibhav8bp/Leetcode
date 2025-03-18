package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._42_Trapping_Rainwater;


// SC -O(1), TC -O(N)
class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }

        int maxRainTrapped = 0;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    maxRainTrapped += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    maxRainTrapped += (rightMax - height[right]);
                }
                right--;
            }
        }

        return maxRainTrapped;
    }
}

// SC -O(N), TC -O(N)
// class Solution {
//    public int trap(int[] height) {

//        if (height == null || height.length == 0 || height.length == 1 || height.length == 2) {
//            return 0;
//        }

//        int maxRainTrapped = 0;

//        int maxFromLeftTillNow = Integer.MIN_VALUE;
//        int[] maximumHeightBeforeIthIndex = new int[height.length];

//        for (int i = 1; i < height.length; i++) {
//            maxFromLeftTillNow = Math.max(maxFromLeftTillNow, height[i - 1]);
//            maximumHeightBeforeIthIndex[i] = maxFromLeftTillNow;
//        }

//        int maxFromRightAfterIthIndex = Integer.MIN_VALUE;

//        for (int i = height.length - 2; i >= 1; i--) {
//            maxFromRightAfterIthIndex = Math.max(maxFromRightAfterIthIndex, height[i + 1]);

//            int minOfLeftAndRight = Math.min(maxFromRightAfterIthIndex, maximumHeightBeforeIthIndex[i]);

//            int waterCurrentIndexCanHold = 0;
//            if (minOfLeftAndRight > height[i]) {
//                waterCurrentIndexCanHold += minOfLeftAndRight - height[i];
//            }

//            maxRainTrapped += waterCurrentIndexCanHold;
//        }

//        return maxRainTrapped;
//    }
// }

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(nums));
    }
}
