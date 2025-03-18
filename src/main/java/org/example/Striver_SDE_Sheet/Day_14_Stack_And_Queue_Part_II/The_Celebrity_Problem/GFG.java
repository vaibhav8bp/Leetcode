package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II.The_Celebrity_Problem;

import java.io.*;


// TC -O(N) , SC -O(1)
class Solution {
    int celebrity(int[][] M, int n) {

        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }


        for (int i = 0; i < n; i++) {
            if (candidate != i && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }

        return candidate;
    }
}

// TC - O(N) Stack Solution , SC -O(N) (can be avoided)
//class Solution {
//    int celebrity(int[][] M, int n) {
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            stack.add(i);
//        }
//
//        while (stack.size() != 1) {
//            int a = stack.pop();
//            int b = stack.pop();
//
//            if (M[a][b] == 1) {
//                stack.add(b);
//            } else if (M[b][a] == 1) {
//                stack.add(a);
//            }
//        }
//
//        int candidate = stack.peek();
//
//        for (int i = 0; i < n; i++) {
//            if (candidate != i && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
//                return -1;
//            }
//        }
//
//        return candidate;
//    }
//}


// TC - O(N^2) Brute Force Solution , SC -O(N) (can be avoided)
//class Solution {
//    int celebrity(int[][] M, int n) {
//        List<Integer> possibleCelebrity = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            boolean doesCurrentPersonKnowSomeone = false;
//            for (int j = 0; j < n; j++) {
//                if (M[i][j] == 1) {
//                    doesCurrentPersonKnowSomeone = true;
//                    break;
//                }
//            }
//            if (!doesCurrentPersonKnowSomeone) {
//                possibleCelebrity.add(i);
//            }
//        }
//
//        for (int i = 0; i < possibleCelebrity.size(); i++) {
//            boolean isCurrentCelebrityKnownByEveryone = true;
//            for (int j = 0; j < n; j++) {
//                if (j == possibleCelebrity.get(i)) {
//                    continue;
//                }
//                if (M[j][possibleCelebrity.get(i)] != 1) {
//                    isCurrentCelebrityKnownByEveryone = false;
//                    break;
//                }
//            }
//            if (isCurrentCelebrityKnownByEveryone) {
//                return possibleCelebrity.get(i);
//            }
//        }
//
//        return -1;
//    }
//}

public class GFG {
    public static void main(String[] args) throws IOException {
        int[][] M = {
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };
        int n = 4;
        System.out.println(new Solution().celebrity(M, n));
    }
}