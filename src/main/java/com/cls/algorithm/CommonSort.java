package com.cls.algorithm;

import java.util.Arrays;

/**
 * @Author: m1343
 * @CreateTime: 2020/4/22
 * Description:
 */
public class CommonSort {

    /**
     * Bubble sort 冒泡排序
     * 将 比较小的数一 一冒泡出来
     */
    private static void bubbleSort(int[] preSorted){
        int length = preSorted.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (preSorted[i] > preSorted[j]){
                    int swap = preSorted[i];
                    preSorted[i] = preSorted[j];
                    preSorted[j] = swap;
                }
            }
        }
    }

    /**
     * Select sort 选择排序
     * 遍历 选择 相对小 的数 放在前面
     */
    private static void selectSort(int[] preSorted){
        int length = preSorted.length;
        for (int i = 0; i < length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (preSorted[minIndex] > preSorted[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = preSorted[i];
                preSorted[i] = preSorted[minIndex];
                preSorted[minIndex] = temp;
            }
        }

    }

    /**
     * Quick sort 快速排序
     * 1.以左边第一个为基准，
     * 2.左右边同时遍历，
     * 3.右边找到一个比基准小的数，然后等左边找到一个比基准大的数，两者进行交换
     * 4.不断地重复上述3遍历，直至 两者 在中间进行触碰时停止2遍历
     * 5.然后 基准值 交换 中间值 ， 再重新开始循环
     */
    private static void quickSort(int[] preSorted,int low,int high){
        int i,j,temp,t;
        if (low >= high){
            return;
        }
        i = low;
        j = high;
        // temp 就是基准位
        temp = preSorted[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=preSorted[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=preSorted[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = preSorted[j];
                preSorted[j] = preSorted[i];
                preSorted[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        preSorted[low] = preSorted[i];
        preSorted[i] = temp;
        //递归调用左半数组
        quickSort(preSorted, low, i-1);
        //递归调用右半数组
        quickSort(preSorted, i+1, high);
    }

    /**
     * Insertion sort 插入排序
     * 从左边循环，数 开始往前推， 若 数小于前一个数，进行交换，直至 该数 大于 前某个数则停止，进行交换，确认 该数 的最终位置
     * 例子 ： 1 3 4 8 2 12 10  假设 2 为 该数
     * 进行一次  1 3 4 2 8 12 10
     * 进行二次  1 3 2 4 8 12 10
     * 进行三次  1 2 3 4 8 12 10
     * 成功。
     */
    private static void insertionSort(int[] preSorted){
        int len;
        // 基本情况下的数组可以直接返回
        if(preSorted == null || (len = preSorted.length) == 0 || len == 1) {
            return ;
        }
        int current;
        for (int i = 0; i < len - 1; i++) {
            // 第一个数默认已排序，从第二个数开始
            current = preSorted[i + 1];
            // 前一个数的下标
            int preIdx = i;
            // 拿当前的数与之前已排序序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后挪一步
            while (preIdx >= 0 && current < preSorted[preIdx]) {
                preSorted[preIdx + 1] = preSorted[preIdx];
                preIdx--;
            }
            // while循环跳出说明找到了位置
            preSorted[preIdx + 1] = current;
        }
    }




    public static void main(String[] args) {
        int[] preSorted = new int[]{6,3,2,8,10,1,34,5,11};
//        bubbleSort(preSorted);
//        selectSort(preSorted);
//        quickSort(preSorted,0,preSorted.length-1);
        insertionSort(preSorted);
        Arrays.stream(preSorted).forEach(System.out::println);
    }

}
