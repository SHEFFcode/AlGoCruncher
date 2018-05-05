def find_word(matrix, word):
    if input_valid(matrix, word):
        for i in xrange(0, len(matrix)):
            for j in xrange(0, len(matrix)):
                if matrix[i][j] == word[0]:
                    if traverse(i, j, 0, word, matrix):
                        return True
    else:
        return False


def traverse(i, j, index, word, matrix):
    if matrix[i][j] == word[index] and index == len(word) - 1:
        return True
    elif matrix[i][j] != word[index]:
        return False

    neighbors = generate_neighbors(i, j, len(matrix), len(matrix[0]))

    letter = matrix[i][j]
    matrix[i][j] = '.'

    for neighbor in neighbors:
        if traverse(neighbor[0], neighbor[1], index + 1, word, matrix):
            return True

    matrix[i][j] = letter


def generate_neighbors(iPos, jPos, height, width):
    neighbors = []

    for i in range(-1, 2):
        for j in range(-1, 2):
            if ((i == -1 or i == 1) and j == 0) or ((j == -1 or j == 1) and i == 0):
                if height > i + iPos > -1 and -1 < j + jPos < width:
                    neighbors.append([i + iPos, j + jPos])

    return neighbors


def input_valid(matrix, word):
    return matrix and len(matrix) > 0 and word and len(matrix[0]) * len(matrix[1]) > len(word) > 0


print(find_word([
  ['A', 'R', 'I', 'D', 'S'],
  ['W', 'E', 'R', 'O', 'D'],
  ['U', 'E', 'F', 'B', 'E'],
  ['B', 'E', 'R', 'E', 'E']
], "UBER"))