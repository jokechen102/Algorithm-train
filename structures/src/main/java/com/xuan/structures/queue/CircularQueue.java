package com.xuan.structures.queue;

import java.util.Arrays;

// 循环队列
public class CircularQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;
    public CircularQueue(int capacity){
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    public CircularQueue(){
        this(10);
    }

    public boolean enqueue(E e){
        if (size == data.length ){
            return false;
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
        return true;
    }

    public E dequeue(){
        if (size == 0 ){
            throw new RuntimeException("Dequeue failed. Queue is empty.");
        }
        E res = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size-- ;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size ; i ++){
            sb.append(data[(head + i) % data.length]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        for (int i = 0; i < 10; i ++){
            System.out.println(queue.enqueue(i));
        }
        System.out.println(queue);
        for (int i = 0; i < 5; i ++){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue);
        for (int i = 0; i < 5; i ++){
            System.out.println(queue.enqueue(i));
        }
        System.out.println(queue);
        for (int i = 0; i < 5; i ++){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue);
    }
}
