package com.gocoder.leetcode;


/**
 * 最长回文子串
 *
 * <p>#005 https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author gocoder
 */
public class L0005 {


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char t1 = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char t2 = s.charAt(j);
                if (t1 == t2 && (j - i) > (end - start) && check(s.substring(i, j + 1))) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private boolean check(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


//    public String longestPalindrome(String s) {
//        if (s == null) {
//            throw new IllegalArgumentException();
//        }
//        if (s.length() < 2) {
//            return s;
//        }
//        char[] arr = s.toCharArray();
//        int[] ret = new int[2];
//        for (int i = 0; i < arr.length; i++) {
//            i = loop(arr, i, ret);
//        }
//        return s.substring(ret[0], ret[1]);
//    }
//
//    private static int loop(char[] arr, int low, int[] ret) {
//        int high = low;
//        while (high < arr.length - 1 && arr[high + 1] == arr[low]) {
//            high++;
//        }
//        int res = high;
//
//        while (low >= 0 && high < arr.length && arr[low] == arr[high]) {
//            low--;
//            high++;
//        }
//        if (high - low - 1 > ret[1] - ret[0]) {
//            ret[1] = high;
//            ret[0] = low + 1;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        L0005 solution = new L0005();
        // 3211123
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome("12332111231"));
        System.out.println(solution.longestPalindrome("abacdfgdcaba"));
    }

}
