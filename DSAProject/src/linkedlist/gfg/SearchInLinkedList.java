package linkedlist.gfg;

import static linkedlist.gfg.LinkedListInsertionAtBeginning.printList;

public class SearchInLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        printList(node1);
        int key = 5;
        System.out.println("Element Present: " + searchKeyRecursive(node1, key));
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static boolean searchKey(Node head, int key) {
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data == key) {
                return true;
            }
        }
        return false;
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static boolean searchKeyRecursive(Node head, int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        return searchKeyRecursive(head.next, key);
    }
}
