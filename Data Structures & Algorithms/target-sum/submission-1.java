class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
           if (Math.abs(target) > sum) {
            return 0;
        }
        Integer[][]dp=new Integer[nums.length][2*sum+1];

        return helper(nums,target,0,0,dp,sum);

        
    }
    public int helper(int [] nums,int target,int total,int i,Integer[][]dp,int offset){
    if(i==nums.length){
        if(target==total){
            return 1;
        }
        else{
            return 0;
        }
    }
    int index=total+offset;
    if(dp[i][index]!=null) return dp[i][index];
    int add=helper(nums,target,total+nums[i],i+1,dp,offset);
    int subtract=helper(nums,target,total-nums[i],i+1,dp,offset);


return dp[i][index]=add+subtract;

    }
}
