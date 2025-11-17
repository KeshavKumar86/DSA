package stack.gfg;

import java.util.LinkedList;

public class StackUsingLinkedList {
    public static void main(String[] args) {

    }
}

/*
Optimal Solution: Maintain queue order at every step
Time Complexity: push O(1), pop O(1), top O(1), empty O(1)
Space Complexity:O(n)
*/
class myStack {

    LinkedList<Integer> stack;

    public myStack() {
        stack = new LinkedList<>();
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return stack.isEmpty();
    }

    public void push(int x) {
        // Adds an element at the TOP of the stack (front of linked list)
        stack.addFirst(x);
    }

    public void pop() {
        // Removes the TOP element of the stack
        if (!stack.isEmpty()) {
            stack.removeFirst();
        }
    }

    public int peek() {
        // Returns the TOP element of the stack.
        // If stack is empty, return -1.
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(0);
    }

    public int size() {
        // Returns the current size of the stack
        return stack.size();
    }
}

