package DP;

/**
 * @author ustbwjw
 * @create 2021-08-19 21:06
 */
public class Dp {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++)dp[i]=-1;
        if(nums==null) return -1;
        if(nums.length==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        return recure(nums,nums.length,dp);
    }

    public int recure(int[] nums,int num,int[] dp){
        if(dp[num-1]>=0) return dp[num-1];
        else{
            dp[num-1]=Math.max(recure(nums,num-2,dp)+nums[num-1],recure(nums,num-1,dp));
            return dp[num-1] ;
        }
    }
}
