package com.gocoder.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * <p>#001 https://leetcode-cn.com/problems/two-sum/
 *
 * @author gocoder
 */
public class L0001 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        L0001 solution = new L0001();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
