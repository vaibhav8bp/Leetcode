package org.example.Daily._2025.March._29;

import java.util.*;

// https://leetcode.com/problems/apply-operations-to-maximize-score/description/
public class _2818_Apply_Operations_to_Maximize_Score {

    private static final int MODULO = (int) (1e9 + 7);

    private static int pow(int x, int n) {
        if (n == 1) {
            return x;
        }

        int answer = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                answer = (int) (((long) answer * x) % MODULO);
                n--;
            }

            if (n == 0) {
                break;
            }

            x = (int) (((long) x * x) % MODULO);
            n /= 2;
        }

        return answer;
    }

    private static int[] getPrimeScore(int maxNumber) {
        int[] primeScore = new int[maxNumber + 1];

        for (int i = 2; i <= maxNumber; i++) {
            if (primeScore[i] == 0) {
                for (int j = i; j <= maxNumber; j += i) {
                    primeScore[j]++;
                }
            }
        }

        return primeScore;
    }

    private static int[] getPreviousSmallerElements(List<Integer> nums, int[] primeScore) {
        int[] previousSmallerElements = new int[nums.size()];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && primeScore[nums.get(stack.peek())] < primeScore[nums.get(i)]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                previousSmallerElements[i] = -1;
            } else {
                previousSmallerElements[i] = stack.peek();
            }

            stack.add(i);
        }

        return previousSmallerElements;
    }

    private static int[] getNextGreaterElements(List<Integer> nums, int[] primeScore) {
        int[] nextGreaterElements = new int[nums.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScore[nums.get(stack.peek())] <= primeScore[nums.get(i)]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextGreaterElements[i] = nums.size();
            } else {
                nextGreaterElements[i] = stack.peek();
            }

            stack.add(i);
        }

        return nextGreaterElements;
    }

    public static int maximumScore(List<Integer> nums, int k) {

        int maxNumber = nums.stream().mapToInt(a -> a).max().getAsInt();
        int[] primeScore = getPrimeScore(maxNumber);
        int[] previousSmallerElements = getPreviousSmallerElements(nums, primeScore);
        int[] nextGreaterElements = getNextGreaterElements(nums, primeScore);
        int[][] maxElements = new int[nums.size()][2];

        for (int i = 0; i < nums.size(); i++) {
            maxElements[i] = new int[]{nums.get(i), i};
        }

        Arrays.sort(maxElements, (o1, o2) -> o2[0] - o1[0]);
        int index = 0;
        int maxScore = 1;

        while (k != 0) {
            int[] top = maxElements[index++];
            int topElement = top[0];
            int topIndex = top[1];
            long currentElementCountAvailable = (long) (nextGreaterElements[topIndex] - topIndex) * (topIndex - previousSmallerElements[topIndex]);
            long currentElementCountRequired = Math.min(currentElementCountAvailable, k);
            maxScore = (int) ((1L * maxScore * pow(topElement, (int) currentElementCountRequired)) % MODULO);
            k -= currentElementCountRequired;
        }

        return maxScore;
    }

//    private static final int MODULO = (int) (1e9 + 7);
//
//    private static void populateMaxPQ(List<Integer> nums, PriorityQueue<Integer> maxPQ, int[] primeScore) {
//
//        for (int start = 0; start < nums.size(); start++) {
//            int currentMax = -1;
//            int currentIndex = -1;
//            for (int end = start; end < nums.size(); end++) {
//                if (primeScore[nums.get(end)] > currentMax) {
//                    currentMax = primeScore[nums.get(end)];
//                    currentIndex = end;
//                }
//                maxPQ.add(nums.get(currentIndex));
//            }
//        }
//    }
//
//    public static int maximumScore(List<Integer> nums, int k) {
//
//        int maxNumber = nums.stream().mapToInt(a -> a).max().getAsInt();
//
//        int[] primeScore = new int[maxNumber + 1];
//
//        for (int i = 2; i <= maxNumber; i++) {
//            if (primeScore[i] == 0) {
//                primeScore[i]++;
//                for (int j = 2 * i; j <= maxNumber; j += i) {
//                    primeScore[j]++;
//                }
//            }
//        }
//
//        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
//
//        populateMaxPQ(nums, maxPQ, primeScore);
//
//        long maxScore = 1;
//
//        while (k != 0) {
//            maxScore = (maxScore * maxPQ.remove()) % MODULO;
//            k--;
//        }
//
//        return (int) maxScore;
//    }
}



