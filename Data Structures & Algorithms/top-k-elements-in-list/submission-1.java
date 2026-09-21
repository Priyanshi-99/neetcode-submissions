class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] ans=new int[k];
        int j=0;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            
        }
        List<Integer> list = new ArrayList<>(hm.keySet());
        //List<integer> ls=new ArrayList<>(hm.keySet());//sara copy kr lia list m hashmap ka value
        list.sort((a, b) -> hm.get(b) - hm.get(a));//frequncy wise sort kr rhe hai
        for(int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

// list.sort((a,b)->hm.get(b)-hm.get(a));