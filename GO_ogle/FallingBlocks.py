class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        board = dict()  # the board that will contain left edge information for heights
        absolute_max = list()  # this is the output list, will contain the absolute max for each iteration
        for index, position in enumerate(positions):  # enumerate through positions
            current_max = 0
            for i in range(position[0], position[0] + position[1]):  # check for every spot in the index matrix
                if i in board:
                    current_max = board[i] if board[i] > current_max else current_max
            for i in range(position[0], position[0] + position[1]):
                board[i] = current_max + position[1]
            absolute_max_so_far = absolute_max[-1] if absolute_max else 0
            absolute_max.append(max(current_max + position[1], absolute_max_so_far))
        return absolute_max

solution = Solution()
print(solution.fallingSquares([[4,6],[4,2],[4,3]]))
