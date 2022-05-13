package org.zfz7.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

  @Test
  public void test1() {
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"),3);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"),1);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"),3);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(""),0);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(" "),1);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("au"),2);
    assertEquals(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf"),3);
  }
}