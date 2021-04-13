package com.zewe.zeweleetcode.offer.p17;

/**
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/12 14:09
 */
public class PrintNumbers2 {

    private StringBuilder builder;
    private int n;
    private char[] nums;
    private char[] loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int[] res;
    private int count = 0;

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }

        this.builder = new StringBuilder();
        this.n = n;
        nums = new char[n]; // 定义n位字符串集
        int size = (int) Math.pow(10, n);
        res = new int[size - 1];
        dfs(0); // 从第0位开始
        String resStr = builder.deleteCharAt(builder.length() - 1).toString(); // 去除末尾 ,
        return res;
    }

    /**
     * 递归 全排序
     *
     * @param x 从 0 开始到 n 结束， [0, n-1]
     */
    private void dfs(int x) {
        if (x == n) { // 递归终止条件 从 0 开始到 n 结束， [0, n-1]
            //System.out.println("dfs = " + String.valueOf(nums));
            String numStr = String.valueOf(nums);
            int num = Integer.parseInt(numStr);
            if (num != 0) { // 从 1 开始，则0跳过
                builder.append(numStr + ",");
                res[count] = num;
                count++;
            }
            return;
        }
        for (char i : loop) { // 先固定高位然后从 最低一位 慢慢进位
            nums[x] = i; // 固定第x位为i
            dfs(x + 1); // 固定第x+1位
        }
    }

    public static void main(String[] args) {
        PrintNumbers2 printNumbers2 = new PrintNumbers2();
        int[] printNumbers = printNumbers2.printNumbers(2);
        System.out.println("res = " + printNumbers);
    }

}
