class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);//==k ayega agar hum <=k and <=k-1 ko - knege
        
    }
    public int helper(int[]nums,int k){
        if(k==0) return 0;

        Map<Integer,Integer> hm=new HashMap<>();
        int left=0;
        int result=0;
        for(int right=0;right<nums.length;right++){
            int value=nums[right];
            hm.put(value,hm.getOrDefault(value,0)+1);

            while(hm.size()>k){
                int leftValue=nums[left];
                hm.put(leftValue,hm.get(leftValue)-1);

                if(hm.get(leftValue)==0) hm.remove(leftValue);

            
            left++;
            }
        
        result+=right-left+1;
    }
    return result;
    }
}