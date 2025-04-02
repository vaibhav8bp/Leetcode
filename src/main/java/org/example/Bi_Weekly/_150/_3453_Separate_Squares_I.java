package org.example.Bi_Weekly._150;

// https://leetcode.com/problems/separate-squares-i/description/
public class _3453_Separate_Squares_I {

    private final double LIMIT = 0.00001;

    private double difference(int[][] squares, double yCoordinate) {
        double upperArea = 0;
        double lowerArea = 0;

        for (int[] currentSquare : squares) {
            double currentSquareY = currentSquare[1];
            double currentSquareLength = currentSquare[2];
            double upperEndPointOfCurrentSquare = currentSquareY + currentSquareLength;

            // Entire Square Below yCoordinate
            if (upperEndPointOfCurrentSquare <= yCoordinate) {
                lowerArea += (currentSquareLength * currentSquareLength);
            }
            // Entire Square Above yCoordinate
            else if (currentSquareY >= yCoordinate) {
                upperArea += (currentSquareLength * currentSquareLength);
            }
            // Mismatch
            else {
                lowerArea += (currentSquareLength * (yCoordinate - currentSquareY));
                upperArea += (currentSquareLength * (upperEndPointOfCurrentSquare - yCoordinate));
            }

        }

        return upperArea - lowerArea;
    }

    public double separateSquares(int[][] squares) {
        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE;

        for (int[] currentSquare : squares) {
            if ((currentSquare[1]) < low) {
                low = currentSquare[1];
            }
            if ((currentSquare[1] + currentSquare[2]) > high) {
                high = currentSquare[1] + currentSquare[2];
            }
        }

        while ((high - low) > LIMIT) {
            double mid = (low + high) / 2;

            double difference = difference(squares, mid);

            if (difference > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
