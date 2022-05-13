package org.zfz7.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupAnagramTest {

  @Test
  public void test1() {
    ArrayList<List<String>> answer = new ArrayList<>();
    answer.add(List.of("tan", "nat"));
    answer.add(List.of("bat"));
    answer.add(List.of("eat", "tea", "ate"));
    assertEquals(GroupAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), answer);
  }
}
