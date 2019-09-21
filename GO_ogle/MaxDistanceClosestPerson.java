class Solution {
    public int maxDistToClosest(int[] seats) {
        int firstSeatIndex = -1, nextSeatIndex = -1;
        int maxDistance = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (firstSeatIndex < 0) {
                    firstSeatIndex = i;
                    maxDistance = Math.max(maxDistance, firstSeatIndex - 0);
                } else {
                    nextSeatIndex = i;
                    maxDistance = Math.max(maxDistance, (nextSeatIndex - firstSeatIndex) / 2); // let's do some math
                    firstSeatIndex = i; // let's make the second seatIndex the first seatIndex
                }
            }
        }

        maxDistance = Math.max(maxDistance, (seats.length - 1 - Math.max(nextSeatIndex, firstSeatIndex))); // we don't need to divide by 2 here, but we do need to adjust for 0 based array

        return maxDistance;
    }
}

/**
 * Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.


    1 0 0 0 1 0 1
    i
            j

    int i;
    int j;
    int firstSeatIndex = arr.indexOf(1); // this will give us the first index
    int longestDistance = 0;

    for (firstSeatIndex, arr.length) {
        if (arr[i] == 1) {
            longestDistance = math.max(longestDistance, (i - firstSeatIndex) / 2)
            firstSeatIndex = i; // let's move that first index forward and keep looking
        }

    }

 */