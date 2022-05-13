package org.zfz7.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {
  @Test
  public void test1(){
    assertEquals(ValidParentheses.isValid("()"), true);
    assertEquals(ValidParentheses.isValid("()[]{}"), true);
    assertEquals(ValidParentheses.isValid("[}"), false);
    assertEquals(ValidParentheses.isValid("["), false);
  }
}