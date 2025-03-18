package org.example.Google;

// https://leetcode.com/problems/separate-squares-i/
public class _3453_Separate_Squares_I {

    private boolean isUpperAreaGreaterThanLower(int[][] squares, double currentThreshold) {
        double upperArea = 0;
        double lowerArea = 0;

        for (int[] currentSquare : squares) {
            double yCoordinate = currentSquare[1];
            double currentLength = currentSquare[2];
            double upperMostPointOfSquare = yCoordinate + currentLength;

            // Completely contributes to upperArea
            if (yCoordinate >= currentThreshold) {
                upperArea += (currentLength * currentLength);
            }
            // Completely contributes to lowerArea
            else if (upperMostPointOfSquare <= currentThreshold) {
                lowerArea += (currentLength * currentLength);
            }
            // Contributes both to lower and upper area
            else {
                // Lower Contribution
                lowerArea += ((currentThreshold - yCoordinate) * currentLength);
                // Upper Contribution
                upperArea += ((upperMostPointOfSquare - currentThreshold) * currentLength);
            }
        }

        return upperArea > lowerArea;
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] currentSquare : squares) {
            low = Math.min(low, currentSquare[1]);
            high = Math.max(high, currentSquare[1] + currentSquare[2]);
        }

        while ((high - low) > 0.00001) {
            double mid = (low + high) / 2;
            if (isUpperAreaGreaterThanLower(squares, mid)) {
                low = mid;
            } else {
                // In Case of exact we will still lower high
                // as we have to find minimum y-coordinate
                high = mid;
            }
        }

        return low;
    }
}
