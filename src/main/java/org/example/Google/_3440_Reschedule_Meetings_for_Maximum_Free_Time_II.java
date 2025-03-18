package org.example.Google;

// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/
public class _3440_Reschedule_Meetings_for_Maximum_Free_Time_II {

    // Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
    // startTime = [0,3,7,9]
    // endTime   = [1,4,8,10]

    // Event Index         0        1         2           3
    // Duration            1        1         1           1
    // Events            [0,1]....[3,4].....[7,8].......[9,10]
    // Gap Index      0        1         2          3             4
    // Gaps           0        2         3          1             0


    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

        int numberOfEvents = startTime.length;
        int[] gaps = new int[numberOfEvents + 1];
        int maxFreeTime = 0;
        gaps[0] = startTime[0];
        maxFreeTime = Math.max(maxFreeTime, gaps[0]);
        gaps[numberOfEvents] = eventTime - endTime[numberOfEvents - 1];
        maxFreeTime = Math.max(maxFreeTime, gaps[numberOfEvents]);

        for (int i = 1; i < numberOfEvents; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
            maxFreeTime = Math.max(maxFreeTime, gaps[i]);
        }

        // Basically for each event we have 2 choices
        // 1. Obvious-> paste every event to just before or after its adjacent events. That reduces gap.
        // 2. If there is a gap available that is >= any event, that entire event can be shifted and
        // gap can now difference between previous and next event.

        int[] maximumGapTowardsLeft = new int[numberOfEvents - 1];
        int[] maximumGapTowardsRight = new int[numberOfEvents - 1];

        for (int i = 0; i < numberOfEvents - 1; i++) {
            if (i == 0) {
                maximumGapTowardsLeft[i] = gaps[0];
            } else {
                maximumGapTowardsLeft[i] = Math.max(maximumGapTowardsLeft[i - 1], gaps[i]);
            }
        }

        for (int i = numberOfEvents - 2; i >= 0; i--) {
            if (i == (numberOfEvents - 2)) {
                maximumGapTowardsRight[i] = gaps[i + 2];
            } else {
                maximumGapTowardsRight[i] = Math.max(maximumGapTowardsRight[i + 1], gaps[i + 2]);
            }
        }

        for (int i = 0; i < numberOfEvents; i++) {
            int currentEventDuration = endTime[i] - startTime[i];
            if (i == 0) {
                maxFreeTime = Math.max(maxFreeTime, startTime[1] - currentEventDuration);
                if (currentEventDuration <= maximumGapTowardsRight[i]) {
                    maxFreeTime = Math.max(maxFreeTime, startTime[1]);
                }
            } else if (i == numberOfEvents - 1) {
                maxFreeTime = Math.max(maxFreeTime, eventTime - endTime[i - 1] - currentEventDuration);
                if (currentEventDuration <= maximumGapTowardsLeft[i - 1]) {
                    maxFreeTime = Math.max(maxFreeTime, eventTime - endTime[i - 1]);
                }
            } else {
                maxFreeTime = Math.max(maxFreeTime, startTime[i + 1] - endTime[i - 1] - currentEventDuration);
                if ((currentEventDuration <= maximumGapTowardsLeft[i - 1]) || (currentEventDuration <= maximumGapTowardsRight[i])) {
                    maxFreeTime = Math.max(maxFreeTime, startTime[i + 1] - endTime[i - 1]);
                }
            }
        }

        return maxFreeTime;
    }
}
