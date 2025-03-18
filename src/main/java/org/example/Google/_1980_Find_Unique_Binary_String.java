package org.example.Google;

// https://leetcode.com/problems/find-unique-binary-string/
public class _1980_Find_Unique_Binary_String {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder answer = new StringBuilder();

        int index = 0;
        for (String currentString : nums) {
            answer.append(currentString.charAt(index++) == '0' ? '1' : '0');
        }

        return answer.toString();
    }
}
