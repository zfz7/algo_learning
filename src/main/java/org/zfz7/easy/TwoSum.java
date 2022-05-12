package org.zfz7.easy;

import java.util.HashMap;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        //Key: num[pos], value: pos
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int pos = 0; pos < nums.length; pos++) {
            if (values.containsKey(target - nums[pos])) {
                return new int[]{values.get(target - nums[pos]), pos};
            } else {
                values.put(nums[pos], pos);
            }
        }
        return null;
    }

}
