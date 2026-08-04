class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int maxi=0;
        if(nums.length==1) return nums[0];
        int[] dp=new int[n+1];
        int[] dp2=new int[n+1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        return Math.max(helper(nums,0,n-1,dp),helper(nums,1,n,dp2));

        
    }
    public int helper(int[]nums,int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(helper(nums,i+1,n,dp),nums[i]+helper(nums,i+2,n,dp));
    }
}
