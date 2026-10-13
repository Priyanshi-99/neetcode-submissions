class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]values=new int[n+2];
        values[0]=1;
        values[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        for(int i=0;i<n;i++){
            values[i+1]=nums[i];
        }
        return helper(0,n+1,values,dp);
        
    }
    public int helper(int i,int j,int[]nums,int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int maxi=0;
        for(int ind=i+1;ind<j;ind++){
            int cost=nums[i]*nums[ind]*nums[j]+helper(i,ind,nums,dp)+helper(ind,j,nums,dp);
            maxi=Math.max(maxi,cost);
            
        }
        return dp[i][j]=maxi;
    }
}
