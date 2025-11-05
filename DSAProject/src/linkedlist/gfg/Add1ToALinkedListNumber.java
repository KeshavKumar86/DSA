package linkedlist.gfg;

import static linkedlist.gfg.LinkedListInsertionAtBeginning.printList;

public class Add1ToALinkedListNumber {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        printList(head);
        Node updateHead = addOne(head);
        printList(updateHead);
    }
    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static Node addOne(Node head) {
        if (head == null) {
            return null;
        }
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node revHead = reverse(dummyNode);
        Node curr = revHead;
        while (curr.data == 9) {
            curr.data = 0;
            curr = curr.next;
        }
        curr.data = curr.data + 1;
        dummyNode = reverse(revHead);
        if (dummyNode.data == 0) {
            return dummyNode.next;
        }
        return dummyNode;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
