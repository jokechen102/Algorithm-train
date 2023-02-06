package com.xuan.structures.stack;

import java.util.Stack;

// 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
public class LC224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int sign = 1;
        stack.push(sign);
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n){
            char c = s.charAt(i);
            if (c == ' '){
                i++;
            }else if (c == '+'){
                sign = stack.peek();
                i++;
            }else if (c == '-'){
                sign = -stack.peek();
                i++;
            }else if (c == '('){
                stack.push(sign);
                i++;
            }else if (c == ')'){
                stack.pop();
                i++;
            }else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (c - '0');
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        String s = "22 - 1 + 2";
        LC224 lc224 = new LC224();
        System.out.println(lc224.calculate(s));
    }
}
