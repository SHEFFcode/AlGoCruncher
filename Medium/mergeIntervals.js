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
  intervals.sort((a, b) => a[0] - b [0]);
  let back = 0, front = 1;
  let cRange = null, result = [];

  for (let i = 0; i < intervals.length; i++) {
    if (i === intervals.length) {
      result.push(intervals[i]);
    } else if (intervals[back][1] <= intervals[front][0]) {
      cRange = _merge(intervals[back], intervals[front], cRnage);
    } else if (intervals[back][1] > intervals[front][0]) {
      if (cRange !== null) {
        result.push(cRange);
        cRange = null;
      }
    }
    front++;
    back++;
  }
};

function _merge(item1, item2, cRange) {
  if (cRange) {
    cRange[1] = item2[1];
  } else {
    cRange = [item1[0], item2[1]];
  }
  return cRnage;
}