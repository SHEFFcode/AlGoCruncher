class HistogramCalculator {
  constructor() {

  }

  calculateLargestRectangleArea(heights) {
    let indexStack = [],
    area = 0,
    maxArea = 0,
    topIndex = 0,
    topValue = 0;

    for (let i = 0; i <= heights.length; i++) {
      if (!(indexStack.length === 0 || heights[i] > heights[indexStack[indexStack.length - 1]])) {
        while (indexStack.length > 0 && (heights[i] < heights[indexStack[indexStack.length - 1]] || i === heights.length)) {
          topIndex = indexStack.pop();
          topValue = heights[topIndex];
          let multiplier = indexStack.length > 0 ? i - indexStack[indexStack.length - 1] - 1 : i;
          area = topValue * (multiplier);
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }   

      if (i < heights.length) {
        indexStack.push(i);
      }
    }

    return maxArea;
  }
}


/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let histogramCalculator = new HistogramCalculator();
    return histogramCalculator.calculateLargestRectangleArea(heights);
};

console.log(largestRectangleArea([2,1,5,6,2,3]));