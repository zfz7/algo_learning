package org.zfz7.easy;

import java.util.HashSet;

public class ContainsDuplicate {
  //    https://leetcode.com/problems/contains-duplicate/
  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if(set.contains(nums[i])){
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }
}
