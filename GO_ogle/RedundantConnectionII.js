function union(unionFind, a, b) {
  unionFind[find(b)] = find(a);
}

function find(unionFind, a) {
  while (unionFind[a] !== a) {
    a = unionFind[a];
  }
  return a;
}

let detectCycle = function (V, visited, adjacencyList) {
  visited[V] = true;
  adjacencyList.forEach((item, i) => {
    let nextV = adjacencyList[V][i];
    if (visited[nextV]) {
      return [V, nextV];
    }
    let ret = detectCycle(nextV);

    if (ret[0]) {
      return ret;
    }
  }); 
  return (null, null);
}


/**
 * @param {number[][]} edges
 * @return {number[]}
 */
var findRedundantDirectedConnection = function(edges) {
  let unionFind = [0];
  let adjacencyList = [[]];
  let hasParent = [false];
  let criticalEdge = null;
  let cycleEdge = null;
  
  edges.forEach((edge, index, edges) => {
    unionFind.push(idnex + 1);
    adjacencyList.push([]);
    hasParent.push(false);
  });

  edges.forEach((edge, index, edges) => {
    let w = edge[0], v = edge[1];
    adjacencyList[w].push(v);
    if (hasParent[v]) {
      criticalEdge = [w, v];
    }
    hasParent[v] = true;
    if (find(unionFind, w) === find(unionFind, v)) {
      cycleEdge = [w, v];
    }
    union(unionFind, w, v);
  });

  if (!criticalEdge) {
    return cycleEdge
  }

  let visited = new Array(edges.length + 1);
  [w, v] = detectCycle(criticalEdge[1], visited, adjacencyList);
  return w ? [w, v] : criticalEdge;
};