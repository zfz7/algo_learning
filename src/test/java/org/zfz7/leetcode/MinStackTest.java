package org.zfz7.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {
  @Test
  public void minStack() {
    MinStack stack = new MinStack();

    assertEquals(stack.getMin(), null);
    stack.push(-2);
    stack.push(0);
    stack.push(-3);
    assertEquals(stack.getMin(), Integer.valueOf(-3));
    stack.pop();
    assertEquals(stack.top(), Integer.valueOf(0));
    assertEquals(stack.getMin(), Integer.valueOf(-2));
  }

  @Test
  public void minStack1() {
    MinStack stack = new MinStack();

    stack.push(0);
    stack.push(1);
    stack.push(0);
    assertEquals(stack.getMin(), Integer.valueOf(0));
    stack.pop();
    assertEquals(stack.getMin(), Integer.valueOf(0));
  }

  @Test
  public void minStack2() {
    MinStack stack = new MinStack();

    stack.push(2);
    stack.push(0);
    stack.push(3);
    stack.push(0);
    assertEquals(stack.getMin(), Integer.valueOf(0));
    stack.pop();
    assertEquals(stack.getMin(), Integer.valueOf(0));
    stack.pop();
    assertEquals(stack.getMin(), Integer.valueOf(0));
    stack.pop();
    assertEquals(stack.getMin(), Integer.valueOf(2));
  }

  @Test
  public void minStack3() {
    MinStack stack = new MinStack();
    stack.push(-1);
    assertEquals(stack.top(), Integer.valueOf(-1));
    assertEquals(stack.getMin(), Integer.valueOf(-1));
  }

  @Test
  public void minStack4() {
    MinStack stack = new MinStack();
    stack.push(-1);
    assertEquals(stack.top(), Integer.valueOf(-1));
    assertEquals(stack.top(), Integer.valueOf(-1));
    assertEquals(stack.getMin(), Integer.valueOf(-1));
  }

}
