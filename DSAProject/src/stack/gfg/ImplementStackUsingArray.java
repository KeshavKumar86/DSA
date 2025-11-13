package stack.gfg;

public class ImplementStackUsingArray {
    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(5);
        stack.push(3);
        System.out.println("Peek Element: " + stack.peek());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        System.out.println("Is Stack Full: " + stack.isFull());
    }
}

/*
Optimal Solution:
Time Complexity Of All Operations: O(1)
Space Complexity:O(n)
*/
class MyStack {

    int size;
    int[] stack;
    int capacity;

    public MyStack(int n) {
        // Define Data Structures
        stack = new int[n];
        capacity = n;
        size = 0;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return size == 0;
    }

    public boolean isFull() {
        // check if the stack is full
        return size == capacity;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if (size < capacity) {
            stack[size] = x;
            size++;
        } else {
            System.out.println("Stack Overflow: Cannot push " + x);
        }
    }

    public int pop() {
        // Removes an element from the top of the stack
        if (size > 0) {
            int top = stack[size - 1];
            size--;
            return top;
        } else {
            System.out.println("Stack underflow: No element to pop");
            return -1;
        }
    }

    public int peek() {
        // Returns the top element of the stack
        if (size > 0) {
            return stack[size - 1];

        }
        return -1;
    }
}
