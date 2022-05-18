package org.zfz7.leetcode;

import java.util.Arrays;

class KthLargest {
  int k;
  int dessendingList[];
  public KthLargest(int k, int[] nums) {
    this.k = k;
    dessendingList = new int[k];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1; j++) {
        if(nums[i] > nums[j]){
          int temp= nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
    for (int i = 0 ; i < dessendingList.length; i++) {
      dessendingList[i] = (i >= nums.length) ? Integer.MIN_VALUE: nums[i];
    }
  }


  public int add(int val) {
    int pleaseInsertMe = val;
    int temp;
    for (int i = 0; i < dessendingList.length; i++) {
      if(pleaseInsertMe < dessendingList[i]) continue;
      temp = dessendingList[i];
      dessendingList[i] = pleaseInsertMe;
      pleaseInsertMe = temp;
    }
    return dessendingList[dessendingList.length-1];
  }
}