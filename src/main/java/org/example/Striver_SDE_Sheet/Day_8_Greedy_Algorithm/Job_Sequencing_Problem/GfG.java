package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm.Job_Sequencing_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}


//Input:
//N = 4
//Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
//Output:
//        2 60
//Explanation:
//Job1 and Job3 can be done with
//maximum profit of 60 (20+40).

//1
//4
//1 4 20 2 1 10 3 1 40 4 1 30

//Input:
//N = 5
//Jobs = {(1,2,100),(2,1,19),(3,2,27),
//        (4,1,25),(5,1,15)}
//Output:
//        2 127
//Explanation:
//        2 jobs can be done with
//maximum profit of 127 (100+27).

//1
//5
//1 2 100 2 1 19 3 2 27 4 1 25 5 1 15


// Approach sort the jobs in decreasing order of profit
// Then Calculate maximum deadline and make an of that size
// Try to schedule current job as last as possible based on deadline.

class Solution {
    int[] JobScheduling(Job[] arr, int n) {
        int[] resultArr = new int[2];
        Comparator<Job> jobProfitComparator = (a, b) -> b.profit - a.profit;
        Arrays.sort(arr, jobProfitComparator);
        Comparator<Job> deadlineComparator = Comparator.comparingInt(a -> a.deadline);
        int maximumDeadline = Arrays.stream(arr).max(deadlineComparator).get().deadline;
        int[] taskDeadlineArray = new int[maximumDeadline + 1];
        Arrays.fill(taskDeadlineArray, -1);

        for (int i = 0; i < n; i++) {
            int currentTaskDeadline = arr[i].deadline;
            while (currentTaskDeadline != 0 && taskDeadlineArray[currentTaskDeadline] != -1) {
                currentTaskDeadline--;
            }

            // Task Can Be Scheduled
            if (currentTaskDeadline != 0) {
                taskDeadlineArray[currentTaskDeadline] = arr[i].profit;
            }
        }

        int totalProfit = 0;
        int totalJobs = 0;
        for (int i = 1; i <= maximumDeadline; i++) {
            if (taskDeadlineArray[i] != -1) {
                totalProfit += taskDeadlineArray[i];
                totalJobs++;
            }
        }
        resultArr[0] = totalJobs;
        resultArr[1] = totalProfit;
        return resultArr;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}