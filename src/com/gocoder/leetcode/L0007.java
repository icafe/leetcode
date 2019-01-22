package com.gocoder.leetcode;


/**
 * 整数反转
 *
 * <p>#007 https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author gocoder
 */
public class L0007 {

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE
                ? 0
                : (int) result;
    }


    public static void main(String[] args) {
        L0007 solution = new L0007();
        System.out.println(solution.reverse(123));
    }

}
