package linkedlist.leetcode;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode updatedHead = reverseListRecursive2(head);
        printList(updatedHead);
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
 Recursive Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static ListNode reverseListRecursive1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode updatedHead = reverseListRecursive1(head.next);
        head.next.next = head;
        head.next = null;
        return updatedHead;
    }

    /*
 Recursive Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static ListNode reverseListRecursive2(ListNode head) {
        return reverseListRecursive(head, null);
    }

    private static ListNode reverseListRecursive(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverseListRecursive(next, curr);
    }
        /*
 Naive Solution: Iterate the list and store the data in the arraylist, then again iterate the list
 and update the data from the end of the arraylist.
 Time Complexity: O(2*n)
 Space Complexity:O(1)
 */
}
