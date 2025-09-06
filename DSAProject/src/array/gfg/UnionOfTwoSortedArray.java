package array.gfg;

import java.util.Arrays;
import java.util.TreeSet;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 3};
        int[] arr2 = {2, 2, 3, 4, 4, 5};
        int[] unionArray = unionOptimal(arr1, arr2);
        System.out.println("Union of Array: " + Arrays.toString(unionArray));
    }

    /*
Naive Solution:
Time Complexity: O( (n+m)*log(n+m) )
Space Complexity:O(n+m)
*/
    private static Integer[] union(int[] arr1, int[] arr2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int element : arr1) {
            treeSet.add(element);
        }
        for (int element : arr2) {
            treeSet.add(element);
        }
        return treeSet.toArray(new Integer[0]);
    }

    /*
Optimal Solution:
Time Complexity: O(n+m)
Space Complexity:O(n+m)
*/
    private static int[] unionOptimal(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int size = n + m;
        int[] res = new int[size];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (k > 0 && arr1[i] == res[k - 1]) {
                    i++;
                } else {
                    res[k++] = arr1[i++];
                }

            } else if (arr1[i] > arr2[j]) {
                if (k > 0 && arr2[j] == res[k - 1]) {
                    j++;
                } else {
                    res[k++] = arr2[j++];
                }

            } else {
                if (k > 0 && arr1[i] == res[k - 1]) {
                    i++;
                } else {
                    res[k++] = arr1[i++];
                }
                j++;

            }

        }
        while (i < n) {
            if (k > 0 && arr1[i] == res[k - 1]) {
                i++;
            } else {
                res[k++] = arr1[i++];
            }

        }
        while (j < m) {
            if (k > 0 && arr2[j] == res[k - 1]) {
                j++;
            } else {
                res[k++] = arr2[j++];
            }

        }
        return Arrays.copyOf(res, k);
    }
    /*
    Solution3: Naive Approach: Concatenate + Sort + Remove Duplicates
    Time Complexity: O( (n+m)*log(n+m) )
    Space Complexity: O(n+m)
     */
}
