package com.zewe.zeweleetcode.offer.p57;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/15 10:58
 */
public class TwoSum {

    /**
     * 正序排序数字 可用左右双指针 对撞
     * 若 nums[left] + nums[right] > target 则 right -- ,左移值变小
     * 若 nums[left] + nums[right] < target 则 left ++ ,右移值变大
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }

    /**
     * 利用 hash 表 进行 值-位置存储
     * 若 当前值 + key = target 则瞒足条件
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> possitionMap = new HashMap<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            if (possitionMap.containsKey(target - nums[i])) {
                //return new int[]{i, possitionMap.get(target - nums[i])};
                return new int[]{nums[i], nums[possitionMap.get(target - nums[i])]};
            } else {
                possitionMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
