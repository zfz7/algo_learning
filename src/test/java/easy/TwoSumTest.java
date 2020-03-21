package easy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {

    @Test
    public void test1(){
        int[] input = {2, 7, 18, 15};
        int[] output = TwoSum.twoSum(input,9);

        assertEquals(output[0],0);
        assertEquals(output[1],0);
    }
}
