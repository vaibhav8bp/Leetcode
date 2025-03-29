package org.example.Weekly._442;

// https://leetcode.com/contest/weekly-contest-442/problems/find-the-minimum-amount-of-time-to-brew-potions/description/
public class Q3_Find_the_Minimum_Amount_of_Time_to_Brew_Potions {

    private static boolean isPossible(long startTimeForW1, int manaIndex, int[] skill, int[] mana, long[] wizardAvailability) {

        long currentTime = startTimeForW1;

        for (int i = 0; i < skill.length; i++) {
            if (wizardAvailability[i] > currentTime) {
                return false;
            }
            currentTime += ((long) mana[manaIndex] * skill[i]);
        }

        return true;
    }

    private static long latestTimeForW1ToStartWorkingOnNextPotion(int manaIndex, int[] skill, int[] mana, long[] wizardAvailability) {
        long low = wizardAvailability[0];
        long high = wizardAvailability[skill.length - 1];

        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(mid, manaIndex, skill, mana, wizardAvailability)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static long minTime(int[] skill, int[] mana) {

        int wizards = skill.length;
        int potions = mana.length;

        long[] wizardAvailability = new long[skill.length];

        long leastTime = 0;

        for (int i = 0; i < wizards; i++) {
            leastTime += ((long) skill[i] * mana[0]);
            wizardAvailability[i] = leastTime;
        }

        // now for each next potion we have to find what is the latest time,
        // w1 can start working on making nextPotion.

        for (int i = 1; i < potions; i++) {
            leastTime = latestTimeForW1ToStartWorkingOnNextPotion(i, skill, mana, wizardAvailability);
            for (int j = 0; j < skill.length; j++) {
                leastTime += ((long) skill[j] * mana[i]);
                wizardAvailability[j] = leastTime;
            }
        }

        return leastTime;
    }

    public static void main(String[] args) {
        int[] skill = {1, 5, 2, 4};
        int[] mana = {5, 1, 4, 2};
        System.out.println(minTime(skill, mana));
    }
}
