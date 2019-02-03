/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


/**
 * [[0, 30],[5, 10],[15, 20]]
 * We need a queue or some sort, we also need to make sure that we sort on start time, which we already did
 * After sorting, we only care bout the end time
 *      *
 * ============================
 * 
 * 
 *  20  Since 20 is bigger then 10 we 10, and since 20 is smaller then 30 we add it. So we get size of 2.
 *  10  since 10 is smaller then 30, we add it to queue
 *  30
 */


class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // We will sort by start time.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> q = new PriorityQueue(intervals.length);
        q.add(intervals[0].end); // we will add the first item, and we know it exists because of the check above ^

        for (int i = 1; i < n; i++) { // we will iterate through all the intervals.
            int start = intervals[i].start; // grab the end value for ease of use.
            int end = intervals[i].end;
            if (start >= (int) q.peek()) { // if we have an end time that is after another end time, we can free up a room
                q.poll(); // free upp a room
                q.add(end); // add the new end time.
            } else {
                q.add(end); // we we cannot free up a room let's add a room
            }
        }

        return q.size(); // return the size of this queue, which is same as number of rooms needed.
    }
}


/**
 * ==================== More Efficient Solution
 */

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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        // We sort both start and end
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int maxNum = 0;

        //if start is less then first end, we increment.
        // if end is bigger or equal to ith start, we increment end.
        for (int i = 0, end = 0; i< intervals.length; i++) {
            if (starts[i] < ends[end]) maxNum++;
            else end++;
        }
        return maxNum; // return max number
    }
}