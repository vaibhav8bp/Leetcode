package org.example.Daily._2025.February._20;

// https://leetcode.com/problems/find-unique-binary-string/
public class _1980_Find_Unique_Binary_String {

    // n == nums.length, is a constraint, that's why this works.

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder answer = new StringBuilder();

        int index = 0;

        for (String currentString : nums) {
            if (currentString.charAt(index) == '0') {
                answer.append('1');
            } else if (currentString.charAt(index) == '1') {
                answer.append('0');
            }
            index++;
        }

        return answer.toString();
    }

//    private final char[] binaryCharacters = {'0', '1'};

//    private boolean findDifferentBinaryStringHelper(StringBuilder currentString, int stringLength, Map<String, Boolean> stringExistenceMapping) {
//        if (currentString.length() == stringLength) {
//            return !(stringExistenceMapping.containsKey(currentString.toString()));
//        }

//        for (char currentBinaryCharacter : binaryCharacters) {
//            currentString.append(currentBinaryCharacter);
//            if (findDifferentBinaryStringHelper(currentString, stringLength, stringExistenceMapping)) {
//                return true;
//            }
//            currentString.deleteCharAt(currentString.length() - 1);
//        }

//        return false;
//    }

//    public String findDifferentBinaryString(String[] nums) {
//        Map<String, Boolean> stringExistenceMapping = new HashMap<>();

//        int stringLength = nums[0].length();

//        for (String currentString : nums) {
//            stringExistenceMapping.put(currentString, true);
//        }

//        StringBuilder answer = new StringBuilder();
//        findDifferentBinaryStringHelper(answer, stringLength, stringExistenceMapping);
//        return answer.toString();
//    }
}
