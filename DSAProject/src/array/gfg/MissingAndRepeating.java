package array.gfg;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println("Missing and Repeating Number: " + findTwoElementOptimal3(arr));
    }

    /*
Optimal Solution3: Will Modify the input array
Time Complexity: O(2*n)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementOptimal3(int[] arr) {
        return null;
    }

    /*
Optimal Solution2: Will Modify the input array
Time Complexity: O(2*n)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementOptimal2(int[] arr) {
        int n = arr.length;
        int repeatedNumber = 0;
        int missingNumber = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = arr[index] * -1;
            } else {
                repeatedNumber = index + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missingNumber = i + 1;
            }
        }
        result.add(repeatedNumber);
        result.add(missingNumber);
        return result;
    }

    /*
Optimal Solution1: Will not work for Big Integer values
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementOptimal1(int[] arr) {
        int n = arr.length;
        BigInteger expectedSum = BigInteger.valueOf((long) n * (n + 1) / 2);
        BigInteger expectedSquaresSum = BigInteger.valueOf(n * (n + 1) * (2L * n + 1) / 6);
        BigInteger actualSum = BigInteger.valueOf(0);
        BigInteger actualSquareSum = BigInteger.valueOf(0);
        for (int element : arr) {
            actualSum = actualSum.add(BigInteger.valueOf(element));
            actualSquareSum = actualSquareSum.add(BigInteger.valueOf((long) element * element));
        }
        BigInteger mR = expectedSum.add(actualSum.negate());
        System.out.println("M-R = " + mR);
        BigInteger m2R2 = expectedSquaresSum.add(actualSquareSum.negate());
        System.out.println("M2-R2 = " + m2R2);
        BigInteger mPlusR = m2R2.divide(mR);
        System.out.println("M+R = " + mPlusR);
        BigInteger missingNumber = ((mPlusR.add(mR)).divide(BigInteger.valueOf(2)));
        System.out.println("Missing Number: " + missingNumber);
        BigInteger repeatedNumber = missingNumber.add(mR.negate());
        System.out.println("Repeated Number: " + repeatedNumber);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeatedNumber.intValue());
        result.add(missingNumber.intValue());
        return result;
    }

    /*
Better Solution:
Time Complexity: O(2*n)
Space Complexity:O(n)
*/
    private static ArrayList<Integer> findTwoElementBetter(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int element : arr) {
            freq[element]++;
        }
        int repeatedNumber = 0;
        int missingNumber = 0;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                repeatedNumber = i;
            }
            if (freq[i] == 0) {
                missingNumber = i;
            }
        }
        result.add(repeatedNumber);
        result.add(missingNumber);
        return result;
    }

    /*
Naive Solution1:
Time Complexity: O(n*logn)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementNaive1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int actualSum = arr[0];
        int repeatedNumber = 0;
        for (int i = 1; i < n; i++) {
            actualSum += arr[i];
            if (arr[i] == arr[i - 1]) {
                repeatedNumber = arr[i];
            }
        }
        int expectedSum = n * (n + 1) / 2;
        int missingNumber = expectedSum - (actualSum - repeatedNumber);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeatedNumber);
        result.add(missingNumber);
        return result;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementNaive(int[] arr) {
        int n = arr.length;
        int duplicate = 0;
        int missing = 0;
        for (int i = 1; i <= n; i++) {
            int freq = 0;
            for (int element : arr) {
                if (i == element) {
                    freq++;
                }
            }
            if (freq == 2) {
                duplicate = i;
            }
            if (freq == 0) {
                missing = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);
        return result;
    }

}
