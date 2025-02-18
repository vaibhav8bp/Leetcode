package org.example.Weekly._437;

import java.util.Arrays;

// https://leetcode.com/problems/eat-pizzas/
public class _3457_Eat_Pizzas {

    // 1,2,2,2,2,3,3,3,4,4,5,5
    // 5+  3,3,3,4
    public long maxWeight(int[] pizzas) {

        int totalDays = pizzas.length / 4;

        int oddDays = (totalDays % 2 == 0) ? totalDays / 2 : (totalDays / 2 + 1);
        int evenDays = totalDays - oddDays;

        Arrays.sort(pizzas);

        long maxWeight = 0;

        int start = 0;
        int end = pizzas.length - 1;

        for (int i = 0; i < oddDays; i++, start += 3, end--) {
            maxWeight += pizzas[end];
        }

        for (int i = 0; i < evenDays; i++, start += 2, end -= 2) {
            maxWeight += pizzas[end - 1];
        }

        return maxWeight;
    }
}
