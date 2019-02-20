package com.gocoder.leetcode;


/**
 * 整数转罗马数字
 *
 * <p>#012 https://leetcode-cn.com/problems/integer-to-roman/
 *
 * @author gocoder
 */
public class L0012 {


    public String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num / 1000] + c[(num / 100) % 10] + x[(num / 10) % 10] + i[num % 10];
    }


    public static void main(String[] args) {
        L0012 solution = new L0012();
        System.out.println(solution.intToRoman(2014));
        System.out.println(solution.intToRoman(214));
    }

}
