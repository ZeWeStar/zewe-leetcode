package com.zewe.zeweleetcode.offer.p17;

/**
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/12 9:49
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        Double dsize = Math.pow(Double.parseDouble("10"), Double.parseDouble(n + ""));
        int size = dsize.intValue() - 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        int[] res = printNumbers.printNumbers(1);
        System.out.printf("res: " + res);
    }
}
