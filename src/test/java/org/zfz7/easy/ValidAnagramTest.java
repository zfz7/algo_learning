package org.zfz7.easy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidAnagramTest {

    @Test
    public void test1(){
        assertEquals(ValidAnagram.isAnagram("anagram", "nagaram"), true);
        assertEquals(ValidAnagram.isAnagram("rat", "car"), false);
        assertEquals(ValidAnagram.isAnagram("aacc", "ccac"), false);
    }
}
