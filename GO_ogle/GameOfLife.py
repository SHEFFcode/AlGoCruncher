class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                live_cell_count = 0

                live_cell_count += 1 if i - 1 > -1 and j - 1 > -1 and (board[i - 1][j - 1] == 1 or (type(board[i - 1][j - 1]) == str and board[i - 1][j - 1].split(',')[0] == '1')) else 0
                live_cell_count += 1 if i - 1 > -1 and (board[i - 1][j] == 1 or (type( board[i - 1][j]) == str and  board[i - 1][j].split(',')[0] == '1')) else 0
                live_cell_count += 1 if i - 1 > -1 and j + 1 < len(board[0]) and (board[i - 1][j + 1] == 1 or (type(board[i - 1][j + 1]) == str and  board[i - 1][j + 1].split(',')[0] == '1')) else 0

                live_cell_count += 1 if j - 1 > -1 and (board[i][j - 1] == 1 or (type(board[i][j - 1]) == str and  board[i][j - 1].split(',')[0] == '1')) else 0
                live_cell_count += 1 if j + 1 < len(board[0]) and (board[i][j + 1] == 1 or (type(board[i][j + 1]) == str and board[i][j + 1].split(',')[0] == '1')) else 0

                live_cell_count += 1 if i + 1 < len(board) and j - 1 > -1 and (board[i + 1][j - 1] == 1 or (type(board[i + 1][j - 1]) == str and board[i + 1][j - 1].split(',')[0] == '1')) else 0
                live_cell_count += 1 if i + 1 < len(board) and (board[i + 1][j] == 1 or (type(board[i + 1][j]) == str and board[i + 1][j].split(',')[0] == '1')) else 0
                live_cell_count += 1 if i + 1 < len(board) and j + 1 < len(board[0]) and (board[i + 1][j + 1] == 1 or (type(board[i + 1][j + 1]) == str and board[i + 1][j + 1].split(',')[0] == '1')) else 0

                board[i][j] = '1,' + str(live_cell_count) if board[i][j] == 1 else '0,' + str(live_cell_count)

        for i in range(len(board)):
            for j in range(len(board[0])):
                cell = board[i][j].split(',')
                if cell[0] == '1' and int(cell[1]) < 2:
                    board[i][j] = 0
                elif cell[0] == '1' and 1 < int(cell[1]) < 4:
                    board[i][j] = 1
                elif cell[0] == '1' and int(cell[1]) > 3:
                    board[i][j] = 0
                elif cell[0] == '0' and int(cell[1]) == 3:
                    board[i][j] = 1
                else:
                    board[i][j] = int(cell[0])

        x = 0


solution = Solution()
solution.gameOfLife(
    [[1, 0, 0, 0, 1, 0, 0],
     [0, 0, 1, 0, 0, 0, 1],
     [0, 0, 0, 0, 0, 1, 0],
     [0, 1, 0, 1, 0, 0, 0],
     [0, 0, 0, 0, 1, 0, 0]]
)
