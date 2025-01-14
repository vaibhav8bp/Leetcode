package org.example.Bi_Weekly._147;

// https://leetcode.com/problems/substring-matching-pattern/description/
public class _3407_Substring_Matching_Pattern {
    public boolean hasMatch(String s, String p) {
        String[] parts = p.split("\\*");

        // p -> contains only *
        if (parts.length == 0) {
            return true;
        }

        // p is like -> something*
        if (parts.length == 1) {
            return s.contains(parts[0]);
        }

        // p is like-> *something
        if (parts[0].isEmpty()) {
            return s.contains(parts[1]);
        }

        // Now p is like something*something, just have to ensure that
        // endingIndex of first something is < than starting index of second something.
        // No Overlapping should be there.

        int firstPartIndex = s.indexOf(parts[0]);
        int secondPartIndex = s.lastIndexOf(parts[1]);

        int lastIndexOfFirstPart = firstPartIndex + parts[0].length() - 1;

        return firstPartIndex != -1 && secondPartIndex != -1 && lastIndexOfFirstPart < secondPartIndex;
    }
}
