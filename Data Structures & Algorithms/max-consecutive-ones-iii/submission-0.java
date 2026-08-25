class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerolen=0;
        int left=0;
        
        int maxlen=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){

                zerolen++;
                
            }
            while(zerolen>k){
                if(nums[left]==0){
                zerolen--;
                }
                 left++;
                
            }
           
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;


        
    }
}