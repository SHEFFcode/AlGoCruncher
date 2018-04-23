from unique_id import get_unique_id

board = [
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
]

board_2 = [
    ["A", "B", "C", "E"],
    ["S", "F", "E", "S"],
    ["A", "D", "E", "E"]
]

board_3 = [
    ['A', 'B', 'N', 'D'],
    ['B', 'C', 'E', 'F']

]

def exist(board, word):
    letter = word[0]
    for row in range(len(board)):
        for col in range(len(board[0])):
            if board[row][col] == letter:
                my_id = get_unique_id()
                visited = set()
                dfs_stack = [(my_id, board, row, col, visited, word, 1)]

                while len(dfs_stack):
                    # print(dfs_stack)
                    # print('*' * 100)
                    id, board, row_n, col_n, visited_n, word, index = dfs_stack.pop()

                    if index == len(word):
                        return True

                    if moves(board, row_n, col_n, visited_n, word, index) != False:
                        new_coord = moves(board, row_n, col_n, visited_n, word, index)
                        dfs_stack += new_coord
                        # print(dfs_stack)
                        # print('-' * 100)

    return False


def moves(board, row, col, visited, word, index):
    letter = word[index]
    added_stack = []
    visited_n = set(visited)
    visited_n.add((row, col))
    if col - 1 >= 0 and board[row][col - 1] == letter and (row, col - 1) not in visited:
        my_id = get_unique_id()

        added_stack.append((my_id, board, row, col - 1, visited_n, word, index + 1))
    if col + 1 < len(board[0]) and board[row][col + 1] == letter and (row, col + 1) not in visited:
        my_id = get_unique_id()

        added_stack.append((my_id, board, row, col + 1, visited_n, word, index + 1))
    if row - 1 >= 0 and board[row - 1][col] == letter and (row - 1, col) not in visited:
        my_id = get_unique_id()

        added_stack.append((my_id, board, row - 1, col, visited_n, word, index + 1))
    if row + 1 < len(board) and board[row + 1][col] == letter and (row + 1, col) not in visited:
        my_id = get_unique_id()

        added_stack.append((my_id, board, row + 1, col, visited_n, word, index + 1))

    if not len(added_stack):
        return False
    else:
        return added_stack


print(exist(board, "ABCCED"))
print(exist(board, 'ABCB'))
print(exist(board, "SEE"))
print(exist(board_2, "ABCESEEEFS"))







