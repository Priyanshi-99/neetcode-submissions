class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target);
        int second=findSecond(nums,target);
        return new int[]{first,second};

    }
    public int findFirst(int[] nums,int target){

        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                ans=mid;
                high=mid-1;
            }
            if(target<nums[mid]){
                high=mid-1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
        }
        
        return ans;
        
    }
    public int findSecond(int[] nums,int target){

        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                ans=mid;
                low=mid+1;
            }
            if(target<nums[mid]){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        
        return ans;
    }
}