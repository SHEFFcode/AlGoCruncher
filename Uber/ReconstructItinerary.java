class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> originToQueueOfDestinationMap = new HashMap<>();
        List<String> itinerary = new LinkedList<>(); // ArrayDeque is the fastest linked list implementation

        for (List<String> ticket : tickets) {
            originToQueueOfDestinationMap.putIfAbsent(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder())); // ArrayDeque is the fastest queue implementation

            Queue<String> destinationsFromOrigin = originToQueueOfDestinationMap.get(ticket.get(0));
            destinationsFromOrigin.add(ticket.get(1));
        }

        topologicallySortDestinations("JFK", originToQueueOfDestinationMap, itinerary);
        return itinerary;
    }

    private void topologicallySortDestinations(String departure,
            Map<String, Queue<String>> originToQueueOfDestinationMap, List<String> itinerary) {
        Queue<String> destinations = originToQueueOfDestinationMap.get(departure); // destinations will be null, if we are on the last departure

        while (destinations != null && !destinations.isEmpty()) { // if there is no hop from here, we can finally add to itinerary
            topologicallySortDestinations(destinations.poll(), originToQueueOfDestinationMap, itinerary);
        }

        itinerary.add(0, departure);
    }
}

/**
 *  Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]



    [
      i ["MUC", "LHR"],
          
       ["JFK", "MUC"],
        j
       ["SFO", "SJC"],

       ["LHR", "SFO"]

    ]

    {
        "JFK": ["MUC"],
        "MUC": ["LHR"],
        "LHR": ["SFO"],
        "SFO": ["SJC"]
    }

    1) We will iterate over the 2d matrix looking for "JFK", since every trip must begin with JFK, this would be at arr[i][0] index
    2) Once we find it, we will look for what the next destination at index arr[i][1] to be at arr[i][0] somewhere else
    3) To optimize we can create a cache of String to Index in array
    4) We will add each successive location to result

 */