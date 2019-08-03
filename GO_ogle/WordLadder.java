import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    Map<String, Boolean> visited = new HashMap<>(wordList.size());
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int shortestSteps = 1;

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        String cWord = q.poll();
        if (cWord.equals(endWord)) {
          return shortestSteps;
        }
        for (String dicWord : wordList) {
          if (isOffByOne(cWord.toCharArray(), dicWord.toCharArray()) && !visited.containsKey(dicWord)) {
            q.offer(dicWord);
            visited.put(dicWord, true);
          }
        }
      }

      shortestSteps++;
    }

    return 0;
  }

  private boolean isOffByOne(char[] cWord, char[] dicWord) {
    int difference = 0;
    for (int i = 0; i < cWord.length; i++) {
      if (cWord[i] != dicWord[i]) {
        difference++;
      }
      if (difference > 1) {
        return false;
      }
    }

    return difference == 1;
  }
}