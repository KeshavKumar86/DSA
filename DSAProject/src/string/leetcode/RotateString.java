package string.leetcode;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "cdeab";
        System.out.println("Is Rotate String: " + rotateStringNaive(s, t));
    }

    private static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s = s + s;
        return s.contains(goal);
    }

    private static boolean rotateStringNaive(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(0);
            s = s.substring(1) + c;
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
