class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        long prefixSum=0;
        for(int i=0;i<nums.length;i++){

            prefixSum+=nums[i];
            
            int rem=(int)prefixSum%k;
            
            if(mp.containsKey(rem)){
                int prev=mp.get(rem);
                if(i-prev>=2){
                    return true;
                }
            }
            else{
                mp.put(rem,i);
            }
        }
        return false;
    }
}