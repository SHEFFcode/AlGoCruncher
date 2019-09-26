import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * @param tasks The tasks that need to be processed by the CPU
     * @param n The cool down interval count between two of the same tasks
     * @return The interval count (including the cool down intervals) to process tasks
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charToFrequencyMap = new HashMap<>(tasks.length); // reasonable default
        int cycles = 0;
        for (char task : tasks) {
            charToFrequencyMap.merge(task, 1, Integer::sum);
        }

        Set<Character> keys = charToFrequencyMap.keySet();
        int mapSize = charToFrequencyMap.size();

        while (!(mapSize <= 0)) { // danger zone, make sure we get to empty here
            for (char key : keys) {
                if (charToFrequencyMap.get(key) > 0) { // if the key is > 0, we can decrement the occurance count
                    charToFrequencyMap.merge(key, 0, (oldVal, newVal) -> oldVal - 1);
                    if (charToFrequencyMap.get(key) == 0) { // if we are at 0, we can reduce the map size
                        mapSize--;
                        if (mapSize == 0) {
                            break;
                        }
                        charToFrequencyMap.put(key, -1);
                    } else { // if we are not at 0, we can increase the # of cycles taken to do the problem.
                        cycles++;
                    }
                }

            }

            cycles += n;
        }

        return cycles;
    }
}

/**
 *  Input: tasks = ["A","A","A","B","B","B"], n = 2
                                         *
    Output: 8
    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

    cycles = 0

    keyToFrequencyMap = {
        "A": 3,
        "B": 3
    }

    Map.Keys() = ["A", "B"]

    while (!keyToFrequencyMap.isEmpty()) {
        keys.forEach(key -> {
            map.merge(key, 0, (oldVal, newVal) -> oldVal - 1);
            if (map.get(key) == 0) {
                map.remove(key); // this will make map empty
            }
        })
        cycles = n + 1;
    }

    return cycles;

    We will now iterate through the keys here, and keep decrementing them till we get to zero0

 */