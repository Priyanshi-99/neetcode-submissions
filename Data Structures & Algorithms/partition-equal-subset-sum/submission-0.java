class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        int remaining=sum/2;
        Boolean[][] memo=new Boolean [nums.length][remaining+1];
        return canPart(nums,remaining,0,memo);
    }
    public boolean canPart(int[] nums,int remaining,int i,Boolean memo[][]){
        if(remaining==0) return true;
        if(i==nums.length || remaining <0 )return false;
        if(memo[i][remaining]!=null) return memo[i][remaining];
        boolean pick= canPart(nums,remaining-nums[i],i+1,memo);
        boolean skip= canPart(nums,remaining,i+1,memo);

        return memo[i][remaining]=pick|| skip;
    }
}
