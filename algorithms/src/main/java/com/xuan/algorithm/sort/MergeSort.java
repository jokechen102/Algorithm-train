package com.xuan.algorithm.sort;

import java.util.Arrays;

/**
* @className MergeSort
* @description TODO
* @author shuaichen
* @date 20:56 2023/2/7
* @version 1.0
* @since 1.0
*/
public class MergeSort {
    private MergeSort(){}
    public static void sort(Integer[] arr){
        Integer[] temp = new Integer[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(Integer[] arr, int l, int r, Integer[] temp) {
        if (l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid] > arr[mid + 1]){
            merge(arr, l, mid, r, temp);
        }
    }

    public static void merge(Integer[] arr, int l, int mid, int r, Integer[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k < r + 1; k ++){
            if (i > mid){
                arr[k] = temp[j++];
            }else if (j > r){
                arr[k] = temp[i++];
            }else if (temp[i] <= temp[j]){
                arr[k] = temp[i++];
            }else {
                arr[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,54,3,2,6,8,10};
        sort(arr);
        System.out.println(Arrays.asList(arr));
//        Integer[] temp1 = {2,5,8,1,3,9};
//        Integer[] temp2= new Integer[6];
//        merge(temp1, 0, 2, 5, temp2);
//        System.out.println(Arrays.asList(temp1));

    }
}
