package org.zfz7.leetcode;

import java.util.*;

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

    while (current != null) {
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
    while (list1 != null || list2 != null) {
      if (list1 == null) {
        current.next = list2;
        break;
      }
      if (list2 == null) {
        current.next = list1;
        break;
      }
      if (list1.val < list2.val) {
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

  //  https://leetcode.com/problems/invert-binary-tree/
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode left = root.right;
    TreeNode right = root.left;
    root.left = invertTree(left);
    root.right = invertTree(right);
    return root;
  }

  //  https://leetcode.com/problems/maximum-depth-of-binary-tree/
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = 1 + maxDepth(root.left);
    int right = 1 + maxDepth(root.right);
    return Math.max(left, right);
  }

  // https://leetcode.com/problems/diameter-of-binary-tree/
  //The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
  //This path may or may not pass through the root.
  private static int treeDiameter;

  public static int diameterOfBinaryTree(TreeNode root) {
    treeDiameter = 0;
    maxHeight(root);
    return treeDiameter;
  }

  private static int maxHeight(TreeNode root) {
    if (root == null) return 0;
    int left = maxHeight(root.left);
    int right = maxHeight(root.right);
    treeDiameter = Math.max(left + right, treeDiameter);
    return Math.max(left, right) + 1;
  }

  //https://leetcode.com/problems/balanced-binary-tree/
  //a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    boolean left = isBalanced(root.left);
    boolean right = isBalanced(root.right);
    if (left && right) {//Balanced so far
      return Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1;
    }
    return false;
  }

  //https://leetcode.com/problems/same-tree/
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q == null) return false;
    if (p == null && q != null) return false;
    boolean val = p.val == q.val;
    if (!val) return false;
    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);
    return left && right;
  }

  //  https://leetcode.com/problems/subtree-of-another-tree/
  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    boolean currentIsSame = isSameTree(root, subRoot);
    boolean left = isSubtree(root.left, subRoot);
    boolean right = isSubtree(root.right, subRoot);
    return left || right || currentIsSame;
  }

  //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val <= root.val && q.val >= root.val) return root;
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
    return root;
  }

  //https://leetcode.com/problems/last-stone-weight/
  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    for (int stone : stones) {
      maxHeap.add(stone);
    }
    while (maxHeap.size() >= 2) {
      int a = maxHeap.poll();
      int b = maxHeap.poll();
      if (a == b) continue;
      maxHeap.add(a - b);
    }
    return maxHeap.size() >= 1 ? maxHeap.peek() : 0;
  }

  //https://leetcode.com/problems/climbing-stairs/
  public static int climbStairs(int n) {
      if(n == 0 ) return 0;
      if(n == 1 ) return 1;
      int one = 1;
      int two = 1;
      int temp;
      for (int i = 0; i < n - 1; i++) {
        temp = one;
        one = one + two;
        two = temp;
      }
      return one;
  }
//https://leetcode.com/problems/min-cost-climbing-stairs/
  public static int minCostClimbingStairs(int[] cost) {
    for (int i = cost.length - 3 ; i >= 0 ; i--) {
      cost[i] = Math.min(cost[i] + cost[i+1], cost[i] + cost[i+2]);
    }
    return Math.min(cost[0],cost[1]);
  }
}

