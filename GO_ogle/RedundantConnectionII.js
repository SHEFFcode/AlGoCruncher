class ReduntantConnection {
  constructor() {
    this.unionFind = [0];
    this.adjList = [[]];
  }

  static _union() {

  }

  static _find() {
    
  }

  static _detectCycle() {

  }

  static findReduntantConnection(edges) {
    let hasFather = [false];
    let criticalEdge = null;
    edges.forEach((edge, index, array) => {
      this.unionFind.push(index + 1);
      this.adjList.push([]);
      hasFather.push(false);
    });



  }

}