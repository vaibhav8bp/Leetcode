package org.example.Daily._2025.March._9;

// https://leetcode.com/problems/alternating-groups-ii/description/
public class _3208_Alternating_Groups_II {

    // 0 1 0 1 0 0 1

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int numberOfAlternatingGroups = 0;
        int currentLength = 1;

        for (int i = 0; i < colors.length + k - 2; i++) {
            if (colors[i % colors.length] != colors[(i + 1) % colors.length]) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            if (currentLength == k) {
                numberOfAlternatingGroups++;
                currentLength--;
            }
        }

        return numberOfAlternatingGroups;
    }

//    public static int numberOfAlternatingGroups(int[] colors, int k) {
//        int numberOfAlternatingGroups = 0;
//
//        int currentLength = 1;
//        for (int i = 0; i < colors.length + k - 1; i++) {
//            if (colors[i] != colors[i + 1]) {
//                currentLength++;
//            } else {
//                currentLength = 1;
//            }
//            if (currentLength == k) {
//                numberOfAlternatingGroups++;
//                currentLength--;
//            }
//        }
//
//        return numberOfAlternatingGroups;
//    }

//    public static int numberOfAlternatingGroups(int[] colors, int k) {
//        int numberOfAlternatingGroups = 0;
//
//        int[] temp = new int[colors.length + k - 1];
//
//        System.arraycopy(colors, 0, temp, 0, colors.length);
//        System.arraycopy(colors, 0, temp, colors.length, k - 1);
//
//        int currentLength = 1;
//        for (int i = 0; i < temp.length - 1; i++) {
//            if (temp[i] != temp[i + 1]) {
//                currentLength++;
//            } else {
//                currentLength = 1;
//            }
//            if (currentLength == k) {
//                numberOfAlternatingGroups++;
//                currentLength--;
//            }
//        }
//
//        return numberOfAlternatingGroups;
//    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
    }

    // 0  1  2  3  4  5  6  7  8  9
    // 0, 1, 0, 1, 0, 0, 1, 0, 1, 0
}
