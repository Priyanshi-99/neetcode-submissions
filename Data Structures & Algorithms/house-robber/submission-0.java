class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int maxi=0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,n,dp);

        
    }
    public int helper(int[]nums,int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(helper(nums,i+1,n,dp),nums[i]+helper(nums,i+2,n,dp));
    }
}
