import math

class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        grayscale_list = [[0 for _ in range(len(M[0]))] for _ in range(len(M))]
        for i in range(len(M[0])):
            for j in range(len(M)):
                result = self.try_calculate_greyscale(i, j, M)
                grayscale_list[i][j] = int(result)
        return grayscale_list

    def try_calculate_greyscale(self, i, j, M):
        """
        :type i: int
        :type j: int
        :type M: List[List[int]]
        :rtype: int
        """
        top = [(-1, -1), (-1, 0), (-1, -1)]
        row = [(0, -1), (0, 1)]
        bottom = [(1, -1), (1, 0), (1, 1)]
        result_list = list()
        result_list.append(self.calculate_greyscale(top, i, j, M))
        result_list.append((self.calculate_greyscale(row, i, j, M)))
        result_list.append((self.calculate_greyscale(bottom, i, j, M)))

        sum_of_items = result_list[0][0] + result_list[1][0] + result_list[2][0] + M[i][j]  # for item itself
        count_of_items = result_list[0][1] + result_list[1][1] + result_list[2][1] + 1  # to count item itself

        return math.floor(sum_of_items / count_of_items) if count_of_items > 0 else 0

    def calculate_greyscale(self, indexes, i, j, M):
        """
        :type indexes: List[tuple]
        :type i: int
        :type j: int
        :type M: List[List[int]]
        :rtype: tuple
        """
        sum_items, count_items = 0, 0
        for index in indexes:
            try:
                sum_items += M[i + index[0]][j + index[1]] if i + index[0] > -1 and j + index[1] > -1 else 0
                count_items += 1 if i + index[0] > -1 and j + index[1] > -1 else 0
            except IndexError:
                continue
        return sum_items, count_items

solution = Solution()
solution.imageSmoother([[1, 1, 1], [1, 0, 1], [1, 1, 1]])
