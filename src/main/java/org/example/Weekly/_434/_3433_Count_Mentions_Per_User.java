package org.example.Weekly._434;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/count-mentions-per-user/description/
public class _3433_Count_Mentions_Per_User {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] nextAvailable = new int[numberOfUsers];

        events.sort((o1, o2) -> {
            if (Integer.parseInt(o1.get(1)) != Integer.parseInt(o2.get(1))) {
                return Integer.compare(Integer.parseInt(o1.get(1)), Integer.parseInt(o2.get(1)));
            } else {
                if (o1.getFirst().equals("OFFLINE")) {
                    return -1;
                } else if (o2.getFirst().equals("OFFLINE")) {
                    return 1;
                }
                return 0;
            }
        });

        int currentTime;
        int allMentionCount = 0;
        for (List<String> currentEvent : events) {
            String firstPart = currentEvent.getFirst();
            String middlePart = currentEvent.get(1);
            String thirdPart = currentEvent.getLast();

            currentTime = Integer.parseInt(middlePart);

            if (firstPart.equals("MESSAGE")) {
                if (thirdPart.equals("ALL")) {
                    allMentionCount++;
                } else if (thirdPart.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextAvailable[i] <= currentTime) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] ids = thirdPart.split(" ");
                    for (String currentId : ids) {
                        mentions[Integer.parseInt(currentId.replace("id", ""))]++;
                    }
                }
            } else if (firstPart.equals("OFFLINE")) {
                nextAvailable[Integer.parseInt(thirdPart)] = currentTime + 60;
            }
        }

        for (int i = 0; i < numberOfUsers; i++) {
            mentions[i] += allMentionCount;
        }

        return mentions;
    }
}
