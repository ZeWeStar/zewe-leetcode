package com.zewe.zeweleetcode.offer.p57_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/15 11:38
 */
public class FindContinuousSequence {

    /**
     * 双指针 - 滑动窗口 - 从左向右移动 - 边界 left < right; right <=target
     * <p>
     * 连续正整数的和，初始化 头指针left=1, 尾指针right=2, 当前和cur=3
     * 若 cur < target 则 right 右移扩大窗口值
     * 若 cur > target 则 left 右移缩小窗口值
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        if (target < 3) { // 1,2 都不满足 含2个以上的连续数组
            return new int[][]{{}};
        }

        int[] res;
        int left = 1, right = 2, cur = 3;
        while (left < right) { // left 指针边界
            if (cur < target) {
                right++; // 右指针右移 ，窗口扩大
                if (right > target) { // 扩大right越界,结束
                    break;
                }
                cur = cur + right; // 当前窗口和
            } else if (cur > target) {
                left++; // 左指针右移，窗口缩小
                if (left >= right) { // 扩大left越界,结束
                    break;
                }
                cur = cur - (left - 1); // 当前窗口和
            } else {
                res = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    res[i - left] = i;
                }
                list.add(res);

                // 整个窗口右移
                left++;
                right++;
                cur = cur + right - (left - 1);
            }
        }

        return list.toArray(new int[0][]);
    }
}
