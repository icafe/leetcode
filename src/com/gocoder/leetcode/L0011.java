package com.gocoder.leetcode;


/**
 * 盛最多水的容器
 *
     * <p>#011 https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author gocoder
 */
public class L0011 {


    public int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            // 优先调整短的线段 因为同等条件下移动指向较短线段的指针尽管造成了矩形宽度的减小 但却可能会有助于面积的增大
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }


    public static void main(String[] args) {
        L0011 solution = new L0011();
        solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

}
