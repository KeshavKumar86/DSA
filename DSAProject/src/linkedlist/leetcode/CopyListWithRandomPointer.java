package linkedlist.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }
    /*
 Optimal Solution:
 Time Complexity: O(2*n)
 Space Complexity:O(n)
 */
    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr = head;
        // Create all clone nodes and map them
        while (curr != null) {
            Node node = new Node(curr.val);
            nodeMap.put(curr, node);
            curr = curr.next;
        }
        Node newHead = nodeMap.get(head);
        curr = head;
        // Connect next and random pointers
        while (curr != null) {
            Node currClone = nodeMap.get(curr);
            currClone.next = nodeMap.get(curr.next);
            currClone.random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
