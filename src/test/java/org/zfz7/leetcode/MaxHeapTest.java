package org.zfz7.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MaxHeapTest {

  @Test
  public void testHeapify() {
    int[] nums = new int[]{3, 9, 2, 1, 4, 5};
    System.out.println(Arrays.toString(nums));
    MaxHeap.heapify(nums);
    System.out.println(Arrays.toString(nums));
    assertArrayEquals(new int[]{9, 4, 5, 1, 3, 2}, nums);
  }

  @Test
  public void testAdd() {
    MaxHeap maxHeap = new MaxHeap(3, new int[]{3, 9, 2, 1, 4, 5});
    assertArrayEquals(new int[]{9, 4, 5, 1, 3, 2}, maxHeap.heap);
    maxHeap.add(2);
    assertArrayEquals(new int[]{9, 4, 5, 2, 3, 2, 1}, maxHeap.heap);
  }
}