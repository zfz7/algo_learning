package org.zfz7.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MediumTest {

  @Test
  public void groupAnagramsTest() {
    ArrayList<List<String>> answer = new ArrayList<>();
    answer.add(List.of("tan", "nat"));
    answer.add(List.of("bat"));
    answer.add(List.of("eat", "tea", "ate"));
    assertEquals(Medium.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), answer);
  }

  @Test
  public void lengthOfLongestSubstringTest() {
    assertEquals(Medium.lengthOfLongestSubstring("abcabcbb"),3);
    assertEquals(Medium.lengthOfLongestSubstring("bbbbb"),1);
    assertEquals(Medium.lengthOfLongestSubstring("pwwkew"),3);
    assertEquals(Medium.lengthOfLongestSubstring(""),0);
    assertEquals(Medium.lengthOfLongestSubstring(" "),1);
    assertEquals(Medium.lengthOfLongestSubstring("au"),2);
    assertEquals(Medium.lengthOfLongestSubstring("dvdf"),3);
  }

  @Test
  public void twoSumTest() {
    assertArrayEquals(Medium.twoSum(new int[]{2,7,11,15}, 9),new int[]{1,2});
    assertArrayEquals(Medium.twoSum(new int[]{2,3,4}, 6),new int[]{1,3});
    assertArrayEquals(Medium.twoSum(new int[]{-1,0}, -1),new int[]{1,2});
  }
}
