package binarysearch.gfg;

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 4, 5}, b = {1, 1, 2};
        int k = 9;
        System.out.println("Kth Element: " + kthElement(a, b, k));
    }

    private static int kthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0;
        int index = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (index == k - 1) {
                    return a[i];
                }
                i++;
            } else {
                if (index == k - 1) {
                    return b[j];
                }
                j++;
            }
            index++;
        }
        while (i < n) {
            if (index == k - 1) {
                return a[i];
            }
            i++;
            index++;
        }
        while (j < m) {
            if (index == k - 1) {
                return b[j];
            }
            j++;
            index++;
        }
        return -1;
    }
}
