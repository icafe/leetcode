package com.gocoder.leetcode;


/**
 * 回文数
 *
 * <p>#009 https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author gocoder
 */
public class L0009 {


    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int halfReverse = 0;

        // 判断反转数字的位数是否达到原始数字位数的一半
        while (x > halfReverse) {
            halfReverse = halfReverse * 10 + x % 10;
            x /= 10;
        }

        return x == halfReverse || x == halfReverse / 10;
    }


    public static void main(String[] args) {
        L0009 solution = new L0009();
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(10010));

        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(2112));
        System.out.println(solution.isPalindrome(212112));
    }

}
