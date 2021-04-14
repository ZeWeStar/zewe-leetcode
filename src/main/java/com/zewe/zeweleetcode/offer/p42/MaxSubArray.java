package com.zewe.zeweleetcode.offer.p42;

/**
 * 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/14 9:36
 */
public class MaxSubArray {

    /**
     * 定义状态 ：
     * 设动态规划列表 dp，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
     * 定义最大和 dp[i] 中必须包含元素 nums[i] ：保证 dp[i] 递推到 dp[i+1] 的正确性；如果不包含 nums[i] ，递推时则不满足题目的 连续子数组 要求。
     *
     *
     * 目标1：状态转移方程
     * dp[i] = dp[i-1] + nums[i];
     * 若 dp[i-1] < 0 则 dp[i-1] + nums[i] < nums[i]. 所以 dp[i-1] 应该舍弃。 dp[i] = nums[i]
     * 若 dp[i-1] > 0 则 dp[i-1] + nums[i] > nums[i]. dp[i] = dp[i-1] + nums[i]
     *
     * int cur, max;
     * if(dp[i-1] > 0){
     *     cur = cur + nums[i];
     * }else{
     *     cur = nums[i];
     * }
     * if(cur > max){
     *     max = cur
     * }
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int cur = 0; // nums[0] 的前值 nums[0-1] = 0, 目标2 缓存结果
        int max = nums[0];
        for(int i=0, length=nums.length; i<length; i++){ // 目标3 从小到大

            // 目标2 状态转移方程 并复用结果集
            if(cur > 0){
                cur = cur + nums[i];
            }else{
                cur = nums[i];
            }

            if(cur > max){
                max = cur;
            }
        }
        return max;
    }
}
