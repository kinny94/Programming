package questions.leetcode;

import java.util.*;

public class ListOfAllPossibleRecipesFromGiveSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
        }

        for (String supply : supplies) {
            inDegree.put(supply, 0);
        }

        // Build the graph edges
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipe); // ingredient -> recipe
                inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();

        for (String key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }

        while(!queue.isEmpty()) {
            String vertex = queue.poll();
            if (Arrays.asList(recipes).contains(vertex)) {
                results.add(vertex);
            }
            List<String> children = graph.get(vertex);
            if (graph.containsKey(vertex)) {
                for (String child: children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }

        }

        return results;
    }
}
