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
    if (n == 0) return 0;
    if (n == 1) return 1;
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
    for (int i = cost.length - 3; i >= 0; i--) {
      cost[i] = Math.min(cost[i] + cost[i + 1], cost[i] + cost[i + 2]);
    }
    return Math.min(cost[0], cost[1]);
  }

  //https://leetcode.com/problems/maximum-subarray/
  public static int maxSubArray(int[] nums) {
    int max = nums[0];
    int sum = 0;
    for (int end = 0; end < nums.length; end++) {
      if (sum < 0) {
        sum = 0;
      }
      sum += nums[end];
      max = Math.max(sum, max);
    }
    return max;
  }

  //https://www.lintcode.com/problem/920/
  public static boolean canAttendMeetings(List<Interval> intervals) {
    List<Interval> sorted = new ArrayList<Interval>(intervals);
    sorted.sort((a, b) -> a.start - b.start);
    for (int i = 0; i < sorted.size() - 1; i++) {
      Interval current = sorted.get(i);
      Interval next = sorted.get(i + 1);
      System.out.println(current.start);
      if (current.start < next.start && next.start < current.end) return false;
    }
    return true;
  }

  public static boolean isHappy(int n) {
    HashSet<Integer> seen = new HashSet<>();
    seen.add(n);
    while (true) {
      int sum = 0;
      while (n > 0) {
        int digit = n % 10;
        sum += digit * digit;
        n = n / 10;
      }

      if (sum == 1) return true;
      if (seen.contains(sum)) return false;
      seen.add(sum);
      n = sum;
    }
  }

  public static int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] overflow = new int[digits.length + 1];
    overflow[0] = 1;
    return overflow;
  }

  ///https://leetcode.com/problems/single-number/
  public static int singleNumber(int[] nums) {
    int x = 0;
    for (int num : nums) {
      x = x ^ num;
    }
    return x;
  }

  //https://leetcode.com/problems/number-of-1-bits/
  public static int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >>> 1;
    }
    return count;
  }
//https://leetcode.com/problems/counting-bits/

  public static int[] countBits(int n) {
    int[] res = new int[n + 1];
    res[0] = 0;
    for (int i = 1; i <= n; i++) {
      res[i] = res[i >> 1] + (i & 1);
    }
    return res;
  }

  //https://leetcode.com/problems/reverse-bits/
  public static int reverseBits(int n) {
    int res = 0;
    for (int i = 31; i >= 0; i--) {
      res  = res<<1;
      if ((n & 1) == 1) {
        res = res + 1;
      }
      n = n >> 1;
    }
    return res;
  }
  //https://leetcode.com/problems/missing-number/
  public static int missingNumber(int[] nums) {
    int sum=0;
    int sumIfNotMissing=0;
    for (int i = 0; i <nums.length; i++) {
      sum+=nums[i];
      sumIfNotMissing += i;
    }
    sumIfNotMissing += nums.length;
    return sumIfNotMissing - sum;
  }
}

