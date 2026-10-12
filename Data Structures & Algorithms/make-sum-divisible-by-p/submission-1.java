class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        int move=0;
        for(int num:nums){
            sum+=num;
        }
        int remi=(int)(sum%p);
        //pura array pehle se hi divide ho rkha hai
        if(remi==0) return 0;
        Map<Integer,Integer> lastIn=new HashMap<>();
        lastIn.put(0,-1);
        long prefixSum=0;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            prefixSum=(prefixSum+nums[i])%p;
            int needed=(int)((prefixSum-remi+p)%p);

            if(lastIn.containsKey(needed)){
                int startIn=lastIn.get(needed);
                ans=Math.min(ans,i-startIn);
            }
            lastIn.put((int)prefixSum,i);

        }
        return ans==nums.length?-1:ans;
    }
}