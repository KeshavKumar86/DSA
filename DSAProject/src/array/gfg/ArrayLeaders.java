package array.gfg;

import java.util.ArrayList;
import java.util.List;

public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders: " + leadersOptimal(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    static List<Integer> leadersOptimal(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int i = arr.length - 1;
        int max = arr[i];
        result.add(arr[i]);
        i = i - 1;
        while (i >= 0) {
            if (arr[i] >= max) {
                result.add(arr[i]);
                max = arr[i];

            }
            i--;
        }
        reverse(result);
        //Collections.reverse(result);
        return result;

    }

    private static void reverse(List<Integer> result) {
        int low = 0;
        int high = result.size() - 1;
        while (low < high) {
            int temp = result.get(low);
            result.set(low, result.get(high));
            result.set(high, temp);
            low++;
            high--;

        }
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(n)
*/
    static List<Integer> leaders(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
