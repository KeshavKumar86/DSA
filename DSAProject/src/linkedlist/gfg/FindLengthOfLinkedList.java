package linkedlist.gfg;

public class FindLengthOfLinkedList {
    public static void main(String[] args) {
        // Creating a sample linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        // Find and print the length of linked list
        System.out.println("Length of Linked List: " + getCountRecursive(head));
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static int getCountOptimal(Node head) {
        Node temp = head;
        int length = 1;
        while (temp.next != null && temp.next.next != null) {
            length = length + 2;
            temp = temp.next.next;
        }
        if (temp.next != null) {
            length++;
        }
        return length;
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int getCountBetter(Node head) {
        int length = 0;
        for (Node i = head; i != null; i = i.next) {
            length++;
        }
        return length;
    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int getCountRecursive(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + getCountRecursive(head.next);
    }
}
