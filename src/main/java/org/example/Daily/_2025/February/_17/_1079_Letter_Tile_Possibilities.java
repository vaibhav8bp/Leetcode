package org.example.Daily._2025.February._17;

// https://leetcode.com/problems/letter-tile-possibilities/
public class _1079_Letter_Tile_Possibilities {

    private int numTilePossibilitiesHelper(int[] frequency) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                frequency[i]--;
                count++;
                count += numTilePossibilitiesHelper(frequency);
                frequency[i]++;
            }
        }

        return count;
    }

    public int numTilePossibilities(String tiles) {
        int[] frequency = new int[26];

        for (Character currentCharacter : tiles.toCharArray()) {
            frequency[currentCharacter - 'A']++;
        }

        return numTilePossibilitiesHelper(frequency);
    }
}