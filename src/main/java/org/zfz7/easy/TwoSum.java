package org.zfz7.easy;

import java.util.HashMap;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapOfSums = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(mapOfSums.containsKey(nums[i])){
                return new int[]{mapOfSums.get(nums[i]),i};
            }
            mapOfSums.put(target - nums[i], i);
        }
        return null;
    }

}
