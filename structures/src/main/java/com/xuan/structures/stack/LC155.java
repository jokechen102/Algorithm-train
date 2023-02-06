package com.xuan.structures.stack;

import java.util.ArrayList;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
 */
public class LC155 {
    private int[] data;
    private int size;
    private ArrayList<Integer> minList;
    private final static int DintFAULT_CAPACITY = 10;

    public LC155(int capacity){
        this.data = new int[capacity];
        this.size = 0;
        this.minList = new ArrayList<Integer>();
    }

    public LC155(){
        this(DintFAULT_CAPACITY);
    }


    public void push(int e){
        if (size == data.length){
            resize(data.length * 2);
        }
        data[size] = e;
        size ++;
        if (minList.size() > 0 ){
            minList.add(Math.min(e, minList.get(minList.size() - 1)));
        }else {
            minList.add(e);
        }
    }

    public int pop(){
        if (size <= 0){
            throw new RuntimeException("Pop failed. Stack is empty.");
        }
        int res = data[size - 1];
        data[size - 1] = 0;
        size -- ;
        if(size - 1 < data.length / 4 && data.length / 2 > DintFAULT_CAPACITY){
            resize(data.length / 2);
        }
        minList.remove(minList.size() - 1);
        return res;
    }

    public int top(){
        if (size <= 0){
            throw new RuntimeException("Stack is empty.");
        }
        return data[size - 1];
    }

    public int getMin(){
        return minList.get(minList.size() - 1);
    }

    private void resize(int capacity) {
        int[] temp = new int[capacity];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }
}
