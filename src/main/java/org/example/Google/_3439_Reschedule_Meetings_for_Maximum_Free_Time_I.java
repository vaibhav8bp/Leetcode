package org.example.Google;

// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/
public class _3439_Reschedule_Meetings_for_Maximum_Free_Time_I {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int numberOfEvents = startTime.length;

        if (numberOfEvents == 1) {
            if (k != 0) {
                return eventTime - (endTime[0] - startTime[0]);
            } else {
                return Math.max(Math.max(0, startTime[0]), eventTime - endTime[0]);
            }
        }

        // Return eventTime-totalEventsTime
        if (k == numberOfEvents) {
            int totalEventsTime = 0;
            for (int i = 0; i < numberOfEvents; i++) {
                totalEventsTime += (endTime[i] - startTime[i]);
            }
            return eventTime - totalEventsTime;
        }

        int[] gaps = new int[numberOfEvents + 1];
        gaps[0] = startTime[0];
        gaps[numberOfEvents] = eventTime - endTime[numberOfEvents - 1];

        for (int i = 1; i < numberOfEvents; i++) {
            gaps[i] = (startTime[i] - endTime[i - 1]);
        }

        int currentFreeTime = 0;

        // Taking i, till = k because when moving ith event , we get both left and right space to be vacant.
        for (int i = 0; i <= k; i++) {
            currentFreeTime += gaps[i];
        }

        int answer = currentFreeTime;

        for (int i = k + 1; i < numberOfEvents + 1; i++) {
            currentFreeTime = currentFreeTime + gaps[i] - gaps[i - (k + 1)];
            answer = Math.max(answer, currentFreeTime);
        }

        return answer;
    }

    // 0...[2,4]....[7,35]......[49,85]......[94,126].....182 -> Output 82
    //   2        3         14           9             56
    // 0...[2,4]....[7,35][35,71]............[94,126].....182
    // 0...[2,4][4,32]..........................[114,150][150,182]

    // 0......[7,10][10,14]......[16,18]...............21

    // 0...[2,4]....[7,35]......[49,85]......[94,126].....182 -> Output 82
    //   2        3         14           9             56
}
