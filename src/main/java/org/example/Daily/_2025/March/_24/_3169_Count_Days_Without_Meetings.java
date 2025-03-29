package org.example.Daily._2025.March._24;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/count-days-without-meetings/
public class _3169_Count_Days_Without_Meetings {

    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int count = meetings[0][0] - 1;

        int lastMeetingEnd = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int currentMeetingStart = meetings[i][0];
            int currentMeetingEnd = meetings[i][1];

            // No OverLap + Just Touching.
            if (lastMeetingEnd <= currentMeetingStart) {
                if (lastMeetingEnd != currentMeetingStart) {
                    count += (currentMeetingStart - lastMeetingEnd - 1);
                }
                lastMeetingEnd = currentMeetingEnd;
            }
            // Mix OverLap
            else if (currentMeetingEnd > lastMeetingEnd) {
                lastMeetingEnd = currentMeetingEnd;
            }
            // In Case Of Mix OverLap, we have to do nothing.
        }

        count += (days - lastMeetingEnd);
        return count;
    }

//    public int countDays(int days, int[][] meetings) {
//
//        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
//
//        List<int[]> mergedMeetings = new ArrayList<>();
//
//        for (int[] currentMeeting : meetings) {
//            // if merged meetings are empty or end time of last is less than current start time, add current meeting.
//            if (mergedMeetings.isEmpty() || mergedMeetings.get(mergedMeetings.size() - 1)[1] < currentMeeting[0]) {
//                mergedMeetings.add(currentMeeting);
//            } else {
//                // update endTime of last meeting.
//                mergedMeetings.get(mergedMeetings.size() - 1)[1] = Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], currentMeeting[1]);
//            }
//        }
//
//        int count = 0;
//
//        int lastMeetingEnd = 1;
//
//        for (int[] currentMeeting : mergedMeetings) {
//            int meetingStartDay = currentMeeting[0];
//            int meetingEndDay = currentMeeting[1];
//
//            if (meetingStartDay > lastMeetingEnd) {
//                count += (meetingStartDay-lastMeetingEnd);
//            }
//
//            lastMeetingEnd = meetingEndDay + 1;
//        }
//
//        count += (days - mergedMeetings.get(mergedMeetings.size() - 1)[1]);
//
//        return count;
//    }
}
