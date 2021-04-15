package com.zewe.zeweleetcode.offer.p50;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/15 10:06
 */
public class FirstUniqChar {

    /**
     * 循环1 哈希表统计字符串数量
     * 循环2 从字符串头部开始查找 第一个数量为 1 的值
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> cntMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        for (char c : chars) {
            if (cntMap.get(c).intValue() == 1) {
                return c;
            }
        }

        return ' ';
    }
}
