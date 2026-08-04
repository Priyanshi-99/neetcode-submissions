class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int n=cost.length;
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
        return  Math.min(helper(cost, 0, n,dp), helper(cost, 1, n,dp));   
    }
    public int helper(int[] cost,int i,int n,int[] dp){
        if(i>=n) return 0;
        //if(i<=n-1) return cost[i];
        if(dp[i]!=-1) return dp[i];

       //

        return dp[i]=cost[i]+Math.min(helper(cost,i+1,n,dp),helper(cost,i+2,n,dp));
    }
}
