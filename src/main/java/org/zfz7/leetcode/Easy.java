package org.zfz7.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Easy {
//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  public static int maxProfit(int[] prices) {
    //Buy low sell high
    int maxProfit = 0;
    int left = 0;
    int right = 0;
    while (right < prices.length) {
      int profit = prices[right] - prices[left];
      if (profit > maxProfit) {
        maxProfit = profit;
      } else if (profit < 0) {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }

  //    https://leetcode.com/problems/contains-duplicate/
  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if(set.contains(nums[i])){
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }

  // https://leetcode.com/problems/two-sum/
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> mapOfSums = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if(mapOfSums.containsKey(nums[i])){
        return new int[]{mapOfSums.get(nums[i]),i};
      }
      mapOfSums.put(target - nums[i], i);
    }
    return null;
  }

  //https://leetcode.com/problems/valid-anagram/
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] sCharsSorted =  s.toCharArray();
    Arrays.sort(sCharsSorted);
    char[] tCharsSorted =  t.toCharArray();
    Arrays.sort(tCharsSorted);
    for(int i = 0; i< sCharsSorted.length; i++){
      if(sCharsSorted[i] != tCharsSorted[i]) return false;
    }
    return true;
  }
  //  https://leetcode.com/problems/valid-palindrome/
  public static boolean isPalindrome(String s) {
    int start =0;
    int end = s.length() - 1;

    while(start <= end){
      if(!Character.isLetterOrDigit(s.charAt(start))){
        start++;
        continue;
      }
      if(!Character.isLetterOrDigit(s.charAt(end))){
        end--;
        continue;
      }
      if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

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
