package org.example.Daily._2025.March._21;

import java.util.*;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
public class _2115_Find_All_Possible_Recipes_from_Given_Supplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> ingredientToRecipeMapper = new HashMap<>();
        Map<String, Integer> inDegreeMapper = new HashMap<>();

        int index = 0;

        for (String currentRecipe : recipes) {
            inDegreeMapper.put(currentRecipe, ingredients.get(index).size());
            List<String> currentRecipeIngredients = ingredients.get(index++);
            for (String currentIngredient : currentRecipeIngredients) {
                if (!ingredientToRecipeMapper.containsKey(currentIngredient)) {
                    ingredientToRecipeMapper.put(currentIngredient, new ArrayList<>());
                }
                ingredientToRecipeMapper.get(currentIngredient).add(currentRecipe);
            }
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));

        while (!queue.isEmpty()) {
            String front = queue.remove();

            // Only when recipes count becomes 0, we will add them as answer
            if (inDegreeMapper.containsKey(front)) {
                if (inDegreeMapper.get(front) == 0) {
                    answer.add(front);
                }
                else{
                    break;
                }
            }

            // can be ingredient or recipe too (recipe as an ingredient of another recipe)
            if (ingredientToRecipeMapper.containsKey(front)) {
                for (String currentRecipe : ingredientToRecipeMapper.get(front)) {
                    inDegreeMapper.put(currentRecipe, inDegreeMapper.get(currentRecipe) - 1);
                    if (inDegreeMapper.get(currentRecipe) == 0) {
                        queue.add(currentRecipe);
                    }
                }
            }

            inDegreeMapper.remove(front);
            ingredientToRecipeMapper.remove(front);
        }

        return answer;
    }
}