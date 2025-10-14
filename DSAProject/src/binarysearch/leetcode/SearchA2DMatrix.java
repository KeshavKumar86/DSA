package binarysearch.leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 60};
        int target = 12;
        //matrix[3] = new int[]{0, 0, 0, 0};
        System.out.println("Is " + target + " present: " + searchMatrix(matrix, target));
    }

    /*
 Optimal Solution:
 Time Complexity: O(logn + logm)
 Space Complexity:O(1)
 */
    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = n - 1;
        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][m - 1] == target) {
                return true;
            } else if (matrix[mid][m - 1] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        int row = left;
        left = 0;
        right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /*
 Optimal Solution:
 Time Complexity: O(logm*n)
 Space Complexity:O(1)
 */
    private static boolean searchMatrixII(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
