class Solution {
    public int change(int amount, int[] coins) { 
        int dp[][]=new int[amount+1][coins.length];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(amount,coins,0,dp);
        
    }
    public int helper(int amount,int []coins,int i,int[][]dp){

        if(amount==0){
            return 1;

        }
         if (amount < 0 || i == coins.length) return 0; 
        if(dp[amount][i]!=-1) return dp[amount][i];
        
        int take=helper(amount-coins[i],coins,i,dp);

        int nottake=helper(amount,coins,i+1,dp);
        return dp[amount][i]=take+nottake;

    }
}
