/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        // We sort intervals based on starting items
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        /**
         * Note we are not doing concurrent modificaiton here, not for (Interval interval : intervals)
         * So we are safe to add are remove items to this list
         * The only thing to take note here is that this list has to be a LinkedList to be efficient, if it is not
         * This approach will not be as efficient.
         */
        for (int i = 1; i < intervals.size(); i++) {
            // If previous interval's end is bigger or equal to current intervals start.
            // These intervals are mergeable.
            if (intervals.get(i - 1).end >= intervals.get(i).start) {
                // We add a new interval at position i - 1,
                intervals.add(
                    i - 1, // index
                    new Interval ( // a new interval that 
                        intervals.get(i - 1).start, // starts at pervious intervals start
                        Math.max(intervals.get(i - 1).end, intervals.get(i).end) // ends at pervious intervals end or this intervals end, depending on which is bigger
                    )
                );

                /**
                 * List(interval1, interval2, interval3) => starting point
                 *        i - 1       i
                 * List(intervalNew, interval1, interval2, interval3) => after insertion
                 *      i - 1            i
                 * List(intervalNew, interval2, interval3) => after first remove
                 *         i - 1             i
                 * List(intervalNew, itnerval3) => after second remove
                 *       i - 1          i
                 * List(intervalNew, interval3) => after i decrement
                 *           i
                 */                      
                intervals.remove(i); // Remove current list
                intervals.remove(i--); // remove what would be now a previous list, and decrement i by 1.
            }
        }
        return intervals;
    }
}


/**
 * Another Approach
 */

 class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        /**
         * So the intuition here is that for any start and end, eventually it will literally be intervals where 
         * we can combine a sorted start and a sorted end as much as possible
         */
        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 1; i <= n; i++) {
            if (i != n && (start[i] <= end[i - 1])) {
                start[i] = start[i - 1]; // basically if we have a range where start is less then or equal to end, we want to make it's start same
                // as pervious start to get that range.
            } else {
                // we the start is bigger then end, we have a new interval
                // we will use previous start and previous end to create that interval because of the modifications we did above ^
                list.add(new Interval(start[i - 1], end[i - 1]));
            }
        }
        return list;
    }
}