package com.company;

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        if (!inputValid(words)) {
            return "";
        }
        Map<Character, Set<Character>> graph = buildGraph(words);
        return topologicalSortWithCycleDetection(graph);
    }

    private boolean inputValid(String[] words) {
        return words.length > 1;
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            char[] firstWord = words[i].toCharArray();
            char[] secondWord = words[i + 1].toCharArray();
            int length = Math.min(firstWord.length, secondWord.length);

            for (int j = 0; j < length; j++) {
                if (firstWord[j] != secondWord[j]) {
                    if (!graph.containsKey(firstWord[j])) {
                        HashSet<Character> children = new HashSet<>();
                        children.add(secondWord[j]);
                        graph.put(firstWord[j], children);
                    } else {
                        graph.get(firstWord[j]).add(secondWord[j]);
                    }
                }
            }
        }

        return graph;
    }

    private String topologicalSortWithCycleDetection(Map<Character, Set<Character>> graph) {
        List<Character> characterSet = new ArrayList<>(graph.size() * 2); // let's give it some default capacity,
                                                                          // iteration
                                                                          // order matters
        StringBuilder alienOrderSBReversed = new StringBuilder(graph.size() * 2);
        Set<Character> visited = new HashSet<>(graph.size() * 2);

        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            if (!visitKey(entry.getKey(), characterSet, visited, graph, alienOrderSBReversed)) {
                return ""; // we want to short circuit here because one of the operations found an issue.
            }
            while (characterSet.size() > 0) {
                char exploredChar = characterSet.remove(characterSet.size() - 1);
                alienOrderSBReversed.append(exploredChar);
            }
        }

        return alienOrderSBReversed.reverse().toString();
    }

    private boolean visitKey(Character c, List<Character> currentlyExploredCharacterStack, Set<Character> visited,
            Map<Character, Set<Character>> graph, StringBuilder sb) {
        if (currentlyExploredCharacterStack.contains(c)) {
            return false; // we found a cycle
        }
        if (!visited.contains(c)) {
            currentlyExploredCharacterStack.add(c);
            visited.add(c);
            if (graph.containsKey(c) && !visitChildren(graph.getOrDefault(c, new HashSet<>()),
                    currentlyExploredCharacterStack, visited, graph, sb)) {
                return false;
            }
        }

        return true; // We want to return ok even if we do not add any more characters.
    }

    private boolean visitChildren(Set<Character> characters, List<Character> characterSet, Set<Character> visited,
            Map<Character, Set<Character>> graph, StringBuilder sb) {
        for (char c : characters) {
            if (characterSet.contains(c)) {
                return false;
            }
            if (visited.contains(c))
                continue;
            if (!visitKey(c, characterSet, visited, graph, sb)) {
                return false;
            }
        }
        return true;
    }

}