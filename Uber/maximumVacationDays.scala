object Solution {
  private type IntMatrix = Array[Array[Int]]
  private val CONNECTED = 1
  def maxVacationDays(
      flights: Array[Array[Int]],
      days: Array[Array[Int]]
  ): Int = {
    if (days.isEmpty || flights.isEmpty) return 0
    val numWeeks = days(0).length // will represent weeks
    val cityCount = days.length // will represent cities where we can travel to
    val dp =
      Array.ofDim[Int](days.length, days(0).length + 1) // for the 0 0th week
    for (cWeek <- numWeeks - 1 to 0 by -1) {
      for (cCity <- 0 until cityCount) {
        // current vacation days in this city, plus vacation days in this city from one week in the future
        dp(cCity)(cWeek) = days(cCity)(cWeek) + dp(cCity)(cWeek + 1)
        checkConnectedCities(cCity, cWeek, dp, days, flights)
      }
    }

    dp(0)(0) // best number of vacation days in the 0th day 0th city
  }

  private def checkConnectedCities(
      cCity: Int,
      cWeek: Int,
      dp: IntMatrix,
      vDays: IntMatrix,
      flights: IntMatrix
  ): Unit = {
    for (destCity <- 0 until vDays.length) {
      if (flights(cCity)(destCity) == CONNECTED) {
        // max of what we computed above for the current city + what we can get from using this destination city instead
        dp(cCity)(cWeek) =
          dp(cCity)(cWeek) max vDays(destCity)(cWeek) + dp(destCity)(cWeek + 1)
      }
    }
  }
}

/*
G: flights: Array[Array[Int]], days: Array[Array[Int]]
O: maxVacationDays: Int
T: O(flights ^ 2 * days) (nested for look in check connected cities)
S: O(flights * days)

Notes:
  - You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on Monday.
  - The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical),
    called flights representing the airline status from the city i to the city j.
    If there is no flight from the city i to the city j, flights[i][j] = 0;
    Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.
  - You totally have K weeks (each week has 7 days) to travel.
    You can only take flights at most once per day and can only take flights on each week's Monday morning.
    Since flight time is so short, we don't consider the impact of flight time.
  - For each city, you can only have restricted vacation days in different weeks,
    given an N*K matrix called days representing this relationship.
    For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j.
  - N and K are positive integers, which are in the range of [1, 100].
  - In the matrix flights, all the values are integers in the range of [0, 1].
  - In the matrix days, all the values are integers in the range [0, 7].
  - You could stay at a city beyond the number of vacation days, but you should work on the extra days, which won't be counted as vacation days.
  - If you fly from the city A to the city B and take the vacation on that day,
    the deduction towards vacation days will count towards the vacation days of city B in that week.
    We don't consider the impact of flight hours towards the calculation of vacation days.


Ex:
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
Output: 12
Explanation:
Ans = 6 + 3 + 3 = 12.

One of the best strategies is:
1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day.
(Although you start at city 0, we could also fly to and start at other cities since it is Monday.)
2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
3rd week : stay at city 2, and play 3 days and work 4 days.

Ex2:
Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
Output: 3
Explanation:
Ans = 1 + 1 + 1 = 3.

Since there is no flights enable you to move to another city, you have to stay at city 0 for the whole 3 weeks.
For each week, you only have one day to play and six days to work.
So the maximum number of vacation days is 3.

Ex3:
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
Output: 21
Explanation:
Ans = 7 + 7 + 7 = 21

One of the best strategies is:
1st week : stay at city 0, and play 7 days.
2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
3rd week : fly from city 1 to city 2 on Monday, and play 7 days.

 */
