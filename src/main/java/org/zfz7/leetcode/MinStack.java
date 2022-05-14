package org.zfz7.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {
  private int[] stack;
  private int nextOpen;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new int[10];
    nextOpen = 0;
    minStack = new Stack<>();
  }

  public void push(int val) {
    if (minStack.isEmpty() || minStack.peek() >= val) {
      minStack.push(val);
    }
    if (nextOpen >= stack.length) {
      int[] temp = new int[stack.length * 2];
      System.arraycopy(stack, 0, temp, 0, stack.length);
      stack = temp;
    }
    stack[nextOpen++] = val;
  }

  public void pop() {
    if(nextOpen - 1 < 0) return;
    if (!minStack.isEmpty() && minStack.peek() == stack[nextOpen - 1]) {
      minStack.pop();
    }
    nextOpen--;
  }

  public Integer top() {
    return nextOpen - 1 < 0 ? null : stack[nextOpen -1];
  }

  public Integer getMin() {
    return minStack.isEmpty() ? null : minStack.peek();
  }
}
