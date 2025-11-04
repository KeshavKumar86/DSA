package linkedlist.gfg;

import static linkedlist.gfg.LinkedListInsertionAtBeginning.printList;

public class SortALinkedListOf0s1sAnd2s {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);
        printList(head);
        Node updateHead = segregateOptimal(head);
        printList(updateHead);
    }

    /*
   Better Solution:
   Time Complexity: O(2*n)
   Space Complexity:O(1)
   */
    private static Node segregate(Node head) {
        Node curr = head;
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        while (curr != null) {
            if (curr.data == 0) {
                zeroCount++;
            } else if (curr.data == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < zeroCount; i++) {
            curr.data = 0;
            curr = curr.next;
        }
        for (int i = 0; i < oneCount; i++) {
            curr.data = 1;
            curr = curr.next;
        }
        for (int i = 0; i < twoCount; i++) {
            curr.data = 2;
            curr = curr.next;
        }
        return head;
    }

    /*
 Better Solution:
 Time Complexity: O(2*n)
 Space Complexity:O(1)
 */
    private static Node segregateOptimal(Node head) {
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
        /*
   Naive Solution: Just sort the list
   Time Complexity: O(n*logn)
   Space Complexity:O(1)
   */
}
