package org.example.Striver_SDE_Sheet.Day_15_String._12_Integer_To_Roman;

//Symbol	Value
//I	         1
//V	         5
//X	         10
//L	         50
//C	         100
//D	         500
//M	         1000

// https://leetcode.com/problems/integer-to-roman/description/
import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> list = new ArrayList<>(List.of("I", "V", "X", "L", "C", "D", "M"));

    public String intToRoman(int num) {
        int listIndex = 0;
        StringBuilder answer = new StringBuilder();
        while (num != 0) {
            int currentDigit = (num % 10);
            if (currentDigit <= 3) {
                answer.insert(0, list.get(listIndex).repeat(currentDigit));
            } else if (currentDigit == 4) {
                answer.insert(0, list.get(listIndex) + list.get(listIndex + 1));
            } else if (currentDigit <= 8) {
                answer.insert(0, list.get(listIndex + 1) + list.get(listIndex).repeat(currentDigit - 5));
            } else {
                // Case Of 9
                answer.insert(0, list.get(listIndex) + list.get(listIndex + 2));
            }
            num /= 10;
            listIndex += 2;
        }
        return answer.toString();
    }
}

//3749

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3749));
    }
}
