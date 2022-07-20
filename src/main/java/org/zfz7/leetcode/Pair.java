package org.zfz7.leetcode;

import java.util.ArrayList;
import java.util.List;

class Pair<K,V> {
  public K key;
  public V value;
  public List<Pair> neighbors;
  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }
}