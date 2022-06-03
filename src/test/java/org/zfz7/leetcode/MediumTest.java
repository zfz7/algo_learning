package org.zfz7.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
    assertEquals(Medium.lengthOfLongestSubstring("abcabcbb"), 3);
    assertEquals(Medium.lengthOfLongestSubstring("bbbbb"), 1);
    assertEquals(Medium.lengthOfLongestSubstring("pwwkew"), 3);
    assertEquals(Medium.lengthOfLongestSubstring(""), 0);
    assertEquals(Medium.lengthOfLongestSubstring(" "), 1);
    assertEquals(Medium.lengthOfLongestSubstring("au"), 2);
    assertEquals(Medium.lengthOfLongestSubstring("dvdf"), 3);
  }

  @Test
  public void twoSumTest() {
    assertArrayEquals(Medium.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2});
    assertArrayEquals(Medium.twoSum(new int[]{2, 3, 4}, 6), new int[]{1, 3});
    assertArrayEquals(Medium.twoSum(new int[]{-1, 0}, -1), new int[]{1, 2});
  }

  @Test
  public void evalRPN() {
    assertEquals(Medium.evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9);
    assertEquals(Medium.evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6);
    assertEquals(Medium.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}), 22);
  }

  @Test
  public void isMatrixBinarySearch() {
    assertEquals(Medium.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3), true);
    assertEquals(Medium.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13), false);
    assertEquals(Medium.searchMatrix(new int[][]{{1}}, 1), true);
    assertEquals(Medium.searchMatrix(new int[][]{{1}}, 2), false);
    assertEquals(Medium.searchMatrix(new int[][]{{1, 3}}, 3), true);
  }

  @Test
  public void reorderList() {
    ListNode list1D = new ListNode(4);
    ListNode list1C = new ListNode(3, list1D);
    ListNode list1B = new ListNode(2, list1C);
    ListNode list1A = new ListNode(1, list1B);

    Medium.reorderList(list1A);
    assertEquals(list1A.val, 1);
    assertEquals(list1A.next.val, 4);
    assertEquals(list1A.next.next.val, 2);
    assertEquals(list1A.next.next.next.val, 3);
    assertEquals(list1A.next.next.next.next, null);
  }

  @Test
  public void reorderList1() {
    ListNode list1E = new ListNode(5);
    ListNode list1D = new ListNode(4, list1E);
    ListNode list1C = new ListNode(3, list1D);
    ListNode list1B = new ListNode(2, list1C);
    ListNode list1A = new ListNode(1, list1B);

    Medium.reorderList(list1A);
    assertEquals(list1A.val, 1);
    assertEquals(list1A.next.val, 5);
    assertEquals(list1A.next.next.val, 2);
    assertEquals(list1A.next.next.next.val, 4);
    assertEquals(list1A.next.next.next.next.val, 3);
    assertEquals(list1A.next.next.next.next.next, null);

  }

  @Test
  public void levelOrder() {
        /*
                 4
                / \
               /   \
              2     \
             / \     5
            1   3     \
                       6
         */
    TreeNode three = new TreeNode(3);
    TreeNode one = new TreeNode(1);
    TreeNode six = new TreeNode(6);
    TreeNode five = new TreeNode(5, null, six);
    TreeNode two = new TreeNode(2, one, three);
    TreeNode four = new TreeNode(4, two, five);
    ArrayList<List<Integer>> answer = new ArrayList<>();
    answer.add(List.of(4));
    answer.add(List.of(2, 5));
    answer.add(List.of(1, 3, 6));
    assertEquals(Medium.levelOrder(four), answer);

  }

  @Test
  public void kClosest() {
    assertArrayEquals(Medium.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1), new int[][]{{-2, 2}});
    assertArrayEquals(Medium.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2), new int[][]{{3, 3}, {-2, 4}});
  }

  @Test
  public void rob() {
    assertEquals(Medium.rob(new int[]{1, 2, 3, 1}), 4);
    assertEquals(Medium.rob(new int[]{2, 1, 1, 2}), 4);
    assertEquals(Medium.rob(new int[]{2, 7, 9, 3, 1}), 12);
  }

  @Test
  public void canJump() {
    assertEquals(Medium.canJump(new int[]{2, 3, 1, 1, 4}), true);
    assertEquals(Medium.canJump(new int[]{3, 2, 1, 0, 4}), false);
    assertEquals(Medium.canJump(new int[]{0}), true);
  }

  @Test
  public void jump() {
    assertEquals(Medium.jump(new int[]{2, 3, 1, 1, 4}), 2);
    assertEquals(Medium.jump(new int[]{2, 3, 0, 1, 4}), 2);
    assertEquals(Medium.jump(new int[]{0}), 0);
  }

  @Test
  public void insert() {
    System.out.println(Arrays.deepToString(Medium.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{4, 5})));
    assertArrayEquals(Medium.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{4, 5}), new int[][]{{1, 3}, {4, 5}, {6, 9}});

    System.out.println(Arrays.deepToString(Medium.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    assertArrayEquals(Medium.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}), new int[][]{{1, 5}, {6, 9}});
    assertArrayEquals(Medium.insert(new int[][]{{}}, new int[]{5, 7}), new int[][]{{5, 7}});
  }


  @Test
  public void multiply() {
    int[][] mx = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Medium.rotate(mx);
    assertArrayEquals(mx, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});

    int[][] mx1 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    Medium.rotate(mx1);
    assertArrayEquals(mx1, new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}});
  }

  @Test
  public void numIsland() {
    assertEquals(Medium.numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}}), 1);

    assertEquals(Medium.numIslands(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}}), 3);
  }

  @Test
  public void getSum() {
    assertEquals(Medium.getSum(2, 3), 5);
    assertEquals(Medium.getSum(2, 1), 3);
    assertEquals(Medium.getSum(20, 30), 50);
    assertEquals(Medium.getSum(4, -1), 3);
    assertEquals(Medium.getSum(-4, -1), -5);
    assertEquals(Medium.getSum(0, 0), 0);
    assertEquals(Medium.getSum(-12, -8), -20);
  }

  @Test
  public void reverse() {
    assertEquals(Medium.reverse(23), 32);
    assertEquals(Medium.reverse(120), 21);
    assertEquals(Medium.reverse(232), 232);
    assertEquals(Medium.reverse(-232), -232);
    assertEquals(Medium.reverse(1534236469), 0);
  }

  @Test
  public void subsets() {
    List<List<Integer>> res = Medium.subsets(new int[]{1, 2, 3});
    Integer[][] ans = new Integer[][]{{1, 2, 3}, {1, 2}, {1, 3}, {1}, {2, 3}, {2}, {3}, {}};
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }
  }

  @Test
  public void combinationSum() {
    List<List<Integer>> res = Medium.combinationSum(new int[]{2, 3, 6, 7}, 7);
    Integer[][] ans = new Integer[][]{{2, 2, 3}, {7}};

    System.out.println(res);
    System.out.println(Arrays.deepToString(ans));
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }
  }

  @Test
  public void productExceptSelf() {
    assertArrayEquals(Medium.productExceptSelf(new int[]{1, 2, 3, 4}), new int[]{24, 12, 8, 6});
  }

  @Test
  public void topKFrequent() {
    assertArrayEquals(Medium.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2), new int[]{1, 2});
  }

  @Test
  public void isValidSudoku() {
    assertEquals(Medium.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}), true);

    assertEquals(Medium.isValidSudoku(new char[][]
            {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                    {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                    {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                    {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                    {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                    {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                    {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}), false);
  }

  @Test
  public void threeSum() {
    List<List<Integer>> res = Medium.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    Integer[][] ans = new Integer[][]{{-1, -1, 2}, {-1, 0, 1}};
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }

    res = Medium.threeSum(new int[]{0, 0, 0, 0});
    ans = new Integer[][]{{0, 0, 0}};

    assertEquals(res.size(), ans.length);
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }


    res = Medium.threeSum(new int[]{-2, 0, 1, 1, 2});
    ans = new Integer[][]{{-2, 1, 1}, {-2, 0, 2}};

    assertEquals(res.size(), ans.length);
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }
  }

  @Test
  public void characterReplacement() {
    assertEquals(Medium.characterReplacement("ABAB", 2), 4);
    assertEquals(Medium.characterReplacement("AABABBA", 1), 4);
    assertEquals(Medium.characterReplacement("ABABBA", 1), 4);
    assertEquals(Medium.characterReplacement("AAAAA", 1), 5);
    assertEquals(Medium.characterReplacement("BAAA", 1), 4);
  }

  @Test
  public void checkInclusion() {
    assertEquals(Medium.checkInclusion("ab", "eidbaooo"), true);
    assertEquals(Medium.checkInclusion("ab", "eidboaoo"), false);
  }

  @Test
  public void maxArea() {
    assertEquals(Medium.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
    assertEquals(Medium.maxArea(new int[]{1, 1}), 1);
  }

  @Test
  public void pacificAtlantic() {
    List<List<Integer>> res = Medium.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    Integer[][] ans = new Integer[][]{{2, 2}, {1, 3}, {1, 4}, {0, 4}, {4, 0}, {3, 0}, {3, 1}};
    ;
    System.out.println(res);
    assertEquals(res.size(), ans.length);
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }

    res = Medium.pacificAtlantic(new int[][]{{10, 10, 10}, {10, 1, 10}, {10, 10, 10}});
    ans = new Integer[][]{{1, 0}, {2, 1}, {0, 0}, {2, 2}, {0, 1}, {1, 2}, {0, 2}, {2, 0}};
    System.out.println(res);
    assertEquals(res.size(), ans.length);
    for (int i = 0; i < ans.length; i++) {
      assertArrayEquals(res.get(i).toArray(), ans[i]);
    }
  }

  @Test
  public void generateParenthesis() {
    List<String> res = Medium.generateParenthesis(3);
    String[] ans = new String[]{"((()))","(()())","(())()","()(())","()()()"};
    System.out.println(res);
    assertEquals(res.size(), ans.length);
    assertArrayEquals(ans, res.toArray());
  }

}
