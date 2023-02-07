package com.xuan.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
* @className QuickSort
* @description TODO
* @author shuaichen
* @date 21:41 2023/2/7
* @version 1.0
* @since 1.0
*/
public class QuickSort {
    private QuickSort(){}
    public static void sort(Integer[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if (l >= r) return;
        int q = partition(arr, l, r);
        sort(arr, l, q - 1);
        sort(arr, q + 1, r);
    }

    private static int partition(Integer[] arr, int l, int r) {
        int p = new Random().nextInt(r - l + 1) + l;
        swap(arr, r, p);
        int i = l, j = r - 1;
        while (true){
            while (i <= j && arr[i] < arr[r]){i++;}
            while (i <= j && arr[j] > arr[r]){j--;}
            if (i >= j){
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(Integer[] arr, int i, int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,54,3,2,6,8,10};
        sort(arr);
        System.out.println(Arrays.asList(arr));
    }

}
