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
      if (set.contains(nums[i])) {
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
      if (mapOfSums.containsKey(nums[i])) {
        return new int[]{mapOfSums.get(nums[i]), i};
      }
      mapOfSums.put(target - nums[i], i);
    }
    return null;
  }

  //https://leetcode.com/problems/valid-anagram/
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] sCharsSorted = s.toCharArray();
    Arrays.sort(sCharsSorted);
    char[] tCharsSorted = t.toCharArray();
    Arrays.sort(tCharsSorted);
    for (int i = 0; i < sCharsSorted.length; i++) {
      if (sCharsSorted[i] != tCharsSorted[i]) return false;
    }
    return true;
  }

  //  https://leetcode.com/problems/valid-palindrome/
  public static boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;

    while (start <= end) {
      if (!Character.isLetterOrDigit(s.charAt(start))) {
        start++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(end))) {
        end--;
        continue;
      }
      if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
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

  //  https://leetcode.com/problems/binary-search/
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int index;
    while (left <= right) {
      index = ((right - left) / 2) + left;
      if (nums[index] == target) {
        return index;
      }
      if (target > nums[index]) {
        left = index + 1;
      }
      if (target < nums[index]) {
        right = index - 1;
      }
    }
    return -1;
  }
//  https://leetcode.com/problems/reverse-linked-list/
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode temp = null;

    while(current != null){
      temp = current;
      current = current.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }
//  https://leetcode.com/problems/merge-two-sorted-lists/
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(0, null);
    ListNode current = head;
    while (list1 !=null || list2 != null){
      if(list1 == null){
        current.next = list2;
        break;
      }
      if(list2 == null){
        current.next = list1;
        break;
      }
      if(list1.val < list2.val){
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }
    return head.next;
  }
}
