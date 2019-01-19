package com.gocoder.leetcode;


/**
 * 寻找两个有序数组的中位数
 *
 * <p>#004 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author gocoder
 */
public class L0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (helper(nums1, 0, nums2, 0, len / 2) + helper(nums1, 0, nums2, 0, len / 2 + 1))
                    / 2.0;
        }
        return helper(nums1, 0, nums2, 0, (len + 1) / 2);
    }

    private int helper(int[] nums1, int m, int[] nums2, int n, int k) {
        if (m >= nums1.length) {
            return nums2[n + k - 1];
        }
        if (n >= nums2.length) {
            return nums1[m + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[m], nums2[n]);
        }

        int p1 = m + k / 2 - 1;
        int p2 = n + k / 2 - 1;
        int mid1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
        int mid2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return helper(nums1, m + k / 2, nums2, n, k - k / 2);
        }
        return helper(nums1, m, nums2, n + k / 2, k - k / 2);
    }


    public static void main(String[] args) {
        L0004 solution = new L0004();
        System.out.println(
                solution.findMedianSortedArrays(new int[]{1, 2, 7, 8, 11, 23}, new int[]{5, 6}));
    }

}
