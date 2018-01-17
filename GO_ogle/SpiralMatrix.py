class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        output_list = []
        if not matrix or len(matrix[0]) < 1:
            return output_list
        current_item, starting_row_index, ending_row_index = 0, 0, len(matrix)
        starting_column_index, ending_column_index = 0, len(matrix[0])
        while starting_row_index < ending_row_index and starting_column_index < ending_column_index:
            # Print the first row of the remaining rows, the size of the row is from first column to last column
            for current_item in range(starting_column_index, ending_column_index):
                output_list.append(matrix[starting_row_index][current_item])  # Appends horizontally
            starting_row_index += 1  # we change up the starting row index so that it is one higher
            # Print last column of the remaining columns
            for current_item in range(starting_row_index, ending_row_index):
                output_list.append(matrix[current_item][ending_column_index - 1])
            ending_column_index -= 1  # we reduce the size of he ending columns
            # Print the last row of the remaining rows
            if starting_row_index < ending_row_index:
                for current_item in range(ending_column_index - 1, starting_column_index - 1, -1):
                    output_list.append(matrix[ending_row_index - 1][current_item])
                ending_row_index -= 1  # Reduce the number of the ending row index
            # Print the first column of the remaining columns
            if starting_column_index < ending_column_index:
                for current_item in range(ending_row_index - 1, starting_row_index - 1, -1):
                    output_list.append(matrix[current_item][starting_column_index])
                starting_column_index += 1
        return output_list

solution = Solution()
print(solution.spiralOrder([]))
