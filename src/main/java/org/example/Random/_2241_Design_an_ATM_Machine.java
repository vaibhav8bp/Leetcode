package org.example.Random;

// https://leetcode.com/problems/design-an-atm-machine/description/

import java.util.Arrays;

class ATM {

    private final int[] denominations = {20, 50, 100, 200, 500};
    int[] notes;

    public ATM() {
        notes = new int[5];
        Arrays.fill(notes, 0);
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            notes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {

        int[] result = new int[5];

        for (int i = 4; i >= 0; i--) {
            if (notes[i] != 0 && denominations[i] <= amount) {
                int available = notes[i];
                int maxNeeded = amount / denominations[i];
                int notesWithDrawn = Math.min(available, maxNeeded);
                amount -= notesWithDrawn * denominations[i];
                result[i] += notesWithDrawn;
            }
            if (amount == 0) {
                break;
            }
        }

        if (amount != 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < 5; i++) {
            notes[i] -= result[i];
        }

        return result;
    }
}

public class _2241_Design_an_ATM_Machine {
}