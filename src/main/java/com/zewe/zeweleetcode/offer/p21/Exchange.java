package com.zewe.zeweleetcode.offer.p21;

import com.alibaba.fastjson.JSON;

/**
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/13 9:44
 */
public class Exchange {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return nums;
        }
        int temp;
        int left = 0, right = length - 1;
        while (left < right) {
            while ((left < length) && (nums[left] % 2 == 1)) { // 防越界 从左至右找 偶数
                left++;
            }
            while ((right >= 0) && (nums[right] % 2 == 0)) { // 防越界 从右至左 找奇数
                right--;
            }

            // 判断是否相互过界
            if (left > right) {
                break;
            }
            // 替换
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 6,3};
        Exchange exchange = new Exchange();
        exchange.exchange(nums);
        System.out.println("nums = " + JSON.toJSONString(nums));
    }
}
