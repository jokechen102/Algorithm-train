package com.xuan.algorithm.sort;

import java.util.Arrays;

/**
* @className SelectionSort
* @description TODO
* @author shuaichen
* @date 20:54 2023/2/6
* @version 1.0
* @since 1.0
*/
public class SelectionSort {
    private SelectionSort(){}

    /**
     * 选择排序
     * @param arr 数组
     * @param n size
     * @param <E> 可比较
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i ++){
            int minIndex = i;
            for (int j = i; j < n; j ++){
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }

    }

    private static <E extends Comparable<E>>void swap(E[] arr, int i, int minIndex) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,54,3,2,6,8,10};
        sort(arr,arr.length);
        System.out.println(Arrays.asList(arr));

    }
}
