package linkedlist.leetcode;

import java.util.ArrayList;
import java.util.List;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printList(head);
        ListNode updateHead = oddEvenListNaive(head);
        printList(updateHead);
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /*
 Naive Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static ListNode oddEvenListNaive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            oddList.add(curr.val);
            evenList.add(curr.next.val);
            curr = curr.next.next;
        }
        // if list length is odd
        if (curr != null) {
            oddList.add(curr.val);
        }
        //add odds then evens in the list
        curr = head;
        for (int val : oddList) {
            curr.val = val;
            curr = curr.next;
        }
        for (int val : evenList) {
            curr.val = val;
            curr = curr.next;
        }
        return head;
    }
}
