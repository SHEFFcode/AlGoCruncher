/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
  let graph = [];
  let visited = [];

  for (let i = 0; i < numCourses; i++) {
    graph.push([]);
    visited.push(0);
  }

  prerequisites.forEach((coursePair, index) => {
    graph[coursePair[0]].push(coursePair[1]);
  });

  for (let i = 0; i < numCourses; i++) {
    if (!traverseGraph(i, graph, visited)) {
      return false;
    }
  }

  return true;
};

function traverseGraph(i, graph, visited) {
  if (visited[i] === -1) {  
    return false;  // we came back to a course that we have visted before, we have a course cycle
  }

  if (visited[i] === 1) {
    return true;
  }

  visited[i] = -1;  // mark as visited

  for (let j of graph[i]) {  // iterate through every course that relies on this course, and traverse them
    if (!traverseGraph(j, graph, visited)) {
      return false;
    }
  }

  visited[i] = 1;

  return true; // once you have traversed through all the items, and did not find a loop, return true.
}

canFinish(2, [[1,0]])

/*
[
  [1, 2],
  [3, 4]
]
*/

/*
G: Number number of courses, Number[][] prerequisites
O: Boolean can the courses be finished
T: Any
S: Any

Ex:
2, [[1,0]] => to enroll into 1, you have to finish 0, so 1 > 0, so this is possible

Ex2:
2, [[1,0],[0,1]] => first course can be taken because 1 > 0, but the second course cannot be taken because 0 !> 1, so false

        1 -> 0
        1 -> 0 -> 1


 */