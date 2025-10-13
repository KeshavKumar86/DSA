package binarysearch.gfg;

public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{0, 1, 1, 1};
        matrix[1] = new int[]{0, 0, 1, 1};
        matrix[2] = new int[]{1, 1, 1, 1};
        matrix[3] = new int[]{0, 0, 0, 0};
        System.out.println("Row With Max1's: " + rowWithMax1s(matrix));

    }

    /*
Optimal Solution:
Time Complexity: O(n + m)
Space Complexity:O(1)
*/
    private static int rowWithMax1s(int[][] arr) {
        int res = -1;
        int n = arr.length;
        int m = arr[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0) {
            if (arr[row][column] == 1) {
                res = row;
                column--;
            } else {
                row++;
            }
        }
        return res;
    }

    /*
Better Solution:
Time Complexity: O(n*logm)
Space Complexity:O(1)
*/
    private static int rowWithMax1sBetter(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int maxNoOf1 = 0;
        int max1Row = -1;
        for (int i = 0; i < n; i++) {
            int noOf1;
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[i][mid] == 1) {
                    right = mid - 1;
                    noOf1 = m - mid;
                    if (noOf1 > maxNoOf1) {
                        maxNoOf1 = noOf1;
                        max1Row = i;
                    }
                } else {
                    left = mid + 1;
                }
            }
        }
        return max1Row;
    }

    /*
Naive Solution:
Time Complexity: O(n*m)
Space Complexity:O(1)
*/
    private static int rowWithMax1sNaive(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int maxNoOf1 = 0;
        int max1Row = -1;
        for (int i = 0; i < n; i++) {
            int noOf1 = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    noOf1++;
                    if (noOf1 > maxNoOf1) {
                        maxNoOf1 = noOf1;
                        max1Row = i;
                    }

                }
            }
        }
        return max1Row;
    }


}
