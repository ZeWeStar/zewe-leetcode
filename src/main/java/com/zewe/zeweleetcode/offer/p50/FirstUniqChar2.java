package com.zewe.zeweleetcode.offer.p50;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class FirstUniqChar2 {

    /**
     * 循环1：利用 有序 hash表有序存key值， 遇到重复（即key存在）则value=false, 第一次（即key不存在）则value=true
     * 循环2：遍历 有序 hash表 找出第一个 value=true 的key值
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return ' ';
        }

        Map<Character, Boolean> sortMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sortMap.put(c, !sortMap.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> kv : sortMap.entrySet()) {
            if (kv.getValue()) {
                return kv.getKey();
            }
        }

        return ' ';
    }
}
