/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function (intervals) {
  if (!intervals || intervals.length < 2) {
    return intervals;
  }

  intervals.sort((a, b) => a.end - b.end);
  let result = [];
  let start = intervals[0].start;
  let end = intervals[0].end;

  for (let interval of intervals) {
    if (interval.start <= end) {
      end = Math.max(end, interval.end);
      start = Math.min(start, interval.start);
    } else {
      result.push(new Interval(start, end));
      start = interval.start;
      end = interval.end;
    }
  }

  result.push(new Interval(start, end));
  return result;
};

// merge([[1, 3], [2, 6], [8, 10], [15, 18]]);
merge([[1, 4], [2, 5]]);