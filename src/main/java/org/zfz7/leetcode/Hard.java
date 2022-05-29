package org.zfz7.leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Hard {
  //https://leetcode.com/problems/sliding-window-maximum/
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    // Deque will store indices
    Deque<Integer> deque = new ArrayDeque<>();
    int left = 0, right = 0;

    while (right < nums.length) {
      // pop out smaller values from deque
      while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
        deque.removeLast();
      }
      deque.addLast(right);
      // remove left value from window
      if (left > deque.getFirst()) {
        deque.removeFirst();
      }

      if (right - left + 1 >= k) {
        result[left] = nums[deque.getFirst()];
        left++;
      }
      right++;
    }
    return result;
  }

}
