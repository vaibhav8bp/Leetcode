package org.example.Random;

// https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/description/
public class _2240_Number_of_Ways_to_Buy_Pens_and_Pencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        int maxPensThatCanBeBought = total / cost1;
        long answer = 0;
        int i = 0;

        for (; i <= maxPensThatCanBeBought; i++) {
            long moneyRemainingForPencils = total - (long) i * cost1;
            if (moneyRemainingForPencils <= 0) {
                break;
            } else {
                answer += (1 + (moneyRemainingForPencils / cost2));
            }
        }

        answer += (maxPensThatCanBeBought - i + 1);
        return answer;
    }
}