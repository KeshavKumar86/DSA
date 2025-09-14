package array.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);

    }
    /*
Optimal Solution:
Time Complexity: O(n*m)
Space Complexity:O(1)
*/
    private static List<Integer> spiralOrder(int[][] matrix) {
        int rs = 0, re = matrix.length;
        int cs = 0, ce = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        while (rs < re && cs < ce) {
            //get every i in the start row
            for (int i = cs; i < ce; i++) {
                result.add(matrix[rs][i]);
            }
            rs++;
            //get every i in the end column
            for (int i = rs; i < re; i++) {
                result.add(matrix[i][ce - 1]);
            }
            ce--;
            if (rs == re || cs == ce) {
                break;
            }
            //get every i in the end row
            for (int i = ce - 1; i >= cs; i--) {
                result.add(matrix[re - 1][i]);
            }
            re--;
            //get every i in the start column
            for (int i = re - 1; i >= rs; i--) {
                result.add(matrix[i][cs]);
            }
            cs++;
        }
        return result;
    }
}
