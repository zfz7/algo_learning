package org.zfz7.easy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainsDuplicateTest {

    @Test
    public void test1(){
        assertEquals(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}), true);
        assertEquals(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}), false);
        assertEquals(ContainsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}), true);
    }
}
