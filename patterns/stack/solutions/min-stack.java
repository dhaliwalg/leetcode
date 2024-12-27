/*
 * LeetCode Problem: https://leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
import java.util.*;
class MinStack {
    private Stack<Integer> baseStack;
    private Stack<Integer> minimumStack;

    public MinStack() {
        baseStack = new Stack<>();
        minimumStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minimumStack.isEmpty() || val <= minimumStack.peek()){
            minimumStack.add(val);
        }
        baseStack.add(val);
    }
    
    public void pop() {
        if(minimumStack.peek().equals(baseStack.peek())){
            minimumStack.pop();
        }
        baseStack.pop();
    }
    
    public int top() {
        return baseStack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
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