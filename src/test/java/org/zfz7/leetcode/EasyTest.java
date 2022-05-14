package org.zfz7.leetcode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EasyTest {

    @Test
    public void maxProfitTest(){
        assertEquals(Easy.maxProfit(new int[]{7,1,5,3,6,4}), 5);
        assertEquals(Easy.maxProfit(new int[]{7,6,4,3,1}), 0);
    }

    @Test
    public void containsDuplicateTest(){
        assertEquals(Easy.containsDuplicate(new int[]{1, 2, 3, 1}), true);
        assertEquals(Easy.containsDuplicate(new int[]{1, 2, 3, 4}), false);
        assertEquals(Easy.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}), true);
    }

    @Test
    public void twoSumTest(){
        int[] input = {2, 7, 18, 15};
        int[] output = Easy.twoSum(input,9);

        assertEquals(output[0],0);
        assertEquals(output[1],1);
    }

    @Test
    public void isAnagramTest(){
        assertEquals(Easy.isAnagram("anagram", "nagaram"), true);
        assertEquals(Easy.isAnagram("rat", "car"), false);
        assertEquals(Easy.isAnagram("aacc", "ccac"), false);
    }

    @Test
    public void isPalindromeTest(){
        assertEquals(Easy.isPalindrome("A man, a plan, a canal: Panama"), true);
        assertEquals(Easy.isPalindrome("race a car"), false);
        assertEquals(Easy.isPalindrome(" "), true);
        assertEquals(Easy.isPalindrome("0P"), false);
    }

    @Test
    public void isValidTest(){
        assertEquals(Easy.isValid("()"), true);
        assertEquals(Easy.isValid("()[]{}"), true);
        assertEquals(Easy.isValid("[}"), false);
        assertEquals(Easy.isValid("["), false);
    }

    @Test
    public void isBinarySearch(){
        assertEquals(Easy.search(new int[]{-1,0,3,5,9,12},9), 4);
        assertEquals(Easy.search(new int[]{-1,0,3,5,9,12},4), -1);
        assertEquals(Easy.search(new int[]{-1,0,3,5,9,12},2), -1);
        assertEquals(Easy.search(new int[]{1},1), 0);
        assertEquals(Easy.search(new int[]{1},2), -1);
    }
    @Test
    public void reverseList(){
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
    public void mergeTwoList(){
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
}
