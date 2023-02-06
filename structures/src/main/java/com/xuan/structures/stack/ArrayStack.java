package com.xuan.structures.stack;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

// leetcode 相关题目 20,155,232,844,224,682,496
public class ArrayStack<E> {
    private E[] data;
    private int size;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 10;

    public ArrayStack(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }


    public void push(E e){
        if (size == capacity){
            resize(capacity * 2);
        }
        data[size] = e;
        size ++;
    }

    public E pop(){
        if (size <= 0){
            throw new RuntimeException("Pop failed. Stack is empty.");
        }
        E res = data[size - 1];
        data[size - 1] = null;
        size -- ;
        if(size - 1 < capacity / 4 && capacity / 2 > DEFAULT_CAPACITY){
            resize(capacity / 2);
        }
        return res;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0 ; i < 20; i ++){
            stack.push(i);
        }
        for (int i = 0; i < 21; i ++){
            System.out.println(stack.pop());
        }
    }

}
