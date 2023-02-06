package com.xuan.structures.stack;

import java.util.Stack;

/*
你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。

 */
public class LC682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations){
            if (s.equalsIgnoreCase("C")){
                stack.pop();
            }else if (s.equalsIgnoreCase("D")){
                stack.push( 2 * stack.peek());
            }else if (s.equalsIgnoreCase("+")){
                Integer temp1 = stack.pop();
                Integer temp2 = stack.peek();
                stack.push(temp1);
                stack.push( temp1 + temp2);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        int ret = 0;
        while (!stack.isEmpty()){
            ret += stack.pop();
        }
        return ret;

    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        String[] ops1 = {"5","-2","4","C","D","9","+","+"};
        String[] ops2 = {"1"};
        LC682 lc682 = new LC682();
        System.out.println(lc682.calPoints(ops));
        System.out.println(lc682.calPoints(ops1));
        System.out.println(lc682.calPoints(ops2));
    }
}
