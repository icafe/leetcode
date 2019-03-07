package com.gocoder.leetcode;


/**
 * 最长公共前缀
 *
 * <p>#014 https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author gocoder
 */
public class L0014 {


    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        for (int j = 0; j < minLen; j++) {
            for (int i = 1; i < len; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        L0014 solution = new L0014();
        System.out.println(solution.longestCommonPrefix(new String[]{"aa", "abcd", "a"}));
    }

}
