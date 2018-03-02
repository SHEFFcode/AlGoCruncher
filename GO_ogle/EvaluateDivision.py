import collections

class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        graph = dict()

        def build_graph(equations, values):
            def add_edge(from_vertex, to_vertex, value):
                if from_vertex in graph:
                    graph[from_vertex].append((to_vertex, value))
                else:
                    graph[from_vertex] = [(to_vertex, value)]
            for vertecies, value in zip(equations, values):  # vertecies plural because equations are are List[List[str]]
                from_vertex, to_vertex = vertecies  # we destructure the vertecies into individual vertex
                add_edge(from_vertex, to_vertex, value)  # bi-directional graph here
                add_edge(to_vertex, from_vertex, 1 / value)  # bi-directional graph here

        def find_path(query):
            from_vertex, to_vertex = query
            if from_vertex not in graph or to_vertex not in graph:
                return -1.0  # this is just from definition and I don't fully agree that x/x is not == 1 all the time

            q = collections.deque([(from_vertex, 1.0)])
            visited = set()

            while q:
                f_v, current_product = q.popleft()
                if f_v == to_vertex:  # we found the node which we were looking for
                    return current_product
                visited.add(f_v)
                for neighbor, value in graph[f_v]:  # we want to check the neighbors to see if they are the ones we are lookign for
                    if neighbor not in visited:  # we haven't checked that neighbor yet
                        q.append((neighbor, current_product * value))

            return -1.0

        build_graph(equations, values)
        return [find_path(q) for q in queries]

solution = Solution()
print(solution.calcEquation([["a", "b"], ["b", "c"]], [2.0, 3.0], [["a", "c"], ["b", "c"], ["a", "e"],["a", "a"], ["x", "x"]]))