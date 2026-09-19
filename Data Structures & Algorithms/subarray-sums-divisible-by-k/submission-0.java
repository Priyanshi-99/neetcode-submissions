class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int preSum=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            
            int remove=preSum%k;
            if(remove<0){
                remove+=k;
            }
            if(hm.containsKey(remove))
                cnt+=hm.get(remove);
            hm.put(remove,hm.getOrDefault(remove,0)+1);
        }
        return cnt;
    }
}