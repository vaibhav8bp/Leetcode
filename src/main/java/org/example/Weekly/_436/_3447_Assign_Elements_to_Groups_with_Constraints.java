package org.example.Weekly._436;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
public class _3447_Assign_Elements_to_Groups_with_Constraints {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] assigned = new int[groups.length];

        Map<Integer, Integer> elementToSmallestIndexMapping = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            if (!elementToSmallestIndexMapping.containsKey(elements[i])) {
                elementToSmallestIndexMapping.put(elements[i], i);
            }
        }

        int index = 0;

        for (int currentGroup : groups) {
            int currentAnswer = Integer.MAX_VALUE;
            for (int i = 1; i * i <= currentGroup; i++) {
                if ((currentGroup % i == 0) && elementToSmallestIndexMapping.containsKey(i)) {
                    currentAnswer = Math.min(currentAnswer, elementToSmallestIndexMapping.get(i));
                }
                // This is necessary because we are not considering all factors till num/2,
                // we are only considering till sqrt(num), so there can still be no. after sqrt(num) that divides
                // num, so we check during for i and num/i both, to get both answers.
                // Eg 8 , sqrt(8) = 2, but 4 is also a factor of 8.
                if ((currentGroup % (currentGroup / i) == 0) && elementToSmallestIndexMapping.containsKey(currentGroup / i)) {
                    currentAnswer = Math.min(currentAnswer, elementToSmallestIndexMapping.get(currentGroup / i));
                }
            }
            assigned[index++] = currentAnswer == Integer.MAX_VALUE ? -1 : currentAnswer;
        }

        return assigned;
    }
}
