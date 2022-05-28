package org.zfz7.leetcode;

import java.util.ArrayList;
import java.util.List;

class Pair {
  public int key;
  public int value;
  public List<Pair> neighbors;
  public Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }
}