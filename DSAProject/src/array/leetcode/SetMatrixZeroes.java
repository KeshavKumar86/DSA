package array.leetcode;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 0, 7, 8};
        matrix[2] = new int[]{0, 10, 11, 12};
        matrix[3] = new int[]{13, 14, 15, 0};
        System.out.println("Original Array:");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
        setZeroes(matrix);
        System.out.println("Array After Setting Zeros: ");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
    }

    /*
Optimal Solution:
Time Complexity: O(n*m)
Space Complexity:O(1)
*/
    private static void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int rowZero = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[0][j] = 0;
                    if (i > 0) {
                        mat[i][0] = 0;
                    } else {
                        rowZero = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        if (mat[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
        if (rowZero == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
    }

    /*
Better Solution:
Time Complexity: O(n*m)
Space Complexity:O(n+m)
*/
    private static void setZeroesBetter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 2;
                    col[j] = 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] == 2) {
                int j = 0;
                while (j < m) {
                    mat[i][j++] = 0;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (col[j] == 2) {
                int i = 0;
                while (i < n) {
                    mat[i++][j] = 0;
                }
            }
        }
    }

    /*
Naive Solution:
Time Complexity: O(n*m)
Space Complexity:O(n*m)
*/
    public static void setZeroesNaive(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] copy = new int[n][];
        for (int i = 0; i < n; i++) {
            copy[i] = new int[m];
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, copy[i], 0, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    int row = 0;
                    while (row < n) {
                        mat[row++][j] = 0;
                    }
                    int col = 0;
                    while (col < m) {
                        mat[i][col++] = 0;
                    }
                }
            }
        }
    }
}
