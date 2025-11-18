package stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.TreeMap;

public class MinStack {
    public static void main(String[] args) {

    }
}

/*
Optimal Solution:
Time Complexity: O(1) for all operations
Space Complexity: O(n)
*/
class MinStackClassOptimal {
    Deque<Integer[]> stack;

    public MinStackClassOptimal() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        Integer[] values = {val, val};
        if (!stack.isEmpty()) {
            if (val >= stack.peek()[1]) {
                values[1] = stack.peek()[1];
            }
        }
        stack.push(values);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        }
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        }
        return -1;
    }
}

/*
Optimal Solution:
Time Complexity: O(1) for all except min O(n)
Space Complexity: O(n)
*/
class MinStackClassNaive {
    Deque<Integer> stack;

    public MinStackClassNaive() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Iterator<Integer> iterator = stack.iterator();
        int min = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            min = Math.min(min, iterator.next());
        }
        return min;
    }
}
/*
Optimal Solution:
Time Complexity: O(1) for top, O(logn) for others
Space Complexity: O(2*n)
*/
class MinStackClass {
    TreeMap<Integer, Integer> treeMap;
    Deque<Integer> stack;

    public MinStackClass() {
        treeMap = new TreeMap<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int val = stack.pop();
        int freq = treeMap.get(val);
        if (freq == 1) {
            treeMap.remove(val);
        } else {
            treeMap.put(val, treeMap.get(val) - 1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return treeMap.firstKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
