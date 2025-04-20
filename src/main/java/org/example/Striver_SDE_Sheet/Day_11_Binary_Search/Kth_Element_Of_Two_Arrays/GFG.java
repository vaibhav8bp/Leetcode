package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Kth_Element_Of_Two_Arrays;

import java.io.*;

// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
class Solution {
    public long kthElement(int[] a, int[] b, int k) {

        int n = a.length;
        int m = b.length;

        if (n > m) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            int mid = (low + high) / 2;

            int l1 = (mid - 1 >= 0) ? a[mid - 1] : Integer.MIN_VALUE;
            int l2 = ((k - mid - 1) >= 0) ? b[k - mid - 1] : Integer.MIN_VALUE;
            int r1 = (mid < n) ? a[mid] : Integer.MAX_VALUE;
            int r2 = ((k - mid) < m) ? b[k - mid] : Integer.MAX_VALUE;

            if (l1 > r2) {
                high = mid - 1;
            } else if (l2 > r1) {
                low = mid + 1;
            } else {
                return Math.max(l1, l2);
            }
        }

        return -1;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

//1
//5 4 5
//2 3 6 7 9
//1 4 8 10


//1
//5 7 7
//100 112 256 349 770
//72 86 113 119 265 445 892

//1
//11 11 2
//5 5 8 8 8 9 11 11 11 11 11
//4 4 4 4 6 8 9 9 9 11 13