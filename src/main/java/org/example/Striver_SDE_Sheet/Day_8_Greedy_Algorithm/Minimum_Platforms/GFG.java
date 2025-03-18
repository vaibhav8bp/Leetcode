package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm.Minimum_Platforms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Sort arr and dep
// Take 2 pointers
// if it is time for arrival we will need a platform
// else if it is a time for departure we will release a platform

//class Solution {
//    static int findPlatform(int[] arr, int[] dep, int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        Arrays.sort(arr);
//        Arrays.sort(dep);
//
//        int maximumPlatformsAtATime = 0;
//        int totalPlatformsNeeded = 0;
//
//        int arrPointer = 0;
//        int depPointer = 0;
//
//        while (arrPointer < n && depPointer < n) {
//            if (arr[arrPointer] <= dep[depPointer]) {
//                totalPlatformsNeeded++;
//                arrPointer++;
//            } else {
//                totalPlatformsNeeded--;
//                depPointer++;
//            }
//            maximumPlatformsAtATime = Math.max(maximumPlatformsAtATime, totalPlatformsNeeded);
//        }
//
//        return maximumPlatformsAtATime;
//    }
//}

// If there is one any intersection it results in the need of an extra platform
// Brute Force - O(N^2)
class Solution {
    static int findPlatform(int[] arr, int[] dep, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int totalPlatforms = 1;

        for (int i = 0; i < n; i++) {
            int intersections = 1;
            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                if ((arr[j] <= arr[i]) && (dep[j] >= arr[i])) {
                    intersections++;
                }
            }
            totalPlatforms = Math.max(totalPlatforms, intersections);
        }

        return totalPlatforms;
    }
}

//1
//6
//0900 0940 0950 1100 1500 1800
//0910 1200 1120 1130 1900 2000

//1
//3
//0900 1100 1235
//1000 1200 1240

//1
//3
//900 910 920
//905 915 925

//1
//5
//900 910 915 920 925
//905 915 925 925 930

//1
//6
//900 945 955 1100 1500 1800
//920 1200 1130 1150 1900 2000

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int[] arr = new int[n];
            int[] dep = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(Solution.findPlatform(arr, dep, n));
        }
    }
}

//1
//4
//1026 0445 0145 0555
//1713 2242 1144 0848