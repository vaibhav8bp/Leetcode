package org.example.Striver_SDE_Sheet.Day_15_String._686_Repeated_String_Match;

class Solution {

    private final long BASE = 26;
    private final long MODULUS = Long.MAX_VALUE;

    public boolean matchString(String hayStack, String needle) {
        long needleHash = 0;
        long hayStackHash = 0;

        if (hayStack.length() == needle.length()) {
            return hayStack.equals(needle);
        }

        int needleLength = needle.length();
        int hayStackLength = hayStack.length();
        long currentBase = 1;
        for (int i = needleLength - 1; i >= 0; i--) {
            needleHash = (needleHash + needle.charAt(i) * currentBase) % MODULUS;
            hayStackHash = (hayStackHash + hayStack.charAt(i) * currentBase) % MODULUS;
            // To Avoid extra calculation
            if (i != 0) {
                currentBase = (currentBase * BASE) % MODULUS;
            }
        }

        if (needleHash == hayStackHash && needle.equals(hayStack.substring(0, needleLength))) {
            return true;
        }

        for (int i = 1; i < hayStackLength - needleLength + 1; i++) {
            hayStackHash = (BASE * ((hayStackHash - (hayStack.charAt(i - 1)) * currentBase)) +
                    (hayStack.charAt(i + needleLength - 1))) % MODULUS;

            // Ensure positive hash value
            if (hayStackHash < 0) {
                hayStackHash += MODULUS;
            }

            if (hayStackHash == needleHash && hayStack.substring(i, i + needleLength).equals(needle)) {
                return true;
            }
        }

        return false;
    }

    public int repeatedStringMatch(String a, String b) {
        if (a.isEmpty()) {
            if (b.isEmpty()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (b.isEmpty()) {
                return 0;
            }
            // a and b both non empty
            else {
                StringBuilder aBuilder = new StringBuilder(a);
                int count = 1;
                while (aBuilder.length() < b.length()) {
                    aBuilder.append(a);
                    count++;
                }
                String temp = aBuilder.toString();
                if (matchString(temp, b)) {
                    return count;
                }
                aBuilder.append(a);
                temp = aBuilder.toString();
                if (matchString(temp, b)) {
                    return count + 1;
                }
                return -1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
    }
}
