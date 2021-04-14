package com.zewe.zeweleetcode.questionlibrary.p62;

/**
 * 不同路径 - LeetCode p62
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/14 14:30
 */
public class UniquePaths {

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        // 将二维列表后用于缓存（目标2）
        int[][] res = new int[m][n];

        /**
         * 注：从【0,0】 先右走边界；或向下走边界 都只有一条路
         */
        for (int i = 0; i < m; i++) { // 向下走，遍历行
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) { // 向右走，遍历列
            res[0][j] = 1;
        }

        /**
         * [0,0] 已初始化为 1； 避免 i-1 与 j-1 则循环从 1 开始
         */
        for (int i = 1; i < m; i++) { // 外循环逐行计算（目标3）
            for (int j = 1; j < n; j++) { // 外循环逐行计算（目标3）
                // 状态方程（目标1），以及中间结果复用（目标2）
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[m - 1][n - 1]; // 从 [0,0] 走到 [m-1,n-1]
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int res = uniquePaths.uniquePaths(3, 7);
        System.out.println("res = " + res);
    }
}
