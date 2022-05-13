package org.zfz7.easy;

import java.util.Stack;

public class ValidParentheses {
  //https://leetcode.com/problems/valid-parentheses/
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
        continue;
      }
      if (c == '}' && !stack.isEmpty() && stack.peek() == '{' ||
          c == ')' && !stack.isEmpty() && stack.peek() == '(' ||
          c == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
        continue;
      }
      return false;
    }

    return stack.isEmpty();
  }
}
