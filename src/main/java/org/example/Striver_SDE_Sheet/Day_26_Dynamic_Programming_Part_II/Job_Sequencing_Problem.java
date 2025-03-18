package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

import java.io.IOException;
import java.util.*;

// https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class Job_Sequencing_Problem {
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {

        int totalJobs = id.length;

        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < totalJobs; i++) {
            jobs.add(new Job(id[i], deadline[i], profit[i]));
        }

        Comparator<Job> maxProfitComparator = (o1, o2) -> Integer.compare(o2.profit, o1.profit);

        jobs.sort(maxProfitComparator);

        int profitAccumulated = 0;
        int jobsDone = 0;

        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        int[] jobsDeadline = new int[maxDeadline];
        Arrays.fill(jobsDeadline, -1);

        for (Job currentJob : jobs) {
            int currentJobDeadline = currentJob.deadline - 1;

            while (currentJobDeadline >= 0) {
                if (jobsDeadline[currentJobDeadline] == -1) {
                    jobsDeadline[currentJobDeadline] = currentJob.id;
                    profitAccumulated += currentJob.profit;
                    jobsDone++;
                    break;
                }
                currentJobDeadline--;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(jobsDone);
        answer.add(profitAccumulated);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Job_Sequencing_Problem obj = new Job_Sequencing_Problem();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

/*
1
1 2 3 4
4 1 1 1
20 10 40 30
 */