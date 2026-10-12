class Solution {
    public int splitArray(int[] nums, int k) {
        //greeedy + bineary search

        //binary search
        int low=0;
        int high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canSplit(nums,k,mid)){
                high=mid;

            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
    //greedy
    private boolean canSplit(int[]nums,int k,int limit){
        int subarray=1;
        int currsum=0;
        for(int num:nums){
            //array ke har element ko left to right process Agar exceed ho raha hai, to num ko current subarray me nahi daal sakte.   subarrays++; Naya subarray start karte hain.
            if(currsum+num>limit){
                subarray++;
                currsum=num;

            
            //agar limit exceed kr gaya toh false
            if(subarray>k){
                return false;
            }
            }
            //agar limit ke andar hai toh currsum+=num krna hai
            else{
                currsum+=num;
            }
        }
        return true;

    }
}