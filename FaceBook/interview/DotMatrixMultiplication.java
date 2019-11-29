import java.util.*;

class DotMatrixMultiplication {
    public static void main(String[] args) {
        List<int[]> list1 = Arrays.asList(new int[] { 0, 2 });
        List<int[]> list2 = Arrays.asList(new int[] { 0, 2 });
        int result = multiply(list1, list2);
        System.out.println(result);
    }

    public static int multiply(List<int[]> dotMatrix1, List<int[]> dotMatrix2) {
        int index1 = 0;
        int index2 = 0;
        int dotMatrixProduct = 0;

        while (index1 < dotMatrix1.size() && index2 < dotMatrix2.size()) {
            if (dotMatrix1.get(index1)[0] == dotMatrix2.get(index2)[0]) {
                dotMatrixProduct += dotMatrix1.get(index1)[1] * dotMatrix2.get(index2)[1];
                index1++;
                index2++;
            } else if (dotMatrix1.get(index1)[0] < dotMatrix2.get(index2)[0]) {
                index1++;
            } else {
                index2++;
            }
        }

        return dotMatrixProduct;
    }
}

/**
 * First and foremost let's think about data structures that we would like to use
 * We want to use an array of tuples to solve this question
 * 
 */