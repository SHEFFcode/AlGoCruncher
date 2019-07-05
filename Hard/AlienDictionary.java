package com.company;

import java.util.*;

class Solution {
  public String alienOrder(String[] words) {
    if (!inputValid(words)) {
      return "";
    }
    Map<Character, ArrayList<Character>> graph = buildGraph(words);

    return topologicalSortWithCycleDetection(graph);
  }

  private boolean inputValid(String[] words) {
    return words.length > 1;
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
            ArrayList<Character> children = new ArrayList<>();
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

  private String topologicalSortWithCycleDetection(Map<Character, ArrayList<Character>> graph) {
    List<Character> characterSet = new ArrayList<>(graph.size() * 2); // let's give it some default capacity, iteration
                                                                      // order matters
    StringBuilder alienOrderSBReversed = new StringBuilder(graph.size() * 2);
    Set<Character> visited = new HashSet<>(graph.size() * 2);

    for (Map.Entry<Character, ArrayList<Character>> entry : graph.entrySet()) {
      if (!visitKey(entry.getKey(), characterSet, visited)
          || !visitChildren(entry.getValue(), characterSet, visited, alienOrderSBReversed)) {
        return ""; // we want to short circuit here because one of the operations found an issue.
      }
    }

    return alienOrderSBReversed.reverse().toString();
  }

  private boolean visitKey(Character c, List<Character> characterSet, Set<Character> visited) {
    if (characterSet.contains(c)) {
      return false; // we found a cycle
    }
    if (!visited.contains(c)) {
      characterSet.add(c);
      visited.add(c);
    }

    return true; // We want to return ok even if we do not add any more characters.
  }

  private boolean visitChildren(List<Character> characters, List<Character> characterSet, Set<Character> visited,
      StringBuilder sb) {
    if (characters.isEmpty()) {
      // let's populate the solution
      char exploredChar = characterSet.remove(characterSet.size() - 1);
      sb.append(exploredChar);
    }
    for (char c : characters) {
      if (!visitKey(c, characterSet, visited)) {
        return false;
      }
    }
    return true;
  }

}