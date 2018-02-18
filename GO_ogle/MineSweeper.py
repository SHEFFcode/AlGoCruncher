class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        x, y = click
        self.traverse(board, x, y)
        return board

    def traverse(self, board, x, y):
        """
        :type board: List[List[str]]
        :type x: int
        :type y: int
        :rtype: None
        """
        if x > len(board) - 1 or y > len(board[0]) - 1 or x < 0 or y < 0:
            return
        current_cell = board[x][y]
        if current_cell == 'M':
            board[x][y] = 'X'
        elif current_cell == 'X' or current_cell.isdigit():
            return
        elif self.diagonal_bomb(x, y, board) > 0:
            pass
        elif current_cell == 'E':
            board[x][y] = 'B'
            self.traverse(board, x + 1, y + 1)
            self.traverse(board, x - 1, y - 1)
            self.traverse(board, x - 1, y + 1)
            self.traverse(board, x + 1, y - 1)
            self.traverse(board, x + 1, y)
            self.traverse(board, x, y + 1)
            self.traverse(board, x - 1, y)
            self.traverse(board, x, y - 1)

    def diagonal_bomb(self, i, j, board):
        """
        :type i: int
        :type j: int
        :type board: List[List[int]]
        :rtype: None
        """

        top = [(-1, -1), (-1, 0), (-1, 1)]
        row = [(0, -1), (0, 1)]
        bottom = [(1, -1), (1, 0), (1, 1)]
        result_list = list()
        result_list.append(self.calculate_bombs(top, i, j, board))
        result_list.append((self.calculate_bombs(row, i, j, board)))
        result_list.append((self.calculate_bombs(bottom, i, j, board)))

        bombes_around = result_list[0] + result_list[1] + result_list[2]
        if bombes_around > 0:
            board[i][j] = str(bombes_around)

        return bombes_around

    def calculate_bombs(self, indexes, i, j, board):
        """
        :type indexes: List[int]
        :type i: int
        :type j: int
        :type board: List[List[int]]
        :rtype: int
        """
        sum_items = 0
        for index in indexes:
            if i + index[0] > -1 and j + index[1] > -1 and ((i + index[0]) < len(board)) and ((j + index[1]) < len(board[0])):
                    sum_items += 1 if board[i + index[0]][j + index[1]] == 'M' else 0
        return sum_items


solution = Solution()
print(solution.updateBoard([["E","M","M","E","E","E","E","E"],["E","E","M","E","E","E","E","E"],["E","E","E","E","E","E","E","E"],["E","M","E","E","E","E","E","E"],["E","E","E","E","E","E","E","E"],["E","E","M","E","E","E","E","E"],["E","E","E","E","E","E","E","E"],["E","E","E","E","E","E","E","E"]]
,[5,5]))
