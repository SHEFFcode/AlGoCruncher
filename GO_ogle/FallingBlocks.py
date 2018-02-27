class Solution:
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        absolute_max = list()  # contains absolute max at every iteration
        board = dict()  # contains a sparse representation of the board
        for start_corner, side_length in positions:
            left, right = start_corner, start_corner + side_length - 1  # we want to do -1 because corners don't 'stick'
            # compare to see if this block overlaps with L/R boundaries of existing blocks
            nearby = [key for key in board.keys() if not (key[1] < left or key[0] > right)]
            # finds height of block based on board of existing and overlapping blocks
            if len(nearby) > 0:
                current_height = max(board[key] for key in nearby) + side_length  # height so far, + height of c_block
            else:
                current_height = side_length
            # update the board for left and right boundaries
            board[(left, right)] = current_height
            # add height to absolute_max
            max_height_so_far = absolute_max[-1] if absolute_max else 0
            absolute_max.append(max(current_height, max_height_so_far))
        return absolute_max

solution = Solution()
print(solution.fallingSquares([[4, 6], [4, 2], [4, 3]]))
