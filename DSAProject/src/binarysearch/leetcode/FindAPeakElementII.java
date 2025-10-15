package binarysearch.leetcode;

import java.util.Arrays;

public class FindAPeakElementII {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{10, 20, 15};
        matrix[1] = new int[]{21, 30, 14};
        matrix[2] = new int[]{7, 16, 32};
        System.out.println("Peak Element's Index: " + Arrays.toString(findPeakGridNaive(matrix)));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n*logm)
 Space Complexity:O(1)
 */
    private static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int max = mat[0][mid];
            int maxRow = 0;
            for (int row = 1; row < n; row++) {
                if (mat[row][mid] > max) {
                    max = mat[row][mid];
                    maxRow = row;
                }
            }
            if ((mid + 1 >= m || max > mat[maxRow][mid + 1]) &&
                    (mid - 1 < 0 || max > mat[maxRow][mid - 1])) {
                return new int[]{maxRow, mid};
            } else if (max < mat[maxRow][mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
    /*
 Naive Solution:
 Time Complexity: O(n*m)
 Space Complexity:O(1)
 */
    private static int[] findPeakGridNaive(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = mat[0][0];
        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }
}
