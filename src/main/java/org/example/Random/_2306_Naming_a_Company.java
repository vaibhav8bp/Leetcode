package org.example.Random;


// https://leetcode.com/problems/naming-a-company/description/
public class _2306_Naming_a_Company {

    public long distinctNames(String[] ideas) {
        long answer = 0;



        return answer;
    }

//    public long distinctNames(String[] ideas) {
//
//        Set<String> stringSet = new HashSet<>(Arrays.asList(ideas));
//
//        long answer = 0;
//
//        for (int i = 0; i < ideas.length; i++) {
//            for (int j = i + 1; j < ideas.length; j++) {
//                StringBuilder ideaA = new StringBuilder(ideas[i]);
//                StringBuilder ideaB = new StringBuilder(ideas[j]);
//                char tempA = ideaA.charAt(0);
//                ideaA.setCharAt(0, ideaB.charAt(0));
//                ideaB.setCharAt(0, tempA);
//
//                if (!stringSet.contains(ideaA.toString()) && !stringSet.contains(ideaB.toString())) {
//                    answer++;
//                }
//            }
//        }
//
//        // for every (i,j) , (j,i) will also contribute to answer.
//        return answer * 2;
//    }
}
