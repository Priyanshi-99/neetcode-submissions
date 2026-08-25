class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> j:hm.entrySet()){
            if(hm.containsKey(target)&& hm.get(target)>nums.length/2){
                return true;
            }
        }
        return false;
    }
}
