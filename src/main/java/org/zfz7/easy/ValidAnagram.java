package org.zfz7.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ValidAnagram {
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
}
