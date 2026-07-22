class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int i=0;
        int k=nums.length-1;

        while(i<=k){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[l];
                nums[l]=temp;
                i++;
                l++;
            }
            else if(nums[i]==1){
                i++;
            }else{
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k--;

            }
        }
        
    }
}