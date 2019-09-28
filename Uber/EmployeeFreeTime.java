/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> busyTimes = schedule.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<Interval> freeTimes = new ArrayList<>(busyTimes.length); // resonable conservative default
        Collections.sort(busyTimes, (previousInterval, currentInterval) -> {
            if (previousInterval.start != currentInterval.start) { // we will first sort based on start
                return previousInterval.start < currentInterval.start; // sort them ascending
            } else { // if starts are equal, we will sort by end
                return previousInterval.end < previousInterval.end;
            }
        });

        Stack<Interval> intervals = new Stack<Interval>;

        busyTimes.forEach(interval -> {
            if (intervals.isEmpty()) {
                intervals.push(interval);
            } else {
                Interval previous = intervals.pop();
                if (previous.end >= interval.start) { // we have overlapping intervals, let's merge them
                    if (interval.end > previous.end) { // previous interval does not fully overlap current interval, needs merging
                        stack.push(new Interval(previous.start, interval.end));
                    } else { // previous interval encompasses the current interval, we just push it back
                        intervals.push(previous);
                    }
                } else { // we do not have overlapping intervals, let's push it
                    intervals.push(interval);
                }
            }
        });

        busyTimes.clear(); // let's create a new merged busy times intervals
        while (!intervals.isEmpty()) {
            busyTimes.add(intervals.pop()); // the time intervals will now be in reverse order.
        }

        Collections.reverse(busyTimes); // this will reverse a collection

        for (int i = 1; i < busyTimes.size(); i++) {
            if (busyTimes.get(i).start > busyTimes.get(i - 1).end) { // if the current interval start is > then previous interval end, we want to add it to the answer
                freeTimes.add(busyTimes.get(new Interval(busyTimes.get(i - 1).end, busyTimes.get(i).start)));
            }
        }

        return freeTimes;
    }
}

/**
 *  Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    Output: [[3,4]]
    Explanation:
    There are a total of three employees, and all common
    free time intervals would be [-inf, 1], [3, 4], [10, inf].
    We discard any intervals that contain inf as they aren't finite.


    What is we order by ending free time?

    [
        [
            [1,2],
            [5,6]
        ],

        [
            [1,3]
        ],

        [
            [4,10]
        ]
    ]

    we want to flat map through these things somehow, so we get a flattened list of schedules

    [1,2]  [5,6]  [1,3] [4,10]

    We will then sort these puppies based on first start time, and then if they are equal, the end time

    [1,2] [1,3] [4,10] [5,6]

    Now we want to merge the itnervals
    [1,2] [1,3] [4,10] [5,6]
                   i    j

    if previous interval's end is bigger or equal then current intervals start // these puppies are overlapping
        AND if current interval's end is > then previous interval's end // that means that this interval does not necessarily encompass the old one
            we will merge the intervals
        ELSE continue the previous interval overlaps the current one completely, and we do not need to push in the current interval
    ELSE we do for sure encompass the old one
        push the current interval this is a new non overlapping interval

    [1, 3] [4,10]

    WE will now go through this list one by one, and add a new list to the solution, that includes the second[start] - first[end], which is our free time



 */