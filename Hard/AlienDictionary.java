package com.company;

import java.util.*;

class Solution {
  public String alienOrder(String[] words) {
    Map<Character, ArrayList<Character>> graph = buildGraph(words);

    LinkedHashSet<Character> characterSet = new LinkedHashSet<>();
    StringBuilder alienOrderStringBuilder = new StringBuilder();
    Set<Character> visited = new HashSet<>();

    return topologicalSortWithCycleDetection(graph, characterSet, alienOrderStringBuilder, visited);
  }

  private HashMap<Character, ArrayList<Character>> buildGraph(String[] words) {
    HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

    for (int i = 0; i < words.length - 1; i++) {
      char[] firstWord = words[i].toCharArray();
      char[] secondWord = words[i + 1].toCharArray();
      int length = Math.min(firstWord.length, secondWord.length);

      for (int j = 0; j < length; j++) {
        if (firstWord[j] != secondWord[j]) {
          if (!graph.containsKey(firstWord[j])) {
            ArrayList<Character> followers = new ArrayList<>();
            followers.add(secondWord[j]);
            graph.put(firstWord[j], followers);
          } else {
            graph.get(firstWord[j]).add(secondWord[j]);
          }
        }
      }
    }

    return graph;
  }

  private String topologicalSortWithCycleDetection(Map<Character, ArrayList<Character>> graph,
      LinkedHashSet<Character> characterSet, StringBuilder alienOrderStringBuilder, Set<Character> visited) {
    for (Map.Entry<Character, ArrayList<Character>> entry : graph.entrySet()) {
      if (characterSet.contains(entry.getKey())) {
        return ""; // we have a circular reference.
      } else if (!visited.contains(entry.getKey())) {
        characterSet.add(entry.getKey());
        visited.add(entry.getKey());
        for (char character : entry.getValue()) {
          if (characterSet.contains(entry.getKey())) {
            return "";
          } else if (!visited.contains(character)) {
            characterSet.add(character);
            visited.add(character);
          }

        }
        // we visited all the children, so lets populate the stringbilder
        characterSet.remove(entry.getKey());
        alienOrderStringBuilder.append(entry.getKey());
      }
    }

    for (char character : characterSet) {

    }
  }

}