package linkedlist.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println("Is Palindrome: " + isPalindrome(head));
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Determine the start of the second half
        ListNode secondHalf = (fast == null) ? slow : slow.next;
        // Step 3: Reverse the second half
        secondHalf = reverse(secondHalf);
        // Step 4: Compare both halves
        ListNode firstHalf = head;
        ListNode temp = secondHalf;
        boolean isPalindrome = true;
        while (temp != null) {
            if (firstHalf.val != temp.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        reverse(secondHalf);
        return isPalindrome;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
 Naive Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static boolean isPalindromeNaive(ListNode head) {
        //edge cases
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp;
        for (temp = head; temp != null; temp = temp.next) {
            list.add(temp.val);
        }
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
