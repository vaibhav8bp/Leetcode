package org.example.Random;

// https://leetcode.com/problems/cherry-pickup/description/
public class _741_Cherry_Pickup {

    // Think Of it 2 people stating from 0,0 have to go to n-1*n-1 and they start at the same time, because
    // if we take max from 0,0 to n-1*n-1 and then max from n-1*n-1 to 0*0 it will give wrong answer for recursion
    // and TLE for backtracking.
    // NOTE: Backtracking will give correct answer.

    // NOTE: at any point r1+c1 = r2+c2.
    // Why ?
    // Because each robot can only move down/right or up/left.
    // So there delta will always be same considering,they are moving each step at the same time.
    // So they will reach at their destination also at the same time.

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        dp[n - 1][n - 1][n - 1] = (grid[n - 1][n - 1] == -1 ? Integer.MIN_VALUE : grid[n - 1][n - 1]);

        for (int r1 = n - 1; r1 >= 0; r1--) {
            for (int c1 = n - 1; c1 >= 0; c1--) {
                for (int r2 = n - 1; r2 >= 0; r2--) {
                    int c2 = r1 + c1 - r2;
                    if (c2 >= n || c2 < 0 || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        dp[r1][c1][r2] = Integer.MIN_VALUE;
                        continue;
                    }
                    if (r1 == n - 1 && c1 == n - 1) {
                        dp[r1][c1][r2] = grid[r1][c1];
                        continue;
                    }

                    int currentStepCherries = 0;
                    if ((r1 == r2) && (c1 == c2)) {
                        currentStepCherries += grid[r1][c1];
                    } else {
                        currentStepCherries += (grid[r1][c1] + grid[r2][c2]);
                    }

                    // 4 combinations arise now.
                    // Down Down
                    // Right Right
                    // Down Right
                    // Right Down

                    int maxRecursiveCherries = Integer.MIN_VALUE;
                    // Down Down
                    if ((r1 + 1) < n && (r2 + 1) < n) {
                        maxRecursiveCherries = dp[r1 + 1][c1][r2 + 1];
                    }
                    // Right Right
                    if ((c1 + 1) < n && (c2 + 1) < n) {
                        maxRecursiveCherries = Math.max(maxRecursiveCherries, dp[r1][c1 + 1][r2]);
                    }
                    // Down Right
                    if ((r1 + 1) < n && (c2 + 1) < n) {
                        maxRecursiveCherries = Math.max(maxRecursiveCherries, dp[r1 + 1][c1][r2]);
                    }
                    // Right Down
                    if ((c1 + 1) < n && (r2 + 1) < n) {
                        maxRecursiveCherries = Math.max(maxRecursiveCherries, dp[r1][c1 + 1][r2 + 1]);
                    }

                    if (maxRecursiveCherries == Integer.MIN_VALUE) {
                        dp[r1][c1][r2] = Integer.MIN_VALUE;
                    } else {
                        dp[r1][c1][r2] = currentStepCherries + maxRecursiveCherries;
                    }
                }
            }
        }

        return Math.max(0, dp[0][0][0]);
    }

//    private int cherryPickup(int r1, int c1, int r2, int n, int[][] grid, int[][][] dp) {
//
//        // r1+c1=r2+c2
//        int c2 = r1 + c1 - r2;
//
//        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
//            return Integer.MIN_VALUE;
//        }
//
//        if (r1 == n - 1 && c1 == n - 1) {
//            return grid[r1][c1];
//        }
//
//        if (dp[r1][c1][r2] != -1) {
//            return dp[r1][c1][r2];
//        }
//
//        int currentStepCherries = 0;
//        if ((r1 == r2) && (c1 == c2)) {
//            currentStepCherries += grid[r1][c1];
//        } else {
//            currentStepCherries += (grid[r1][c1] + grid[r2][c2]);
//        }
//
//        // 4 combinations arise now.
//        // Down Down
//        // Right Right
//        // Down Right
//        // Right Down
//
//        int maxRecursiveCherries = cherryPickup(r1 + 1, c1, r2 + 1, n, grid, dp);
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2, n, grid, dp));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1 + 1, c1, r2, n, grid, dp));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2 + 1, n, grid, dp));
//
//        if (maxRecursiveCherries == Integer.MIN_VALUE) {
//            dp[r1][c1][r2] = Integer.MIN_VALUE;
//        } else {
//            dp[r1][c1][r2] = currentStepCherries + maxRecursiveCherries;
//        }
//
//        return dp[r1][c1][r2];
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int n = grid.length;
//        int[][][] dp = new int[n][n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//
//        return Math.max(0, cherryPickup(0, 0, 0, n, grid, dp));
//    }

//    private int cherryPickup(int r1, int c1, int r2, int c2, int n, int[][] grid, int[][][][] dp) {
//
//        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
//            return Integer.MIN_VALUE;
//        }
//
//        if (r1 == n - 1 && c1 == n - 1) {
//            return grid[r1][c1];
//        }
//
//        if (dp[r1][c1][r2][c2] != -1) {
//            return dp[r1][c1][r2][c2];
//        }
//
//        int currentStepCherries = 0;
//        if ((r1 == r2) && (c1 == c2)) {
//            currentStepCherries += grid[r1][c1];
//        } else {
//            currentStepCherries += (grid[r1][c1] + grid[r2][c2]);
//        }
//
//        // 4 combinations arise now.
//        // Down Down
//        // Right Right
//        // Down Right
//        // Right Down
//
//        int maxRecursiveCherries = cherryPickup(r1 + 1, c1, r2 + 1, c2, n, grid, dp);
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2, c2 + 1, n, grid, dp));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1 + 1, c1, r2, c2 + 1, n, grid, dp));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2 + 1, c2, n, grid, dp));
//
//        if (maxRecursiveCherries == Integer.MIN_VALUE) {
//            dp[r1][c1][r2][c2] = Integer.MIN_VALUE;
//        } else {
//            dp[r1][c1][r2][c2] = currentStepCherries + maxRecursiveCherries;
//        }
//
//        return dp[r1][c1][r2][c2];
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int n = grid.length;
//        int[][][][] dp = new int[n][n][n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    Arrays.fill(dp[i][j][k], -1);
//                }
//            }
//        }
//
//        return Math.max(0, cherryPickup(0, 0, 0, 0, n, grid, dp));
//    }

//    private int cherryPickup(int r1, int c1, int r2, int c2, int n, int[][] grid) {
//
//        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
//            return Integer.MIN_VALUE;
//        }
//
//        if (r1 == n - 1 && c1 == n - 1) {
//            return grid[r1][c1];
//        }
//
//        int currentStepCherries = 0;
//        if ((r1 == r2) && (c1 == c2)) {
//            currentStepCherries += grid[r1][c1];
//        } else {
//            currentStepCherries += (grid[r1][c1] + grid[r2][c2]);
//        }
//
//        // 4 combinations arise now.
//        // Down Down
//        // Right Right
//        // Down Right
//        // Right Down
//
//        int maxRecursiveCherries = cherryPickup(r1 + 1, c1, r2 + 1, c2, n, grid);
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2, c2 + 1, n, grid));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1 + 1, c1, r2, c2 + 1, n, grid));
//        maxRecursiveCherries = Math.max(maxRecursiveCherries, cherryPickup(r1, c1 + 1, r2 + 1, c2, n, grid));
//
//        if (maxRecursiveCherries == Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        }
//
//        return currentStepCherries + maxRecursiveCherries;
//    }
//
//    public int cherryPickup(int[][] grid) {
//        return Math.max(0, cherryPickup(0, 0, 0, 0, grid.length, grid));
//    }
}
