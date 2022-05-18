package org.zfz7.leetcode;

import java.util.Arrays;

class MaxHeap {
  private int k;
  public int[] heap;

  public MaxHeap(int k, int[] nums) {
    this.k = k;
    heapify(nums);
    this.heap = nums;
  }

  public static void heapify(int[] nums) {
    for (int index = nums.length - 1; index >= 0; index--) {
      int i = index;
      while(true) {
        Integer left = leftChild(i, nums);
        Integer right = rightChild(i, nums);
        int current = nums[i];
        if (current >= left && current >= right) break;
        if (left > right) {
          swap(i, leftChildIndex(i), nums);
          i = leftChildIndex(i);
        }
        if (right > left) {
          swap(i, rightChildIndex(i), nums);
          i = rightChildIndex(i);
        }
      }
    }
  }

  private static void swap(int a, int b, int[] nums) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private static Integer leftChild(int i, int[] arr) {
    return (leftChildIndex(i) >=  arr.length) ? Integer.MIN_VALUE : arr[leftChildIndex(i)];
  }

  private static int leftChildIndex(int i) {
    return 2 * i + 1;
  }

  private static Integer rightChild(int i, int[] arr) {
    return (rightChildIndex(i) >= arr.length) ? Integer.MIN_VALUE : arr[rightChildIndex(i)];
  }
  private static int rightChildIndex(int i) {
    return 2 * i + 2;
  }

  private static Integer parent(int i, int[] arr) {
    return arr[parentIndex(i)];
  }

  private static int parentIndex(int i) {
    return (int) Math.floor(i/2);
  }

  public void add(int val) {
    growArray();
    heap[heap.length -1] = val;
    int index = heap.length -1;
    while(parent(index, this.heap) <= this.heap[index]){
      swap(parentIndex(index), index, this.heap);
      index = parentIndex(index);
    }
  }

  private void growArray() {
    this.heap = Arrays.copyOf(heap, heap.length + 1);
  }
}