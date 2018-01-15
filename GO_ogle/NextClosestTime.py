from datetime import *

class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        unique_digits = set(time)  # set of all unique characters in the string
        while True:
            parsed_date_time = datetime.strptime(time, '%H:%M')  # parse time from string in format Hours Minutes
            one_minute_increment = timedelta(minutes=1)  # get a timedelta in the amount of 1 minutes
            possible_closest_time = parsed_date_time + one_minute_increment  # create a new datetime one min more
            time = possible_closest_time.strftime('%H:%M')  # return a string representing the date format H:M
            if set(time) <= unique_digits:
                return time

solution = Solution()
print(solution.nextClosestTime("12:9"))