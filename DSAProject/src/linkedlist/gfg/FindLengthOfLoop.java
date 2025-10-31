package linkedlist.gfg;

public class FindLengthOfLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node secondNode = new Node(2);
        head.next = secondNode;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = secondNode;
        System.out.println("Cycle At Node: " + lengthOfLoop(head));
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static int lengthOfLoop(Node head) {
        int length = 0;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return 0;
        }
        do {
            fast = fast.next;
            length++;
        } while (slow != fast);
        return length;
    }
}
