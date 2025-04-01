package org.example.Bi_Weekly._153;

public class Q1_Reverse_Degree_of_a_String {
    public int reverseDegree(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            answer += ((i + 1) * (26 - index));
        }

        return answer;
    }
}
