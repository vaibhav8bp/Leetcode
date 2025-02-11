package org.example.Daily._2025.February._11;

// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
public class _1910_Remove_All_Occurrences_of_a_Substring {

    public String removeOccurrences(String s, String part) {
        StringBuilder characterStack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character currentCharacter = s.charAt(i);
            characterStack.append(currentCharacter);

            if (currentCharacter == part.charAt(part.length() - 1) && characterStack.length() >= part.length()) {
                int characterStackIndex = characterStack.length() - 1;
                int partIndex = part.length() - 1;
                while (partIndex != -1 && (characterStack.charAt(characterStackIndex) == part.charAt(partIndex))) {
                    partIndex--;
                    characterStackIndex--;
                }
                // Match Found, Delete part from characterStack
                if (partIndex == -1) {
                    characterStack.replace(characterStack.length() - part.length(), characterStack.length(), "");
                }
            }
        }

        return characterStack.toString();
    }

//    public String removeOccurrences(String s, String part) {
//        while (s.contains(part)) {
//            s = s.replaceFirst(part, "");
//        }
//        return s;
//    }
}
