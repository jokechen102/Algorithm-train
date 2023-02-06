package com.xuan.structures.linked;

/**
 * @author shuaichen
 * @version 1.0
 * @className LinkedList
 * @description TODO
 * @date 11:53 2023/2/5
 * @since 1.0
 */
public class LinkedList<E> {
    class Node {
        private Node next;
        private Node prev;
        private E value;

        public Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public Node(E value) {
            this(null, null, value);
        }

        public Node() {
            this(null, null, null);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        if (size == 0){
            head = temp;
            tail = head;
        }else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    public void addLast(E e) {
        if (size == 0) {
            addFirst(e);
        } else {
            tail.next = new Node(null, tail, e);
            tail = tail.next;
            size ++;
        }
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        Node prev = head;
        if (index == 0) {
            addFirst(e);
        } else if (index == size){
            addLast(e);
        } else {
            for (int i = 1; i < index; i++) {
                prev = prev.next;
            }
            Node temp = prev.next;
            prev.next = new Node(temp, prev, e);
            size++;
        }
    }


    public int find(E e) {
        Node cur = head;
        int index = 0;
        while (cur.next != null) {
            if (e.equals(cur.value)) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    public boolean contains(E e) {
        return find(e) != -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index \"" + index + "\" is illegal.");
        }
        if (index == 0) {
            E res = head.value;
            head = head.next;
            size--;
            return res;
        }
        Node cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        E res = cur.value;
        cur.prev.next = cur.next;
        size--;
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        Node cur;
        E res;
        if (index < size / 2) {
            cur = head;
            int i = 0;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            res = cur.value;

        } else {
            cur = tail;
            int i = size - 1;
            while (i > index) {
                cur = cur.prev;
                i--;
            }
            res = cur.value;
        }
        return res;
    }

    public E getFirst(){
        return head.value;
    }

    public E getLast(){
        return tail.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        for (int i = 0; i < size; i++) {
            sb.append(cur.value);
            if (i != size - 1) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        arr.add(1, 11);
        arr.add(11, 12);
        System.out.println(arr);
        System.out.println(arr.get(3));
        System.out.println(arr.get(6));
        System.out.println(arr.getLast());

    }

}
