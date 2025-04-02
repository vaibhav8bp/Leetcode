package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._50_Pow_x_n;

// https://leetcode.com/problems/powx-n/description/
class Solution {
   public double myPow(double x, int n) {
       int positiveN = Math.abs(n);
       double answer = 1;
       while (positiveN != 0) {
           if (positiveN % 2 == 0) {
               x *= x;
               positiveN /= 2;
           } else {
               answer *= x;
               positiveN--;
           }
       }
       if (n < 0) {
           return 1 / answer;
       }
       return answer;
   }
}


// Bit Manipulation
// class Solution {
//     public double myPow(double x, int n) {
//         if (n < 0) {
//             n = -n;
//             x = 1 / x;
//         }
//         double answer = 1;
//         while (n != 0) {
//             if ((n & 1) != 0) {
//                 answer *= x;
//             }
//             x *= x;
//             n = n >> 1;
//         }
//         return answer;
//     }
// }

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.000, -10));
    }
}
