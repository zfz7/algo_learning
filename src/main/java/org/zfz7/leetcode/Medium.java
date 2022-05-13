package org.zfz7.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium {
  //https://leetcode.com/problems/group-anagrams/
  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> mapOfAnagrams = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] keyArray = strs[i].toCharArray();
      Arrays.sort(keyArray);
      String key = Arrays.toString(keyArray);
      if (mapOfAnagrams.containsKey(key)) {
        List<String> list = mapOfAnagrams.get(key);
        list.add(strs[i]);
      } else {
        ArrayList<String> newList = new ArrayList<>();
        newList.add(strs[i]);
        mapOfAnagrams.put(key, newList);
      }

    }
    return  new ArrayList<List<String>>(mapOfAnagrams.values());
  }

  //https://leetcode.com/problems/longest-substring-without-repeating-characters/
  public static int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> containsCharacter = new HashMap<>();
    int maxLength = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      if (containsCharacter.containsKey(s.charAt(right))) {
        left = Math.max(left, containsCharacter.get(s.charAt(right)) + 1);
      }
      containsCharacter.put(s.charAt(right), right);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
  public static int[] twoSum(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      if (numbers[start] + numbers[end] == target) {
        return new int[]{start+1, end+1};
      }
      if (numbers[start] + numbers[end]  > target) {
        end--;
        continue;
      }
      if (numbers[start] + numbers[end]  < target) {
        start++;
        continue;
      }
    }
    //The tests are generated such that there is exactly one solution.
    return null;
  }
}
