class Solution {
  public String alienOrder(String[] words) {
    List<Character> alphabet = new ArrayList<>();
    Map<Character, List<Character>> graph = buildGraph(words, alphabet);

    populateGraph(words, graph);

    Deque<Character> stack = new ArrayDeque<>();
    boolean[] letterSeen = new boolean[26]; // whether or not this letter has been seen

    for (char c : alphabet) {
      if (letterSeen[c - 'a']) {
        continue;
      }
      if (!performTopologicalSort(graph, c, stack, letterSeen, new boolean[26])) {
        return ""; // cycle found!
      }
    }
    if (stack.size() != alphabet.size()) {
      return ""; // we do not have enough data to formulate lexographic order
    }

    return stack.stream().map(String::valueOf).collect(Collectors.joining(""));

  }

  private boolean performTopologicalSort(Map<Character, List<Character>> graph, char letter, Deque<Character> stack,
      boolean[] letterSeen, boolean[] inRecursion) {
    letterSeen[letter - 'a'] = true;
    inRecursion[letter - 'a'] = true;

    for (char neighbor : graph.get(letter)) {
      if (inRecursion[neighbor - 'a']) {
        return false; // we found a cycle
      }
      if (letterSeen[neighbor - 'a']) {
        continue; // we already explored.
      }

      performTopologicalSort(graph, neighbor, stack, letterSeen, inRecursion);
    }

    stack.push(letter);
    inRecursion[letter - 'a'] = false;
    return true;
  }

  private void populateGraph(String[] words, Map<Character, List<Character>> graph) {
    for (int i = 0; i < words.length - 1; i++) { // we do less one, since we will be looking at words in pairs
      String wordAbove = words[i];
      String wordBelow = words[i + 1];

      for (int j = 0; j < Math.min(wordAbove.length(), wordBelow.length()); j++) {
        if (wordAbove.charAt(j) == wordBelow.charAt(j)) {
          continue; // we cannot get any lexographical order here
        }

        char letterBefore = wordAbove.charAt(j);
        char letterAfter = wordBelow.charAt(j);

        graph.get(letterBefore).add(letterAfter);

        break; // we have to break out of the loop here, b/c further indexing does not provide
        // lexographical order
      }
    }
  }

  private Map<Character, List<Character>> buildGraph(String[] words, List<Character> alphabet) {
    Map<Character, List<Character>> graph = new HashMap<>();

    for (String word : words) {
      for (char c : word.toCharArray()) {
        if (graph.containsKey(c)) {
          continue;
        }
        graph.put(c, new ArrayList<>());
        alphabet.add(c);
      }
    }

    return graph;
  }
}