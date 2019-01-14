package com.gocoder.leetcode;

/**
 * 无重复字符的最长子串
 *
 * <p>#003 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author gocoder
 */
public class L0003 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int[] index = new int[128];

        for (int i = 0, j = 0; j < n; j++) {
            // 取子串起始位置
            i = Math.max(index[s.charAt(j)], i);
            // 取子串长度
            result = Math.max(result, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        L0003 solution = new L0003();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

}
