package org.example.Daily._2025.April._20;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/rabbits-in-forest/description/
public class _781_Rabbits_in_Forest {

    // Use Pigeonhole principle.
    // Find no. of groups.
    // Take care of overflow.

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> colorFrequencyMapping = new HashMap<>();

        for (int currentColor : answers) {
            colorFrequencyMapping.put(currentColor, colorFrequencyMapping.getOrDefault(currentColor, 0) + 1);
        }

        int answer = 0;

        for (Map.Entry<Integer, Integer> currentEntry : colorFrequencyMapping.entrySet()) {
            int currentKey = currentEntry.getKey();
            int currentValue = currentEntry.getValue();

            int numberOfGroups = (int) Math.ceil((double) currentValue / (currentKey + 1));
            int totalRabbitsInAboveGroups = numberOfGroups * (currentKey + 1);
            answer += totalRabbitsInAboveGroups;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1, 1, 2}));
    }
}

/*
0,0,1,1,1
0 -> 2
1 -> 3
 */