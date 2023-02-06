package com.xuan.structures.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class LC20 {
    private Stack<Character> stack;
    public LC20(){
        this.stack = new Stack<>();
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0 ) return false;
                Character temp = stack.pop();
                char c = s.charAt(i);
                if ((temp == '(' && c != ')') || (temp == '{' && c != '}') || (temp == '[' && c != ']')) return false;
            }
        }
        return stack.size() <= 0;
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "()[]{}";
        String s2 = "(]";
        LC20 lc20 = new LC20();
        System.out.println(lc20.isValid(s));
        System.out.println(lc20.isValid(s1));
        System.out.println(lc20.isValid(s2));
    }
    // 15L@aagu
}
