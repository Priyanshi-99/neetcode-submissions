class Solution {
    public int maxProfit(int[] prices) {
            int n=prices.length;
            Integer[][] dp=new Integer[n][2];
            return helper(prices,0,1,n,dp);

        
    }
    public int helper(int[] prices,int i,int buy,int n,Integer [][]dp){
        int maaxi=Integer.MIN_VALUE;
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=null) return dp[i][buy];
        int buy1=0;
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+helper(prices,i+1,0,n,dp),helper(prices,i+1,1,n,dp));
        }
            return dp[i][buy]=Math.max(prices[i]+helper(prices,i+2,1,n,dp),helper(prices,i+1,0,n,dp));
           
       

       
    }
}
