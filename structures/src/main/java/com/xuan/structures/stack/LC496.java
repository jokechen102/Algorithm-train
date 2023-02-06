package com.xuan.structures.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >=0; i --){
            while (!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        LC496 lc496 = new LC496();
        System.out.println(Arrays.toString(lc496.nextGreaterElement(nums1, nums2)));
    }
}
