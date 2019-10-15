import java.awt.Point;

class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
    int startingStop = S, destinationStop = T;

    if (startingStop == destinationStop) { // we start and end at the same stop
      return 0;
    }

    // so we will think of a route as a vertex, and bus stops as edges that eminate from each vertex
    int numRoutes = routes.length;

    List<List<Integer>> routeMapping = new ArrayList(); // instead of dealing with raw arrays, it's easier to deal with a List

    for (int i = 0; i < numRoutes; ++i) {
      Arrays.sort(routes[i]); // sorting helps us find out if we overshot our destination or not.
      routeMapping.add(new ArrayList()); // we are not adding the sorted arr here, but are adding an empty one for later
    }

    Set<Integer> visited = new HashSet(); // whether we have visited this edge (bus stop) before
    Set<Integer> routesWithDesiredDestination = new HashSet(); // these are the target stops
    Queue<Point> q = new ArrayDeque(); // ArrayDequeue is the most efficient Queue implementation

    // Build the graph.  Two buses are connected if
    // they share at least one bus stop.
    // We will merge the bus route arrayLists here, that way we can figure out how to get to the stop by combining routes.
    for (int oneRoute = 0; oneRoute < numRoutes; ++oneRoute)
      for (int anotherRoute = oneRoute + 1; anotherRoute < numRoutes; ++anotherRoute)
        if (routesIntersect(routes[oneRoute], routes[anotherRoute])) {
          routeMapping.get(oneRoute).add(anotherRoute); // We will map these routes as having ability to transfer between each other
          routeMapping.get(anotherRoute).add(oneRoute);
        }

    // Initialize seen, queue, targets.
    // seen represents whether a node has ever been enqueued to queue.
    // queue handles our breadth first search.
    // targets is the set of goal states we have.
    for (int routeNum = 0; routeNum < numRoutes; ++routeNum) {
      if (Arrays.binarySearch(routes[routeNum], S) >= 0) { // if this route has the starting point, add it ot the seen array and add a point to the queue
        visited.add(routeNum); // let's mark this route num as visited since we will begin here in the code below where we iterate through the q
        q.offer(new Point(routeNum, 0)); // pop the route with the starting bus stop into the queue.
      }

      if (Arrays.binarySearch(routes[routeNum], T) >= 0) // if this route has the destination, add it to the targets HashSet
        routesWithDesiredDestination.add(routeNum);
    }

    while (!q.isEmpty()) { // let's try starting at every starting point that we have found
      Point routeAndTransferCount = q.poll();
      /**
       * We need to keep transfer counts on a point class so that we would not have to do Choose, explore unchoose
       * but can refer to transfer count directly based on the point
       */
      int routeNum = routeAndTransferCount.x, transferCount = routeAndTransferCount.y;
      if (routesWithDesiredDestination.contains(routeNum))
        return transferCount + 1;
      for (Integer possibleTransferRouteNumber : routeMapping.get(routeNum)) {
        if (!visited.contains(possibleTransferRouteNumber)) {
          visited.add(possibleTransferRouteNumber);
          q.offer(new Point(possibleTransferRouteNumber, transferCount + 1)); // we will keep track of possible transfer counts.
        }
      }
    }

    return -1;
  }

  public boolean routesIntersect(int[] oneRoutesStops, int[] anotherRoutesStops) {
    int i = 0, j = 0;
    while (i < oneRoutesStops.length && j < anotherRoutesStops.length) {
      if (oneRoutesStops[i] == anotherRoutesStops[j])
        return true;
      if (oneRoutesStops[i] < anotherRoutesStops[j])
        i++;
      else
        j++;
    }
    return false;
  }
}

/**
 * Example:
    Input: 
    routes = [
      i [1, 2, 7],
               j
       [3, 6, 7]

    ]

    transferPoints = {
      0: [[7, 1]] // from bus index, to tuple of station number to bus index
    }

    S = 1
    T = 6
    Output: 2
    Explanation: 
    The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.


    We think like each bus is a vertex and each route is the edge.

    //We keep a greedy list of number of busses needed to reach destination, and a greedy list of transfer points

    int numBusses = 0

    // First, let's find buses that have our starting point
    // Once we found a bus route that has our starting point, let's increment number of busses
    numBusses++;

    // If we see a transfer point and we have not overshot our destination, we have a decision to make, we can either transfer or stay on the bus.
    // If we did over shoot our destination, we have to make the transfer, and see if we can still get to the final destination (which can be both forward or backward on the route.)

    CHOOSE (to transfer)
    EXPLORE (see if u can reach the destination)
    UNCHOOSE (stay on the bus if u have not overshot the destination or return false if u have overshot the destination)



 */
