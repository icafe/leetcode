package com.gocoder.leetcode;


/**
 * 字符串转换整数 (atoi)
 *
 * <p>#008 https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author gocoder
 */
public class L0008 {

    public int myAtoi(String str) {
        int len = str.length();
        int start = 0;
        Integer result = null;
        boolean negative = false;

        for (int i = 0; i < len; i++) {
            char tmp = str.charAt(i);

            // 判断符号与空格
            if (tmp == '+' || tmp == '-' || tmp == ' ') {
                // 如果已经读取的长度不等于当前索引 或者 读到数字后还有[+- ]直接跳出循环
                if (i != start || result != null) {
                    break;
                }

                if ('-' == tmp) {
                    negative = true;
                } else if ('+' == tmp) {
                    negative = false;
                } else {
                    start++;
                }
                continue;
            }

            int value = tmp - '0';
            if (value < 0 || value > 9) {
                break;
            }

            result = result == null ? 0 : result;
            // 判断最大值与最小值的最后一位
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10
                    && (negative && value > 8 || !negative && value > 7))) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + value;
            start++;
        }

        result = result == null ? 0 : result;
        return negative ? -result : result;
    }


    public static void main(String[] args) {
        L0008 solution = new L0008();
        System.out.println(solution.myAtoi("0+1"));
        System.out.println(solution.myAtoi("0-1"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("-2147483649"));
        System.out.println(solution.myAtoi("   +0 123"));
        System.out.println(solution.myAtoi("   + 0 123"));
        System.out.println(solution.myAtoi("   +1"));
        System.out.println(solution.myAtoi("   -1"));
        System.out.println(solution.myAtoi("   ++1"));
        System.out.println(solution.myAtoi("   --2"));
        System.out.println(solution.myAtoi("   -+3"));
        System.out.println(solution.myAtoi("   +-4"));
        System.out.println(solution.myAtoi(""));
        System.out.println(solution.myAtoi("a1"));
        System.out.println(solution.myAtoi("  +100+"));
        System.out.println(solution.myAtoi("-100000000000000000000"));
        System.out.println(solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        System.out.println(solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
    }

}
