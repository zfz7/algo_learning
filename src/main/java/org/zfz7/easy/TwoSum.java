package easy;

import java.util.HashMap;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        //Key: num[pos], value: pos
        HashMap values = new HashMap<Integer, Integer>();
        for (int pos = 0; pos < nums.length; pos++) {
            if (values.containsKey(target - nums[pos])) {
                int[] result = {(int) values.get(target - nums[pos]), pos};
                return result;
            } else {
                values.put(nums[pos], pos);
            }
        }
        return null;
    }

}
