package org.zfz7.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HardTest {
  @Test
  public void maxSlidingWindow() {
    assertArrayEquals(Hard.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3),
            new int[]{3, 3, 5, 5, 6, 7});

    assertArrayEquals(Hard.maxSlidingWindow(new int[]{1,-1}, 1), new int[]{1,-1});
  }
}
