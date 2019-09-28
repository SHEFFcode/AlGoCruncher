class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // Get total number of job intervals
        int total = 0;
        for (List<Interval> jobs : schedule)
            total += jobs.size();

        // Add each start and end to sorted lists respectively
        int[] starts = new int[total];
        int[] ends = new int[total];
        int i = 0;
        for (List<Interval> jobs : schedule) {
            for (Interval job : jobs) {
                starts[i] = job.start;
                ends[i] = job.end;
                i++;
            }
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        // Find each gap (free time) between job intervals
        // i.e. whenever a start is disconnected from previous end
        List<Interval> ans = new ArrayList<>();
        for (i = 1; i < total; i++) {
            if (starts[i] > ends[i - 1]) {
                ans.add(new Interval(ends[i - 1], starts[i]));
            }
        }
        return ans;
    }
}