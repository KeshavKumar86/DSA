package array.leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{5};
//        matrix[1] = new int[]{2, 4, 8, 10};
//        matrix[2] = new int[]{13, 3, 6, 7};
//        matrix[3] = new int[]{15, 14, 12, 16};
        System.out.println("Original Array:");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
        rotate(matrix);
        System.out.println("Array After Setting Zeros: ");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
    }

    private static void rotate(int[][] mat) {
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
            int j = m - 1 - i;
            for (int k = 0; k < m; k++) {
                mat[k][j] = copy[i][k];
            }
        }
    }
}
