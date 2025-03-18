package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm.N_Meetings_In_One_Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StartEndPair {
    public int start;
    public int end;

    public StartEndPair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public static int maxMeetings(int[] start, int[] end, int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        List<StartEndPair> startEndPairList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            startEndPairList.add(new StartEndPair(start[i], end[i]));
        }

        Comparator<StartEndPair> startEndPairComparator = Comparator.comparingInt(a -> a.end);

        startEndPairList.sort(startEndPairComparator);

        int meetingsTakenPlace = 1; // For Initial Meeting
        int lastMeetingTime = startEndPairList.get(0).end;

        for (int i = 1; i < n; i++) {
            if (startEndPairList.get(i).start > lastMeetingTime) {
                meetingsTakenPlace++;
                lastMeetingTime = startEndPairList.get(i).end;
            }
        }

        return meetingsTakenPlace;
    }
}
//1
//3
//10 12 20
//20 25 30

//1
//6
//1 3 0 5 8 5
//2 4 6 7 9 9

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int[] start = new int[n];
            int[] end = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            int ans = Solution.maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}