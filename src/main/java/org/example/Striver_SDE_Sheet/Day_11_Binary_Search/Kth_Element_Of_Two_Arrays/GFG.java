package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Kth_Element_Of_Two_Arrays;

import java.util.*;
import java.io.*;

class Solution {
    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {

        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            int mid = (low + high) / 2;

            int l1 = (mid - 1 >= 0) ? arr1[mid - 1] : Integer.MIN_VALUE;
            int l2 = ((k - mid - 1) >= 0) ? arr2[k - mid - 1] : Integer.MIN_VALUE;
            int r1 = (mid < n) ? arr1[mid] : Integer.MAX_VALUE;
            int r2 = ((k - mid) < m) ? arr2[k - mid] : Integer.MAX_VALUE;

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
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int[] a = new int[(int) (n)];
            int[] b = new int[(int) (m)];


            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }


            Solution obj = new Solution();
            System.out.println(obj.kthElement(a, b, n, m, k));

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