package org.example.Weekly._408._3233_Find_the_Count_of_Numbers_Which_Are_Not_Special;

class Solution {

    private boolean isCurrentNumberNotSpecial(int currentNumber) {
        int count = 0;
        for (int i = 1; i <= currentNumber / 2; i++) {
            if (currentNumber % i == 0) {
                count++;
            }
            if (count > 2) {
                return true;
            }
        }

        return count != 2;
    }

    public int nonSpecialCount(int l, int r) {
        int count = 0;
        while (l <= r) {
            if (isCurrentNumberNotSpecial(l)) {
                count++;
            }
            l++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().nonSpecialCount(4, 16));
    }
}
