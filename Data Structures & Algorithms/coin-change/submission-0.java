class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int ans=helper(coins,amount,coins.length-1);

        if(ans>=(int)1e9) return -1;
        return ans;
        
        
    }
    public int helper(int[] coins,int amount,int n){

        if(n==0) {
            if(amount%coins[0]==0) return amount/coins[0];

            return (int)1e9;
        }
        int notTake=0+helper(coins,amount,n-1);

        int take=Integer.MAX_VALUE;
        if(coins[n]<=amount)
        take=1+helper(coins,amount-coins[n],n);

        return Math.min(notTake,take);
    }
}
