class Solution {
    /**
     * @param tasks The tasks that need to be processed by the CPU
     * @param n The cool down interval count between two of the same tasks
     * @return The interval count (including the cool down intervals) to process tasks
     */
    public int leastInterval(char[] tasks, int n) {
        int cycles = 0;
        Map<Character, Integer> taskToFrequencyMap = new HashMap<>(tasks.length); // reasonable default
        PriorityQueue<Integer> mostFrequentTaskQ = new PriorityQueue<>(tasks.length, Collections.reverseOrder()); // we will use a reasonable size and reverse order to get max heap instead of min heap

        for (char task : tasks) {
            taskToFrequencyMap.merge(task, 1, (oldVal, newVal) -> oldVal + 1);
        }
        
        mostFrequentTaskQ.addAll(taskToFrequencyMap.values());
        

        while (!mostFrequentTaskQ.isEmpty()) {
            List<Integer> tasksProcessed = new ArrayList<>(n + 1); // we can have at most n + 1 tasks here
            for (int i = 0; i < n + 1; i++) { // we should only do n + 1 tasks before doing most frequent task again
                if (!mostFrequentTaskQ.isEmpty()) { // we can only remove unique tasks till q is empty
                    tasksProcessed.add(mostFrequentTaskQ.poll()); // let's add processed tasks to our list
                }
            }

            tasksProcessed.forEach(task -> {
                if (--task > 0) { // we only want unfinished tasks back in the queue
                    mostFrequentTaskQ.add(task);
                }
            });

            // since we are processing these tasks n + 1 at a time (to be most efficient with least non productive idle time)
            /**
             * If the q is empty, we will just process however many tasks we have added to the tasks to process list.
             * If the q is not empty, we will have to wait the full n + 1 cooloff time regardless of how many
             * items we have been able to process this round.
             */
            cycles += mostFrequentTaskQ.isEmpty() ? tasksProcessed.size() : n + 1;
        }

        return cycles; // once we are done with the queue, we have finished all the tasks.
    }
}

/**
 *  Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

    "A" "A" "A" "B" "B" "B"
     i

    Step 1: Get the frequency map of the all the stasks
    taskToFrequencyMap = {
        "A": 3,
        "B": 3
    }

    Step 2: The insight is that the cool down can either be the idle cool down, where we just wait
    or we can process another task while we are cooling down (productive cool down).
    So what we will do is create a priority queue, where we will try to process as many tasks
    as possible from the most frequent task list, so that we can keep the idle period between them
    as productive as possible.  They can sort of feed the idle period for each other, leaving the
    least common tasks to the end where they can run once without the non productive cooldown.
    For this we will use a max heap represented with priority heap in reverse order.

    Note: heap allows duplicate numbers, so we will only put in the integers, without the task names
    for now.

    Step 3: Loop over the length of n + 1 (which is doing a task and waiting n period cooldown and
    do that many tasks from the heap, with removing of those tasks from the heap because we can 
    only take unique tasks from the heap.
 */