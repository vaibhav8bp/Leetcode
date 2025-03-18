package org.example.Daily._2025.March._5;

// https://leetcode.com/problems/count-total-number-of-colored-cells/description/
public class _2579_Count_Total_Number_of_Colored_Cells {

    // 1 +4+4*2+4*3+4*4+............+4*(n-1)
    // 1 +4(1+2+3+.......+(n-1))
    // 1 + 4*((n-1)*(n))/2
    // 1 + 2*(n)(n-1)
    public long coloredCells(int n) {
        return 1 + 2L * n * (n - 1);
    }

//    public long coloredCells(int n) {
//        int middleColumnElements = 2 * n - 1;
//        long answer = middleColumnElements;
//        middleColumnElements -= 2;
//
//        while (middleColumnElements != -1) {
//            answer += (2L * middleColumnElements);
//            middleColumnElements -= 2;
//        }
//
//        return answer;
//    }
}
