package org.example.Striver_SDE_Sheet.Day_16_String_Part_II._165_Compare_Version_Numbers;

// https://leetcode.com/problems/compare-version-numbers/
class Solution {
    public int compareVersion(String version1, String version2) {
        int v1Index = 0;
        int v2Index = 0;

        while (v1Index < version1.length() && v2Index < version2.length()) {
            // Skip Leading Zeros
            while (v1Index < version1.length() && version1.charAt(v1Index) == '0') {
                v1Index++;
            }

            while (v2Index < version2.length() && version2.charAt(v2Index) == '0') {
                v2Index++;
            }

            int v1Number = 0;
            int v2Number = 0;
            int placeValue = 1;
            while (v1Index < version1.length() && v2Index < version2.length() && version1.charAt(v1Index) != '.' && version2.charAt(v2Index) != '.') {
                v1Number = placeValue * v1Number + (version1.charAt(v1Index) - '0');
                v2Number = placeValue * v2Number + (version2.charAt(v2Index) - '0');
                v1Index++;
                v2Index++;
                placeValue *= 10;
            }

            // If any of the strings has any char now they are bigger for sure on virtue of length
            if ((v1Index < version1.length() && version1.charAt(v1Index) != '.')) {
                return 1;
            } else if ((v2Index < version2.length() && version2.charAt(v2Index) != '.')) {
                return -1;
            }
            // now we know both revisions are of same length just compare numbers
            else if (v1Number > v2Number) {
                return 1;
            } else if (v1Number < v2Number) {
                return -1;
            }

            v1Index++;
            v2Index++;
        }

        while (v1Index < version1.length()) {
            if (version1.charAt(v1Index) != '0' && version1.charAt(v1Index) != '.') {
                return 1;
            }
            v1Index++;
        }

        while (v2Index < version2.length()) {
            if (version2.charAt(v2Index) != '0' && version2.charAt(v2Index) != '.') {
                return -1;
            }
            v2Index++;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.01", "1.001"));
    }
}
