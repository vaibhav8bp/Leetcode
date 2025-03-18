package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Find_Nth_Root_Of_M;

class Solution {

    // Return +1 for nthPower>m
    // Return 0 for nthPower==m
    // Return -1 for nthPower<m

    public static int NthPower(long number, int n, int m) {
        long answer = 1;
        while (n != 0) {
            if (n % 2 == 0) {
                number *= number;
                n /= 2;
            } else {
                answer *= number;
                n--;
            }
            if ((answer > m) || (number > m)) {
                return 1;
            }
        }
        if (answer == m) {
            return 0;
        }
        return -1;
    }

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int NthPowerOfMid = NthPower(mid, n, m);
            if (NthPowerOfMid == 0) {
                return mid;
            } else if (NthPowerOfMid == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.NthRoot(9, 1953125));
    }
}
