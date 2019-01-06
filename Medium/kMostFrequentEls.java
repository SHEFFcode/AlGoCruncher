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