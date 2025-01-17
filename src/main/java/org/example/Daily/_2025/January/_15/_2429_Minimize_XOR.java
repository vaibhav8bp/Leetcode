package org.example.Daily._2025.January._15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Helper {
    StringBuilder binary;
    List<Integer> onesIndexes;
    List<Integer> zeroIndexes;

    public Helper(StringBuilder binary, List<Integer> onesIndexes, List<Integer> zeroIndexes) {
        this.binary = binary;
        this.onesIndexes = onesIndexes;
        this.zeroIndexes = zeroIndexes;
    }
}

public class _2429_Minimize_XOR {

    private int binaryStringToDecimal(StringBuilder binaryString) {
        int answer = 0;
        int power = 1;

        for (int i = binaryString.length() - 1; i >= 0; i--, power *= 2) {
            if (binaryString.charAt(i) == '1') {
                answer = answer + power;
            }
        }

        return answer;
    }

    private Helper decimalToBinaryInString(int num) {
        StringBuilder answer = new StringBuilder();
        List<Integer> onesIndexes = new ArrayList<>();
        List<Integer> zeroIndexes = new ArrayList<>();

        int index = 0;
        while (num != 0) {
            int remainder = num % 2;
            if (remainder == 1) {
                onesIndexes.add(index);
            } else {
                zeroIndexes.add(index);
            }
            answer.append(remainder);
            num /= 2;
            index++;
        }
        Collections.reverse(onesIndexes);
        Collections.reverse(zeroIndexes);
        onesIndexes.replaceAll(currentNumber -> answer.length() - 1 - currentNumber);
        zeroIndexes.replaceAll(currentNumber -> answer.length() - 1 - currentNumber);
        return new Helper(answer.reverse(), onesIndexes, zeroIndexes);
    }

    public int minimizeXor(int num1, int num2) {
        if (num2 == 0) {
            return num2;
        }

        Helper num1Helper = decimalToBinaryInString(num1);
        Helper num2Helper = decimalToBinaryInString(num2);

        StringBuilder answer = new StringBuilder("0".repeat(num1Helper.binary.length()));
        int bitsToBeSet = num2Helper.onesIndexes.size();

        for (int i = 0; i < num1Helper.onesIndexes.size() && bitsToBeSet > 0; i++, bitsToBeSet--) {
            answer.setCharAt(num1Helper.onesIndexes.get(i), '1');
        }

        for (int i = num1Helper.zeroIndexes.size() - 1; i >= 0 && bitsToBeSet > 0; i--, bitsToBeSet--) {
            answer.setCharAt(num1Helper.zeroIndexes.get(i), '1');
        }

        if (bitsToBeSet != 0) {
            answer = new StringBuilder("1".repeat(bitsToBeSet)).append(answer);
        }

        return binaryStringToDecimal(answer);
    }
}
