package org.example.Daily._2025.February._14;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/product-of-the-last-k-numbers/
public class _1352_Product_of_the_Last_K_Numbers {
}

class ProductOfNumbers {
    List<Integer> runningProduct;

    public ProductOfNumbers() {
        runningProduct = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            runningProduct.clear();
        } else {
            int previousProduct = (runningProduct.isEmpty()) ? 1 : runningProduct.getLast();
            runningProduct.add(num * previousProduct);
        }
    }

    public int getProduct(int k) {
        if (k > runningProduct.size()) {
            return 0;
        } else {
            if (runningProduct.size() == k) {
                return runningProduct.getLast();
            } else {
                return runningProduct.getLast() / runningProduct.get(runningProduct.size() - 1 - k);
            }
        }
    }
}