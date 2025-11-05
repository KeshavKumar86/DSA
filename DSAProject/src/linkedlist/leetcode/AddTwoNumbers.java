package linkedlist.leetcode;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode headA = new ListNode(5);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(8);
        headA.next.next.next.next = new ListNode(4);
        headA.next.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(1);
        headB.next.next = new ListNode(9);
        printList(headA);
        ListNode updateHead = addTwoNumbers(headA, headB);
        printList(updateHead);
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int carry = 0;
        while (curr1 != null && curr2 != null) {
            int num1 = curr1.val;
            int num2 = curr2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int num1 = curr1.val;
            int sum = num1 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int num1 = curr2.val;
            int sum = num1 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            curr2 = curr2.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static ListNode addTwoNumbersStandard(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
    /*
Optimal Solution: A simple brute-force approach would be to first store both linked lists’ digits in
ArrayLists, then simulate the addition just like we do on paper. It works fine but uses extra space
for arrays.
Time Complexity: O(n)
Space Complexity:O(1)
*/
}
