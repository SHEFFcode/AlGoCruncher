class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Number> priorityQueue = new PriorityQueue<>(k);
        List<Integer> result = new ArrayList(k);

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.keySet()) {
            priorityQueue.add(new Number(num, frequencyMap.get(num)));
        }

        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll().num);
        }

        return result;
    }

    private class Number implements Comparable<Number> {
        private int num;
        private int freq;

        private Number(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Number other) {
            return Integer.compare(other.freq, this.freq);
        }
    }
}

/**
 * Better solution O(n)
 */

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fm = new HashMap<>(nums.length);
        List<Integer>[] f = new List[nums.length + 1];
        List<Integer> res = new ArrayList<>(k);

        for (int num : nums) {
            fm.put(num, fm.getOrDefault(num, 0) + 1);
        }

        for (int key : fm.keySet()) {
            int freq = fm.get(key);
            if (f[freq] == null) {
                f[freq] = new ArrayList<>();
            }
            f[freq].add(key);
        }

        for (int i = f.length - 1; i >= 0 && res.size() < k; i--) {
            if (f[i] != null) {
                res.addAll(f[i]);
            }
        }

        return res;
    }
}