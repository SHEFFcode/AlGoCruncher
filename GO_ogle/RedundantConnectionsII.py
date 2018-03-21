class Solution(object):
    def union(self, a, b):
        self.uf[self.find(b)] = self.find(a)

    def find(self, a):
        while self.uf[a] != a:
            a = self.uf[a]
        return a
    
    def detectCycle(self, V):
        self.visited[V] = True
        for i in range(len(self.adjList[V])):
            nextV = self.adjList[V][i]
            if self.visited[nextV]:
                return (V, nextV)
            ret = self.detectCycle(nextV)
            if ret[0]:
                return ret
        return (None, None)
    
    def findRedundantDirectedConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        self.uf = [0] + [i + 1 for i in range(len(edges))]
        self.adjList = [[] for i in range(len(edges) + 1)]      # Adjancency List
        hasFather = [False] * (len(edges) + 1)                  # Whether a vertex has already got a parent
        criticalEdge = None

        for i, edge in enumerate(edges):
            w, v = edge[0], edge[1]
            self.adjList[w].append(v)
            if hasFather[v]:
                criticalEdge = (w, v)                           # If a vertex has more than one parent, record the last edge
            hasFather[v] = True
            if self.find(w) == self.find(v):                    # If a loop is found, record the edge that occurs last
                cycleEdge = (w, v)
            self.union(w, v)

        if not criticalEdge:                                    # Case 1
            return cycleEdge
        self.visited = [False] * (len(edges) + 1)
        (w, v) = self.detectCycle(criticalEdge[1])
        return (w, v) if w else criticalEdge                    # Case 2 and 3

solution = Solution()
solution.findRedundantDirectedConnection([[1,2],[1,3],[2,3]])