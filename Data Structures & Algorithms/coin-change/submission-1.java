class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[amount+1][coins.length];
        for(int i=0;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=helper(coins,amount,coins.length-1,dp);

        if(ans>=(int)1e9) return -1;
        return ans;
        
        
    }
    public int helper(int[] coins,int amount,int n,int[][] dp){

        if(n==0) {
            if(amount%coins[0]==0) return amount/coins[0];

            return (int)1e9;
        }
        if(dp[amount][n]!=-1) return dp[amount][n];
        int notTake=0+helper(coins,amount,n-1,dp);

        int take=Integer.MAX_VALUE;
        if(coins[n]<=amount)
        take=1+helper(coins,amount-coins[n],n,dp);

        return dp[amount][n]=Math.min(notTake,take);
    }
}
