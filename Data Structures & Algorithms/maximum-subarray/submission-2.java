class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=0;
        int res=nums[0];
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            
            maxi+=nums[i];
            res=Math.max(maxi,res);
        //             //Kadane’s idea
        // If the sum so far becomes negative, it will only hurt any future subarray, so we reset it to 0.

            if(maxi<0){
                maxi=0;
            }
        }
       return res; 
    }
}
