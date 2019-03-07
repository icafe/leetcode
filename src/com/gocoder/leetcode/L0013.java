package com.gocoder.leetcode;


/**
 * 罗马数字转整数
 *
 * <p>#013 https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author gocoder
 */
public class L0013 {


    public int romanToInt(String s) {
        int result;
        char[] sc = s.toCharArray();
        result = toInt(sc[0]);

        for (int i = 1; i < s.length(); i++) {
            result += toInt(sc[i]);
            if (toInt(sc[i - 1]) < toInt(sc[i])) {
                result -= toInt(sc[i - 1]) * 2;
            }
        }
        return result;
    }

    private int toInt(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    public static void main(String[] args) {
        L0013 solution = new L0013();
        System.out.println(solution.romanToInt("MMXIV"));
        System.out.println(solution.romanToInt("CCXIV"));
    }

}
