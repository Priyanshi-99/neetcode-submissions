class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []ans=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int resi=target-nums[i];
            if(hm.containsKey(resi)){
                return new int[]{hm.get(resi),i};
            }
           hm.put(nums[i],i);
           }

           return new int[]{};
        }
    
}
