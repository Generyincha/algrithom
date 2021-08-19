package testPackage;

import DP.Dp;
import org.junit.Test;

/**
 * @author ustbwjw
 * @create 2021-08-19 21:07
 */
public class DpTest {
    @Test
    public void test1(){
        Dp dp = new Dp();
        int[] nums = new int[2];
        nums[0]=0;
        nums[1]=0;
        int rob = dp.rob(nums);
        System.out.println(rob);
    }
}
