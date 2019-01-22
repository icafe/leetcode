package com.gocoder.leetcode;


/**
 * Z 字形变换
 *
 * <p>#006 https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author gocoder
 */
public class L0006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int step = 2 * (numRows - 1);

        // 从0行开始
        for (int i = 0; i < numRows; i++) {
            // 每次跳过step长度
            for (int j = 0; j + i < len; j += step) {
                sb.append(s.charAt(j + i));
                // 最后一行不再添加
                if (i != 0 && i != numRows - 1 && j + step - i < len) {
                    sb.append(s.charAt(j + step - i));
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        L0006 solution = new L0006();
        System.out.println(solution.convert("1234567890", 5));
    }

}
