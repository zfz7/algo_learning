package org.zfz7.easy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuySellStockTest {

    @Test
    public void test1(){
        assertEquals(BuySellStock.maxProfit(new int[]{7,1,5,3,6,4}), 5);
        assertEquals(BuySellStock.maxProfit(new int[]{7,6,4,3,1}), 0);
    }
}
