package com.zewe.zeweleetcode.learn.dynamicprogramming;

/**
 * 斐波那契数列
 * <p>
 * 斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233……。它遵循这样的规律：当前值为前两个值的和。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/14 12:14
 */
public class FibonacciSequence {

    /**
     * 递归方式 O(2^n)
     *
     * @param n
     * @return
     */
    public int recursion(int n) {
        if (n < 2) { // 0、1
            return n;
        }
        return recursion(n - 2) + recursion(n - 1);
    }

    /**
     * 动态规划 O(n)
     *
     * @param n
     * @return
     */
    public int dynamic(int n) {
        int length = n + 1;
        int[] res = new int[length]; // 用于缓存以往结果，以便复用 (目标2)

        for (int i = 0; i < length; i++) { //按顺序从小往大算 (目标3)
            if (i < 2) {
                res[i] = i;
            } else {
                // 使用状态转移方程（目标1），同时复用以往结果（目标2）
                res[i] = res[i - 1] + res[i - 2];
            }
        }

        return res[n];
    }

    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();
        //int res = sequence.recursion(100);
        //System.out.println("res = "+res);
        int res1 = sequence.dynamic(100);
        System.out.println("res1 = "+res1);
    }


}
