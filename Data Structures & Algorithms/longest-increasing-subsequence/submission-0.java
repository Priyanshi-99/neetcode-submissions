class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for (int[] row : dp) {
    Arrays.fill(row, -1);
        }           
        return helper(nums,0,-1,dp);
        
    }

    public int helper(int[] nums,int i,int prev,int[][]dp){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int nottake=helper(nums,i+1,prev,dp);
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
                take=1+helper(nums,i+1,i,dp);
        }
        return dp[i][prev+1]=Math.max(take,nottake);
    }
}
