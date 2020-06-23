package com.cls.algorithm;

/**
 * @Author: m1343
 * @CreateTime: 2020/4/24
 * @Description:
 *
 *  1. ^(亦或运算) 针对二进制，相同的为0，不同的为1
 *  2. &（按位 与运算） 针对二进制，只要有一个为0，就为0，（只有两个都为1，结果位才为 1）
 *  3. | (按位 或运算) 针对二进制，只要有一个为1，就为1
 *  3. <<(向左位移) 针对二进制，转换成二进制后向左移，后面用0补齐
 *  4. >>(向右位移) 针对二进制，转换成二进制后向右移，
 *  5. >>>(无符号右移)  无符号右移，忽略符号位，空位都以0补齐
 *
 *
 *     Java 中 正数是用原码来表示的 ， 负数是用补码来表示的
 *     补码=反码+1
 *     以负数-5为例：
 *
 *     1.先将-5的绝对值转换成二进制，即为0000 0101；
 *
 *     2.然后求该二进制的反码，即为 1111 1010；
 *
 *     3.最后将反码加1，即为：1111 1011
 *
 *     所以Java中Integer.toBinaryString(-5)结果为11111111111111111111111111111011. Integer是32位(bit)的.
 *
 */
public class Swap {

    public static void main(String[] args) {
        int a = 11;
        int b = 15;
        swap(11,15);
        System.out.println();
        a =  100 >>> 3;
        System.out.println(a);
    }


    private static void swap(int a,int b){
        System.out.printf("a=%d, b=%d",a,b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("\na=%d, b=%d",a,b);
    }

    private static void swap2(int a ,int b){
        // 异或  ---  二进制算法  ，数字会自动转换为二进制进行运算
        // ^(亦或运算) ，针对二进制，相同的为0，不同的为1
        // a = a ^ b ^ b
        System.out.printf("a=%d, b=%d",a,b);
        a = b ^ a;  // b ^ a
        b = a ^ b;  // b ^ a ^ b
        a = a ^ b;
        System.out.printf("\na=%d, b=%d",a,b);
    }



}
