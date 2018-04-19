  /**
   * @param {number} numCourses
   * @param {number[][]} prerequisites
   * @return {number[]}
   */
  var findOrder = function (numCourses, prerequisites) {
    prerequisites.sort((a, b) => a[0] - b[0]);
    let graph = {};
    let result = [];

    prerequisites.forEach((prerequisite) => {
      if (prerequisite[1] === 0) {
        graph[0] = [];
      }
      if (!graph.hasOwnProperty(prerequisite[0])) {
        graph[prerequisite[0]] = [prerequisite[1]];
      } else {
        graph[prerequisite[0]].push(prerequisite[1]);
      }
    });

    let unexploredKeys = Object.keys(graph);

    while(unexploredKeys.length > 0) {
      let randomKey = Math.floor(Math.random() * unexploredKeys.length);
      _traverse(graph, randomKey, randomKey, result);
    }

    return result;
  };

  function _traverse(graph, key, index, result) {
    if (graph[key].length === 0) {
      result.push(key);
      graph[index].shift();
    }

    graph[key].forEach((keyItem) => {
      _traverse(graph, keyItem, key, result);
    });
  }