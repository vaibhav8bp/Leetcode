package org.example.Striver_SDE_Sheet.Day_16_String_Part_II._38_Count_And_Say;

// https://leetcode.com/problems/count-and-say/
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String recursive = countAndSay(n - 1);

        StringBuilder stringBuilder = new StringBuilder();

        int start = 0;
        int end = 0;

        while (start < recursive.length()) {
            while (end < recursive.length() && recursive.charAt(start) == recursive.charAt(end)) {
                end++;
            }
            stringBuilder.append(end - start);
            stringBuilder.append(recursive.charAt(start));
            start = end;
        }

        return stringBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}
