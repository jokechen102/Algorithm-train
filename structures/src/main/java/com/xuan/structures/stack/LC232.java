package com.xuan.structures.stack;

import java.util.Stack;

public class LC232 {
    private Stack<Integer> lstack;
    private Stack<Integer> rstack;

    public LC232() {
        this.lstack = new Stack<>();
        this.rstack = new Stack<>();
    }

    public void push(int x) {
        lstack.push(x);
    }

    public int pop() {
        if (rstack.isEmpty()){
            in2out();
        }
        return rstack.pop();
    }

    public int peek() {
        if (rstack.isEmpty()){
            in2out();
        }
        return rstack.peek();
    }

    public boolean empty() {
        return lstack.isEmpty() && rstack.isEmpty();
    }

    private void in2out(){
        while (!lstack.isEmpty()){
            rstack.push(lstack.pop());
        }
    }
}
