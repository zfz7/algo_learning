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
    int[] minJump = new int[nums.length];
    if (nums.length == 1) return 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] + i >= nums.length - 1) {
        minJump[i] = 1;
        continue;
      }
      int min = nums.length;
      for (int jumps = 1; jumps <= nums[i]; jumps++) {
        min = Math.min(min, minJump[i + jumps]);
      }
      minJump[i] = 1 + min;
    }
    return minJump[0];
  }

  //https://leetcode.com/problems/insert-interval/
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] result = new int[intervals.length + 1][2];
    int i = 0;
    int nextRes = 0;
    if (intervals.length == 1 && intervals[0].length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result[nextRes][0] = intervals[i][0];
      result[nextRes++][1] = intervals[i][1];
      i++;
    }
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }
    result[nextRes][0] = newInterval[0];
    result[nextRes++][1] = newInterval[1];
    while (i < intervals.length) {
      result[nextRes][0] = intervals[i][0];
      result[nextRes++][1] = intervals[i][1];
      i++;
    }
    int[][] result1 = new int[nextRes][2];
    System.arraycopy(result, 0, result1, 0, nextRes);
    return result1;
  }

  //https://leetcode.com/problems/rotate-image/
  public static void rotate(int[][] matrix) {
    for (int row = 0; row < matrix.length / 2; row++) {
      for (int col = row; col < matrix.length - row - 1; col++) {
        swap4Around(row, col, matrix);
      }
    }
    /*
    row, col
    0,0 -> 0,2
    0,1 -> 1,2
    0,2 -> 2,2
    1,0 -> 0,1
    1,1 -> 1,1
    1,2 -> 2,1
    2,0 -> 0,0
    2,1 -> 1,0
    2,2 -> 2,0
     */
  }

  private static void swap4Around(int row, int col, int[][] matrix) {
    int current = matrix[row][col];
    for (int n = 0; n < 4; n++) {
      int nextRow = col;
      int nextCol = matrix.length - 1 - row;
      int next = matrix[nextRow][nextCol];
      matrix[nextRow][nextCol] = current;
      current = next;
      row = nextRow;
      col = nextCol;
    }
  }

  private static HashMap<Node, Node> oldToNew = new HashMap<>();

  //https://leetcode.com/problems/clone-graph/submissions/
  public static Node cloneGraph(Node node) {
    oldToNew = new HashMap<>();
    return node == null ? null : cloneNode(node);
  }

  private static Node cloneNode(Node node) {
    if (oldToNew.containsKey(node)) return node;
    Node newNode = new Node(node.val);
    oldToNew.put(node, newNode);
    for (Node n : node.neighbors) {
      if (oldToNew.containsKey(n)) {
        newNode.neighbors.add(oldToNew.get(n));
      } else {
        newNode.neighbors.add(cloneNode(n));
      }
    }
    return newNode;
  }

  //https://leetcode.com/problems/number-of-islands/
  public static int numIslands(char[][] grid) {
    int count = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == '1') {
          count++;
          travelIsland(grid, row, col);
        }
      }
    }
    return count;
  }

  private static void travelIsland(char[][] grid, int row, int col) {
    //if index out of bounds return
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) return;
    if (grid[row][col] == '1') {
      grid[row][col] = 'v';
      travelIsland(grid, row - 1, col);
      travelIsland(grid, row + 1, col);
      travelIsland(grid, row, col + 1);
      travelIsland(grid, row, col - 1);
    }
  }

  public static int getSum1(int a, int b) {
    int sum = 0;
    int carry = 0;
    for (int i = 0; i < 32; i++) {
      int aDigit = a & 1;
      a = a >> 1;
      int bDigit = b & 1;
      b = b >> 1;
      if (aDigit == 1 && bDigit == 1 && carry == 1) {
        carry = 1;
        sum = sum | ((i == 31) ? -(int) Math.pow(2, 31) - 1 : (int) Math.pow(2, i));
      }
      if (aDigit == 1 && bDigit == 0 && carry == 0 ||
              aDigit == 0 && bDigit == 1 && carry == 0 ||
              aDigit == 0 && bDigit == 0 && carry == 1) {
        carry = 0;
        sum = sum | ((i == 31) ? -(int) Math.pow(2, 31) - 1 : (int) Math.pow(2, i));
      }
      if (aDigit == 1 && bDigit == 1 && carry == 0 ||
              aDigit == 0 && bDigit == 1 && carry == 1 ||
              aDigit == 1 && bDigit == 0 && carry == 1) {
        carry = 1;
      }
      if (aDigit == 0 && bDigit == 0 && carry == 0) {
        carry = 0;
      }
    }
    return sum;
  }

  public static int getSum(int a, int b) {
    int xor = a ^ b;
    int and = (a & b) << 1;
    while (and != 0) {
      int temp = xor;
      xor = xor ^ and;
      and = (temp & and) << 1;
    }
    return xor;
  }

  public static int reverse(int x) {
    int rx = reverseInt(x);
    return (x == reverseInt(rx) || x % reverseInt(rx) == 0) ? rx : 0;
  }

  private static int reverseInt(int x) {
    int remaining = x;
    int ret = 0;

    while (remaining != 0) {
      ret = (ret * 10) + remaining % 10;
      remaining = remaining / 10;
    }
    return ret;
  }

  public static List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> subset = new ArrayList<>();
    findSubset(nums, res, subset, 0);
    return res;
  }

  private static void findSubset(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> subset, int index) {
    if (index >= nums.length) {
      res.add(new ArrayList<>(subset));
      return;
    }
    subset.add(nums[index]);
    findSubset(nums, res, subset, index + 1);
    subset.remove((Integer) nums[index]);
    findSubset(nums, res, subset, index + 1);
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> subset = new ArrayList<>();
    findCombination(candidates, res, subset, 0, target, 0);
    return res;
  }

  private static void findCombination(int[] candidates, ArrayList<List<Integer>> res,
                                      ArrayList<Integer> subset, int index, int target, int sum) {
    if (index >= candidates.length) {
      return;
    }
    if (sum > target) {
      return;
    }
    if (sum == target) {
      res.add(new ArrayList<>(subset));
      return;
    }
    subset.add(candidates[index]);
    findCombination(candidates, res, subset, index, target, sum + candidates[index]);
    subset.remove((Integer) candidates[index]);
    findCombination(candidates, res, subset, index + 1, target, sum);
  }

  //https://leetcode.com/problems/product-of-array-except-self/submissions/
  public static int[] productExceptSelf(int[] nums) {
    int rightProduct = 1;
    int leftProduct = 1;
    int[] leftProducts = new int[nums.length];
    int[] rightProducts = new int[nums.length];
    int[] res = new int[nums.length];
    leftProducts[0] = 1;
    rightProducts[nums.length - 1] = 1;
    for (int i = 1; i < nums.length; i++) {
      leftProduct = leftProduct * nums[i - 1];
      leftProducts[i] = leftProduct;
    }
    for (int i = nums.length - 1; i > 0; i--) {
      rightProduct = rightProduct * nums[i];
      rightProducts[i - 1] = rightProduct;
    }
    for (int i = 0; i < nums.length; i++) {
      res[i] = leftProducts[i] * rightProducts[i];
    }
    return res;
  }

  //https://leetcode.com/problems/top-k-frequent-elements/
  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> numToCount = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (numToCount.containsKey((Integer) nums[i])) {
        numToCount.put(nums[i], numToCount.get(nums[i]) + 1);
      } else {
        numToCount.put(nums[i], 1);
      }
    }
    PriorityQueue<Pair> desCounts = new PriorityQueue<>((a, b) -> b.value - a.value);

    for (Integer key : numToCount.keySet()) {
      desCounts.add(new Pair(key, numToCount.get(key)));
    }
    int[] res = new int[k];
    for (int i = 0; i < res.length; i++) {
      res[i] = desCounts.poll().key;
    }
    return res;
  }

  //https://leetcode.com/problems/valid-sudoku/
  public static boolean isValidSudoku(char[][] board) {
    HashSet<String> valid = new HashSet<>();
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') continue;
        if (valid.contains("Row:" + row + "|" + board[row][col])) return false;
        valid.add("Row:" + row + "|" + board[row][col]);
        if (valid.contains("Col:" + col + "|" + board[row][col])) return false;
        valid.add("Col:" + col + "|" + board[row][col]);
        if (valid.contains("Box:" + col / 3 + "|" + row / 3 + "|" + board[row][col])) return false;
        valid.add("Box:" + col / 3 + "|" + row / 3 + "|" + board[row][col]);
      }
    }
    return true;
  }

  //https://leetcode.com/problems/3sum/submissions/
  public static List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> res = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          ArrayList<Integer> ans = new ArrayList<>();
          ans.add(nums[i]);
          ans.add(nums[left]);
          ans.add(nums[right]);
          res.add(ans);
          res.add(ans);
          right--;
          left++;
          continue;
        }
        if (sum > 0) {
          right--;
        }
        if (sum < 0) {
          left++;
        }
      }
    }
    return new ArrayList<List<Integer>>(res);
  }

  //  https://leetcode.com/problems/longest-repeating-character-replacement/
  public static int characterReplacement(String s, int k) {
    HashMap<Character, Integer> counts = new HashMap<>();
    int res = 0;
    int left = 0;
    int right = 0;
    char[] sArr = s.toCharArray();
    while (right < sArr.length) {
      //Update right counts
      if (counts.containsKey(sArr[right])) {
        counts.put(sArr[right], counts.get(sArr[right]) + 1);
      } else {
        counts.put(sArr[right], 1);
      }
      System.out.println("left " + left + " right " + right + " legth " + (right - left + 1));
      System.out.println(counts);
      System.out.println("valid: " + ((right - left + 1) - maxChar(counts) <= k));
      //Is current substring valid?
      if ((right - left + 1) - maxChar(counts) <= k) {
        res = Math.max(res, right - left + 1);
        right++;
      } else {
        counts.put(sArr[left], counts.get(sArr[left]) - 1);
        counts.put(sArr[right], counts.get(sArr[right]) - 1);
        left++;
      }

    }
    return res;
  }

  private static int maxChar(HashMap<Character, Integer> counts) {
    int max = 0;
    for (int count : counts.values()) {
      max = Math.max(max, count);
    }
//    System.out.println(max);
    return max;
  }

  //https://leetcode.com/problems/permutation-in-string/
  public static boolean checkInclusion(String s1, String s2) {
    int left = 0;
    int right = s1.length() - 1;
    char[] s1Arry = s1.toCharArray();
    Arrays.sort(s1Arry);

    while (right < s2.length()) {
      if (isPermutations(s1Arry, s2.substring(left, right + 1).toCharArray())) {
        return true;
      }
      left++;
      right++;
    }
    return false;
  }

  private static boolean isPermutations(char[] sorted, char[] unsorted) {
    Arrays.sort(unsorted);
    for (int i = 0; i < sorted.length; i++) {
      if (sorted[i] != unsorted[i]) return false;
    }
    return true;
  }

  //https://leetcode.com/problems/container-with-most-water/
  public static int maxArea(int[] heights) {
    int left = 0;
    int right = heights.length -1;
    int maxArea = 0;
    while (left < right) {
      maxArea = Math.max(maxArea, calcArea(heights, left, right));
      if(heights[left] <= heights[right]){
        left++;
      }
      else if(heights[right] <= heights[left]){
        right--;
      }
    }
    return maxArea;
  }

  private static int calcArea(int[] heights, int left, int right) {
    int height = Math.min(heights[left], heights[right]);
    return height * (right - left);
  }

}
