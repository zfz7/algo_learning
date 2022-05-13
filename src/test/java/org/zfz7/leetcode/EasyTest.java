package org.zfz7.leetcode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
