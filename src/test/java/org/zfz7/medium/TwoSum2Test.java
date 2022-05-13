package org.zfz7.medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSum2Test {

  @Test
  public void test1() {
    assertArrayEquals(TwoSum2.twoSum(new int[]{2,7,11,15}, 9),new int[]{1,2});
    assertArrayEquals(TwoSum2.twoSum(new int[]{2,3,4}, 6),new int[]{1,3});
    assertArrayEquals(TwoSum2.twoSum(new int[]{-1,0}, -1),new int[]{1,2});
  }
}
