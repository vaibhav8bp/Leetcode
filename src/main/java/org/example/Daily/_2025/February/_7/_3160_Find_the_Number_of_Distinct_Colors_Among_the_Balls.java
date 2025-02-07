package org.example.Daily._2025.February._7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
public class _3160_Find_the_Number_of_Distinct_Colors_Among_the_Balls {

    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballToColorMapping = new HashMap<>();
        Map<Integer, Integer> colorToFrequencyMapping = new HashMap<>();
        int index = 0;

        for (int[] currentQuery : queries) {
            int currentBall = currentQuery[0];
            int currentColor = currentQuery[1];

            if (Objects.nonNull(ballToColorMapping.get(currentBall))) {
                if (ballToColorMapping.get(currentBall) != currentColor) {
                    colorToFrequencyMapping.put(ballToColorMapping.get(currentBall), colorToFrequencyMapping.get(ballToColorMapping.get(currentBall)) - 1);
                    if (colorToFrequencyMapping.get(ballToColorMapping.get(currentBall)) == 0) {
                        colorToFrequencyMapping.remove(ballToColorMapping.get(currentBall));
                    }
                    ballToColorMapping.put(currentBall, currentColor);
                    colorToFrequencyMapping.put(currentColor, colorToFrequencyMapping.getOrDefault(currentColor, 0) + 1);
                }
            } else {
                ballToColorMapping.put(currentBall, currentColor);
                colorToFrequencyMapping.put(currentColor, colorToFrequencyMapping.getOrDefault(currentColor, 0) + 1);
            }

            result[index++] = colorToFrequencyMapping.size();
        }

        return result;
    }
}