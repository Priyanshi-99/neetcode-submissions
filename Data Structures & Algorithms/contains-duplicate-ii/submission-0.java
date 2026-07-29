class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       
        Set<Integer> s=new HashSet<>();
        int l=0;

        for(int r=0;r<nums.length;r++){
            if(r-l>k){
                s.remove(nums[l]);
                l++;
            }
            if(s.contains(nums[r])){
                return true;
            }
            s.add(nums[r]);
        }
        return false;
    }
}