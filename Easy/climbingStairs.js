/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let stepCount = 0, currentStep = 0, brain = {};
return traverseStairs(0, currentStep, n, brain);
};

let traverseStairs = function (stepCount, currentStep, target, brain) {
if (currentStep === target) {
    return 1;	
} else if (currentStep > target) {
    return 0;
}
if (!brain.hasOwnProperty(`${currentStep}, ${stepCount}`)) {
    brain[`${currentStep}, ${stepCount}`] =  traverseStairs(1, currentStep + 1, target, brain) + traverseStairs(2, currentStep + 2, target, brain);
} 

return brain[`${currentStep}, ${stepCount}`];
}


/*
G: int n how many steps there are in the staircase
O: int how many different ways can you climb the staircase
T: Any
S: Any

Notes:
* Starting to look a little like tree traversal with two verisous ways to get to the top
* We will use a hash to minize repeating subproblems

Edge Cases:
* n === 0 => return 0
* 

Solution:
We will recruse and at each level we will:

Case1: currentStep === n:
return 1;
Case2 currentStep > n:
return 0;
Case3: 
return recursion(1, currentStep, n, brain) + recursion(2, currentStep, n, brain);
*/


