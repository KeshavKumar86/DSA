package linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        head.next = secondNode;
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = secondNode;
        System.out.println("Cycle At Node: " + detectCycle(head).val);
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    /*
 Naive Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static ListNode detectCycleNaive(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
