package org.zfz7.easy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidPalindromeTest {

    @Test
    public void test1(){
        assertEquals(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"), true);
        assertEquals(ValidPalindrome.isPalindrome("race a car"), false);
        assertEquals(ValidPalindrome.isPalindrome(" "), true);
        assertEquals(ValidPalindrome.isPalindrome("0P"), false);
    }
}
