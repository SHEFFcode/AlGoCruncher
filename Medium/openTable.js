var jobs = [
  {
    name: 0,
    dependencies: [1,2]
  },{
    name: 1,
    dependencies: [4]
  },{
    name: 2,
    dependencies: []
  },{
    name: 3,
    dependencies: []
  },{
    name: 4,
    dependencies: [2,3]
  }, {
    name: 5,
    dependencies: [4]
  }];

function sortJobs(arr) {
  let graph = {};
  let stack = [];
  let solution = [];
  let brain = {};
  let indexCount = [];

  jobs.forEach((job) => {
    graph[job.name] = job.dependencies;
    indexCount.push(job.name);
  });

  let x = 0;

  while (solution.length < arr.length) {
    let currentIndex = Math.floor(Math.random() * arr.length);
    if (brain[currentIndex]) {
      continue;
    }
    _traverse(graph, stack, solution, arr, currentIndex, brain);
  }

  return solution;
}

function _traverse(graph, stack, solution, arr, currentIndex, brain) {
  if (graph[currentIndex].length === 0) {
    if (!brain[currentIndex]) {
      solution.push(arr[currentIndex]);
      stack.pop();
    }
    brain[currentIndex] = true;
    while(stack.length > 0) {
      graph[stack[stack.length - 1]].shift();
      let index = stack[stack.length - 1];
      _traverse(graph, stack, solution, arr, index, brain)
    }
    
    return;
  }
  for (let i = 0; i < graph[currentIndex].length; i++) {
    if (graph[currentIndex][i]) {
      if (graph[currentIndex][i] in brain) {
        graph[currentIndex].pop();
        continue;
      } else {
        stack.push(graph[currentIndex][i]);
      }
      _traverse(graph, stack, solution, arr, graph[currentIndex][i], brain);
    }
  }
}

console.log(sortJobs(jobs));