package array.leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{5, 1, 9, 11};
        matrix[1] = new int[]{2, 4, 8, 10};
        matrix[2] = new int[]{13, 3, 6, 7};
        matrix[3] = new int[]{15, 14, 12, 16};
        System.out.println("Original Array:");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
        rotate(matrix);
        System.out.println("Array After Rotation: ");
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
    }
    /*
Naive Solution:
Time Complexity: O(n*m)
Space Complexity:O(n*m)
*/
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        //1. Take the transpose
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row < col) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }
        for (int[] arrayElement : matrix) {
            System.out.println(Arrays.toString(arrayElement));
        }
        //2. Reverse the rows of the transpose
        for (int row = 0; row < n; row++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }
    }

    /*
Naive Solution:
Time Complexity: O(n*m)
Space Complexity:O(n*m)
*/
    private static void rotateNaive(int[][] mat) {
        int n = mat.length;
        int[][] copy = new int[n][];
        for (int i = 0; i < n; i++) {
            copy[i] = new int[n];
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, copy[i], 0, n);
        }
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            for (int k = 0; k < n; k++) {
                mat[k][j] = copy[i][k];
            }
        }
    }
}
