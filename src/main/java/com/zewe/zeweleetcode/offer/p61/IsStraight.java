package com.zewe.zeweleetcode.offer.p61;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/16 9:24
 */
@Slf4j
public class IsStraight {


    /**
     * nums.length = 5
     * 1、nums中不能有重复值
     * 2、max - min <= 4 ; max-min=4 连续， max-min<4 包含0
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int max = 0, min = 14;
        Set<String> set = new HashSet<>();
        for (int num : nums) {
            if(num == 0){ // 0 跳过
                continue;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (set.contains(String.valueOf(num))) {
                return false;
            } else {
                set.add(String.valueOf(num));
            }
        }

        if (max - min <= 4) {
            return true;
        }
        return false;
    }


    /**
     * nums.length = 5
     * 0 可以为任意数字
     * 可输入 1-13、0
     * <p>
     * 1、排序 （小到大）
     * 2、从第1个非0的遍历补位
     *
     * @param nums
     * @return
     */
    public boolean isStraight1(int[] nums) {
        sort(nums); // 正序排序
        int zero = 0; // 记录 0 数
        for (int i = 0, length = nums.length - 1; i < length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                if (nums[i] + 1 == nums[i + 1]) {
                    continue;
                } else {
                    // 相邻2数差距大于1 ，补位（防止 nums[i+1] = nums[i]）
                    if ((nums[i + 1] - nums[i] > 1) && (zero >= nums[i + 1] - nums[i] - 1)) {
                        zero = zero - (nums[i + 1] - nums[i] - 1);
                    } else {
                        return false; // 断层
                    }
                }
            }

        }
        return true;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void sort(int[] nums) {
        int temp;
        for (int i = 0, length = nums.length; i < length; i++) { // 外循环每次将本次最大值转移到最后
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) { // 两两比较
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 2, 5, 5};
        IsStraight isStraight = new IsStraight();
        boolean res = isStraight.isStraight(nums);
        log.info("res => {}", res);
    }
}
