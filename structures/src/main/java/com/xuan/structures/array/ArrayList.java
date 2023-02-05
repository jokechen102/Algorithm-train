package com.xuan.structures.array;

/**
* @className ArrayList
* @description 动态数组
* @author shuaichen
* @date 10:39 2023/2/5
* @version 1.0
* @since 1.0
*/
public class ArrayList<E> {
    private E[] data;
    private int size;
    public ArrayList(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }
    public ArrayList(){
        this(10);
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index is out of bound.");
        }
        return data[index];
    }
    public int getCapacity(){
        return data.length;
    }

    public boolean contains(E e){
        if (size == 0){
            return false;
        }
        for (int i = 0; i < size; i ++){
            if (e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("index is out of bound.");
        }
        if (size == data.length){
            resize(size * 2);
        }
        for (int i = size;  i > index; i --){
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public int find(E e){
        for (int i = 0; i < size; i ++){
            if (e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index is illeagal. remove failed.");
        }
        E ret = data[index];
        for (int i = index ; i < size - 1 ; i ++){
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size --;
        if (size == data.length/ 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if (index == -1 ) {
            throw new IllegalArgumentException("Element is not found. remove failed.");
        }
        remove(index);

    }

    private void resize(int capactiy) {
        capactiy = Math.max(capactiy, 10);
        E[] temp = (E[]) new Object[capactiy];
        for (int i = 0 ; i < size; i ++){
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i ++){
            sb.append(data[i]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);
        System.out.println(arr.getCapacity());

        arr.add(1, 100);
        System.out.println(arr);
        System.out.println(arr.getCapacity());

        arr.addFirst(-1);
        System.out.println(arr);
        System.out.println(arr.getCapacity());

        arr.remove(2);
        System.out.println(arr);
        System.out.println(arr.getCapacity());

        arr.removeElement(4);
        System.out.println(arr);
        System.out.println(arr.getCapacity());

        arr.removeFirst();
        System.out.println(arr);
        System.out.println(arr.getCapacity());
    }

}
