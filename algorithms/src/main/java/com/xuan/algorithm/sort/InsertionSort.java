package com.xuan.algorithm.sort;

import java.util.Arrays;

/**
* @className InsertionSort
* @description 插入排序
* @author shuaichen
* @date 20:30 2023/2/6
* @version 1.0
* @since 1.0
*/

public class InsertionSort {
    private InsertionSort(){}

    /**
     * 插入排序
     * @param arr 数组
     * @param n 数组size
     * @param <E> 可比较
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int n){
        if (n <= 1) return;
        for (int i = 1; i < n; i ++){
            E value = arr[i];
            int j = i;
            for (; j > 0; j --){
                if (arr[j - 1].compareTo(value) > 0){
                    arr[j] = arr[j - 1];
                }else {
                    break;
                }
            }
            arr[j] = value;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,54,3,2,6,8,10};
        sort(arr,arr.length);
        System.out.println(Arrays.asList(arr));
        String name = "zhangsan";

    }

}
