package org.example.Bi_Weekly._147;

public class Q1_Substring_Matching_Pattern {
    public boolean hasMatch(String s, String p) {
        String[] parts = p.split("\\*");

        if (parts.length == 0) {
            return true;
        }

        if (parts.length == 1) {
            return s.contains(parts[0]);
        }

        if (parts[0].isEmpty()) {
            return s.contains(parts[1]);
        }

        int firstPartIndex = s.indexOf(parts[0]);
        int secondPartIndex = s.lastIndexOf(parts[1]);
        int lastIndexOfFirstPart = firstPartIndex + parts[0].length() - 1;

        return firstPartIndex != -1 && secondPartIndex != -1 && lastIndexOfFirstPart < secondPartIndex;
    }
}
