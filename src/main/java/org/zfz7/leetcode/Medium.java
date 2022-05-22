package org.zfz7.leetcode;

import java.util.*;

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
    return new ArrayList<List<String>>(mapOfAnagrams.values());
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
        return new int[]{start + 1, end + 1};
      }
      if (numbers[start] + numbers[end] > target) {
        end--;
        continue;
      }
      if (numbers[start] + numbers[end] < target) {
        start++;
        continue;
      }
    }
    //The tests are generated such that there is exactly one solution.
    return null;
  }

  //https://leetcode.com/problems/evaluate-reverse-polish-notation/
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (Objects.equals(token, "+")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b + a);
        continue;
      }
      if (Objects.equals(token, "-")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b - a);
        continue;
      }
      if (Objects.equals(token, "*")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b * a);
        continue;
      }
      if (Objects.equals(token, "/")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b / a);
        continue;
      }
      stack.push(Integer.parseInt(token));
    }
    return stack.peek();
  }

  //  https://leetcode.com/problems/search-a-2d-matrix/submissions/
  public static boolean searchMatrix(int[][] matrix, int target) {
    int left = 0;
    int right = (matrix.length) * (matrix[0].length) - 1;
    int col;
    int row;
    while (left <= right) {
      int index = ((right - left) / 2) + left;
      row = index / matrix[0].length;
      col = index - (row * matrix[0].length);
      if (matrix[row][col] == target) {
        return true;
      }
      if (target > matrix[row][col]) {
        left = row * matrix[0].length + col + 1;
      }
      if (target < matrix[row][col]) {
        right = row * matrix[0].length + col - 1;
      }
    }
    return false;
  }

  public static void reorderList(ListNode head) {
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode current = head;
    int index = 0;
    while (current != null) {
      map.put(index, current);
      index++;
      current = current.next;
    }
    --index;
    for (int i = 0; i < index / 2; i++) {
      map.get(i).next = map.get(index - i);
      map.get(index - i).next = map.get(i + 1);
    }
    map.get((int) Math.ceil(((double) index) / 2)).next = null;
  }

  static List<List<Integer>> levelOrder;

  public static List<List<Integer>> levelOrder(TreeNode root) {
    levelOrder = new ArrayList<>();
    createLevelOrder(root, 0);
    return levelOrder;
  }

  private static void createLevelOrder(TreeNode root, int index) {
    if (root == null) return;
    if (levelOrder.size() <= index) {
      levelOrder.add(index, new ArrayList<>());
    }
    levelOrder.get(index).add(root.val);
    createLevelOrder(root.left, index + 1);
    createLevelOrder(root.right, index + 1);
  }

  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (Math.sqrt(a[0] * a[0] + a[1] * a[1]) - Math.sqrt(b[0] * b[0] + b[1] * b[1]) > 0) ? 1 : -1);
    for (int[] point : points) {
      minHeap.add(point);
    }
    int[][] result = new int[k][2];

    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll();
    }
    return result;
  }

  //https://leetcode.com/problems/house-robber/
  public static int rob(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Math.max(nums[i] + (((i - 2) < 0) ? 0 : nums[i - 2]),
              ((i - 1) < 0) ? 0 : nums[i - 1]);
    }
    return Math.max(nums.length - 2 < 0 ? 0 : nums[nums.length - 2], nums[nums.length - 1]);
  }

  //https://leetcode.com/problems/jump-game/
  public static boolean canJump(int[] nums) {
    int rightMostReachable = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] + i >= rightMostReachable) {
        rightMostReachable = i;
      }
    }
    return rightMostReachable == 0;
  }

  //  https://leetcode.com/problems/jump-game-ii/
  public static int jump(int[] nums) {
    int[]  minJump = new int[nums.length];
  if(nums.length == 1) return 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if(nums[i] + i  >= nums.length - 1 ){
        minJump[i] = 1;
        continue;
      }
      int min =nums.length;
      for (int jumps = 1; jumps <= nums[i];jumps++) {
        min = Math.min(min, minJump[i + jumps]);
      }
      minJump[i] = 1 + min;
    }
    return minJump[0];
  }
}
