package org.zfz7.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EasyTest {

  @Test
  public void maxProfitTest() {
    assertEquals(Easy.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
    assertEquals(Easy.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
  }

  @Test
  public void containsDuplicateTest() {
    assertEquals(Easy.containsDuplicate(new int[]{1, 2, 3, 1}), true);
    assertEquals(Easy.containsDuplicate(new int[]{1, 2, 3, 4}), false);
    assertEquals(Easy.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}), true);
  }

  @Test
  public void twoSumTest() {
    int[] input = {2, 7, 18, 15};
    int[] output = Easy.twoSum(input, 9);

    assertEquals(output[0], 0);
    assertEquals(output[1], 1);
  }

  @Test
  public void isAnagramTest() {
    assertEquals(Easy.isAnagram("anagram", "nagaram"), true);
    assertEquals(Easy.isAnagram("rat", "car"), false);
    assertEquals(Easy.isAnagram("aacc", "ccac"), false);
  }

  @Test
  public void isPalindromeTest() {
    assertEquals(Easy.isPalindrome("A man, a plan, a canal: Panama"), true);
    assertEquals(Easy.isPalindrome("race a car"), false);
    assertEquals(Easy.isPalindrome(" "), true);
    assertEquals(Easy.isPalindrome("0P"), false);
  }

  @Test
  public void isValidTest() {
    assertEquals(Easy.isValid("()"), true);
    assertEquals(Easy.isValid("()[]{}"), true);
    assertEquals(Easy.isValid("[}"), false);
    assertEquals(Easy.isValid("["), false);
  }

  @Test
  public void isBinarySearch() {
    assertEquals(Easy.search(new int[]{-1, 0, 3, 5, 9, 12}, 9), 4);
    assertEquals(Easy.search(new int[]{-1, 0, 3, 5, 9, 12}, 4), -1);
    assertEquals(Easy.search(new int[]{-1, 0, 3, 5, 9, 12}, 2), -1);
    assertEquals(Easy.search(new int[]{1}, 1), 0);
    assertEquals(Easy.search(new int[]{1}, 2), -1);
  }

  @Test
  public void reverseList() {
    ListNode list1C = new ListNode(3);
    ListNode list1B = new ListNode(2, list1C);
    ListNode list1A = new ListNode(1, list1B);

    ListNode result = Easy.reverseList(list1A);
    assertEquals(result.val, 3);
    assertEquals(result.next.val, 2);
    assertEquals(result.next.next.val, 1);
    assertNull(result.next.next.next);
  }

  @Test
  public void mergeTwoList() {
    ListNode list1C = new ListNode(5);
    ListNode list1B = new ListNode(3, list1C);
    ListNode list1A = new ListNode(2, list1B);

    ListNode list2C = new ListNode(4);
    ListNode list2B = new ListNode(1, list2C);
    ListNode list2A = new ListNode(1, list2B);

    ListNode result = Easy.mergeTwoLists(list1A, list2A);
    assertEquals(result.val, 1);
    assertEquals(result.next.val, 1);
    assertEquals(result.next.next.val, 2);
    assertEquals(result.next.next.next.val, 3);
    assertEquals(result.next.next.next.next.val, 4);
    assertEquals(result.next.next.next.next.next.val, 5);
  }

  @Test
  public void invertTree() {
        /*
                 1
                / \
               /   \
              2     \
             / \     3
            4   5   / \
                   9   \
                        8
         */
    TreeNode A = new TreeNode(9);
    TreeNode B = new TreeNode(8);
    TreeNode C = new TreeNode(3, A, B);
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, C);
    root = Easy.invertTree(root);
    assertEquals(root.left.val, 3);
    assertEquals(root.left.left.val, 8);
    assertEquals(root.left.right.val, 9);

    assertEquals(root.right.val, 2);
    assertEquals(root.right.right.val, 4);
    assertEquals(root.right.left.val, 5);

  }

  @Test
  public void maxDepth() {
        /*
                1
               / \
              2   3
             / \
            4   5
         */
    TreeNode C = new TreeNode(3);
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, C);
    assertEquals(Easy.maxDepth(root), 3);
  }

  @Test
  public void diameterOfBinaryTree() {
        /*
                 1
                / \
               /   \
              2     \
             / \     3
            4   5
         */
    TreeNode C = new TreeNode(3);
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, C);
    assertEquals(Easy.diameterOfBinaryTree(root), 3);
  }

  @Test
  public void isBalanced() {
        /*
                 1
                / \
               /   \
              2     \
             / \     3
            4   5
         */
    TreeNode C = new TreeNode(3);
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, C);
    assertEquals(Easy.isBalanced(root), true);
  }

  @Test
  public void isBalanced1() {
        /*
                 1
                / \
               /   \
              2     \
             / \
            4   5
         */
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, null);
    assertEquals(Easy.isBalanced(root), false);
  }

  @Test
  public void isSameTree() {
        /*
                 1
                / \
               /   \
              2     \
             / \
            4   5
         */
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, null);
    assertEquals(Easy.isSameTree(D, D), true);
    assertEquals(Easy.isSameTree(root, root), true);
    assertEquals(Easy.isSameTree(root, D), false);
  }

  @Test
  public void isSubTree() {
        /*
                 1
                / \
               /   \
              2     \
             / \
            4   5
         */
    TreeNode T = new TreeNode(2);
    TreeNode D = new TreeNode(4);
    TreeNode E = new TreeNode(5);
    TreeNode F = new TreeNode(2, D, E);
    TreeNode root = new TreeNode(1, F, null);
    assertEquals(Easy.isSubtree(root, root), true);
    assertEquals(Easy.isSubtree(root, F), true);
    assertEquals(Easy.isSubtree(root, E), true);
    assertEquals(Easy.isSubtree(root, T), false);
  }

  @Test
  public void lowestCommonAncestor() {
        /*
                 4
                / \
               /   \
              2     \
             / \     5
            1   3
         */
    TreeNode three = new TreeNode(3);
    TreeNode one = new TreeNode(1);
    TreeNode five = new TreeNode(5);
    TreeNode two = new TreeNode(2, one, three);
    TreeNode four = new TreeNode(4, two, five);
    assertEquals(Easy.lowestCommonAncestor(four, one, three).val, 2);
    assertEquals(Easy.lowestCommonAncestor(four, three, five).val, 4);
    assertEquals(Easy.lowestCommonAncestor(four, four, three).val, 4);
    assertEquals(Easy.lowestCommonAncestor(four, four, four).val, 4);
  }

  @Test
  public void KthLargestTest() {
    KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
    assertArrayEquals(k.dessendingList, new int[]{8, 5, 4});
    assertEquals(k.add(3), 4);
    assertArrayEquals(k.dessendingList, new int[]{8, 5, 4});
    assertEquals(k.add(5), 5);
    assertArrayEquals(k.dessendingList, new int[]{8, 5, 5});
    assertEquals(k.add(10), 5);
    assertArrayEquals(k.dessendingList, new int[]{10, 8, 5});
    assertEquals(k.add(9), 8);
    assertArrayEquals(k.dessendingList, new int[]{10, 9, 8});
    assertEquals(k.add(4), 8);
    assertArrayEquals(k.dessendingList, new int[]{10, 9, 8});
  }

  @Test
  public void KthLargestTest1() {
    KthLargest k = new KthLargest(1, new int[]{});
    assertEquals(k.add(-3), -3);
    assertArrayEquals(k.dessendingList, new int[]{-3});

    assertEquals(k.add(-2), -2);
    assertEquals(k.add(-4), -2);
    assertEquals(k.add(0), 0);
    assertEquals(k.add(4), 4);
  }

  @Test
  public void lastStoneWeight() {
    assertEquals(Easy.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}), 1);
    assertEquals(Easy.lastStoneWeight(new int[]{1, 3}), 2);
  }

  @Test
  public void climbStairs() {
    assertEquals(Easy.climbStairs(2), 2);
    assertEquals(Easy.climbStairs(3), 3);
    assertEquals(Easy.climbStairs(4), 5);
  }

  @Test
  public void minCostClimbingStairs() {
    assertEquals(Easy.minCostClimbingStairs(new int[]{10, 15, 20}), 15);
    assertEquals(Easy.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}), 6);
  }

  @Test
  public void maxSubArray() {
    assertEquals(Easy.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    assertEquals(Easy.maxSubArray(new int[]{1}), 1);
    assertEquals(Easy.maxSubArray(new int[]{5, 4, -1, 7, 8}), 23);
  }

  @Test
  public void canAttendMeetings() {
    assertEquals(Easy.canAttendMeetings(List.of(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20))), false);
    assertEquals(Easy.canAttendMeetings(List.of(new Interval(5, 8), new Interval(9, 15))), true);
    assertEquals(Easy.canAttendMeetings(List.of(new Interval(5, 10), new Interval(9, 15))), false);
    assertEquals(Easy.canAttendMeetings(List.of(new Interval(5, 10))), true);
  }

  @Test
  public void isHappy() {
    assertEquals(Easy.isHappy(19), true);
    assertEquals(Easy.isHappy(2), false);
    assertEquals(Easy.isHappy(1), true);
  }

  @Test
  public void plusOne() {
    assertArrayEquals(Easy.plusOne(new int[]{1, 2, 3}), new int[]{1, 2, 4});
    assertArrayEquals(Easy.plusOne(new int[]{1, 2, 9}), new int[]{1, 3, 0});
    System.out.println(Arrays.toString(Easy.plusOne(new int[]{9})));
    assertArrayEquals(Easy.plusOne(new int[]{9}), new int[]{1, 0});
  }

  @Test
  public void singleNumer() {
    assertEquals(Easy.singleNumber(new int[]{2, 2, 1}), 1);
    assertEquals(Easy.singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
    assertEquals(Easy.singleNumber(new int[]{1}), 1);
  }

  @Test
  public void hammingWeight() {
    assertEquals(Easy.hammingWeight(3), 2);
    assertEquals(Easy.hammingWeight(1), 1);
    assertEquals(Easy.hammingWeight(-3), 31);
  }

  @Test
  public void countBits() {
    assertArrayEquals(Easy.countBits(0), new int[]{0});
    assertArrayEquals(Easy.countBits(1), new int[]{0, 1});
    assertArrayEquals(Easy.countBits(2), new int[]{0, 1, 1});
    assertArrayEquals(Easy.countBits(5), new int[]{0, 1, 1, 2, 1, 2});
    assertArrayEquals(Easy.countBits(8), new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1});
  }

  @Test
  public void reverseBits() {
    assertEquals(Easy.reverseBits(43261596), 964176192);
    assertEquals(Easy.reverseBits(43261596), 964176192);
  }
}
