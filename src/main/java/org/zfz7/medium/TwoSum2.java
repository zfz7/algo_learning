package org.zfz7.medium;

public class TwoSum2 {
  //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
  public static int[] twoSum(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      if (numbers[start] + numbers[end] == target) {
        return new int[]{start+1, end+1};
      }
      if (numbers[start] + numbers[end]  > target) {
        end--;
        continue;
      }
      if (numbers[start] + numbers[end]  < target) {
        start++;
        continue;
      }
    }
    //The tests are generated such that there is exactly one solution.
    return null;
  }
}
