package linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(5);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(8);
        headA.next.next.next.next = new ListNode(4);
        headA.next.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(1);
        headB.next.next = headA.next.next.next;
        printList(headA);
        ListNode updateHead = getIntersectionNode(headA, headB);
        printList(updateHead);
    }
    /*
   Naive Solution:
   Time Complexity: O(n)
   Space Complexity:O(n)
   */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (!set.add(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return curr;
    }
}
