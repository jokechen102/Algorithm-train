package com.xuan.structures.stack;

import java.util.Stack;

public class LC844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (c == '#'){
                if (lstack.isEmpty()){
                    continue;
                }
                lstack.pop();
            }else {
                lstack.push(c);
            }
        }
        for (Character c : t.toCharArray()){
            if (c == '#'){
                if (rstack.isEmpty()){
                    continue;
                }
                rstack.pop();
            }else {
                rstack.push(c);
            }
        }
        if (lstack.size() != rstack.size()){
            return false;
        }
        while (!lstack.isEmpty()){
            if (lstack.pop() != rstack.pop()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "a##c";
        String s2 = "#a#c";
        LC844 lc844 = new LC844();
        System.out.println(lc844.backspaceCompare(s1, s2));
    }
}
