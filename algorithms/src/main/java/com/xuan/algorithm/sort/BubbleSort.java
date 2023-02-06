package com.xuan.algorithm.sort;

import java.util.Arrays;

/**
* @className BubbleSort
* @description 冒泡排序算法
* @author shuaichen
* @date 20:04 2023/2/6
* @version 1.0
* @since 1.0
*/
public class BubbleSort {
    private BubbleSort(){}

    /**
     * 冒泡排序算法
     * @param arr 数组
     * @param n 数组大小
     * @param <E> 可比较的对象
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i ++){
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j ++){
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,54,3,2,6,8,10};
        sort(arr,arr.length);
        System.out.println(Arrays.asList(arr));

    }
}
