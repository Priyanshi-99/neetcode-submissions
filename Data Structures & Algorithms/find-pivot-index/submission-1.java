class Solution {
    public int pivotIndex(int[] nums) {
        int prefix=0;
        int suffix=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];

        }
        for(int i=0;i<nums.length;i++){
           
            if(prefix==(total-prefix-nums[i])){
                return i;
            }
             prefix+=nums[i];
        }
        return -1;
    }
}