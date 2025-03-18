package org.example.Weekly._440;

public class Q1_Fruits_Into_Baskets_II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int unPlacedFruits = 0;

        for (int currentFruitQuantity : fruits) {
            boolean isFruitPlaced = false;
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] != -1 && baskets[j] >= currentFruitQuantity) {
                    isFruitPlaced = true;
                    baskets[j] = -1;
                    break;
                }
            }
            if (!isFruitPlaced) {
                unPlacedFruits++;
            }
        }

        return unPlacedFruits;
    }
}
