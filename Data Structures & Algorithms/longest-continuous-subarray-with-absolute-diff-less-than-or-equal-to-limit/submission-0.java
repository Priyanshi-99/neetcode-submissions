class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            tm.put(nums[right],tm.getOrDefault(nums[right],0)+1);
            while(tm.lastKey()-tm.firstKey()>limit){
                int removeValue=nums[left];
                tm.put(removeValue,tm.get(removeValue)-1);
                if(tm.get(removeValue)==0){
                    tm.remove(removeValue);
                }
                left++;
            }
        ans=Math.max(ans,right-left+1);
            
        }
return ans;
        
        
    }
}