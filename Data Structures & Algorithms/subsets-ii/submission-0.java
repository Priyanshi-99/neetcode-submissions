class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
         Arrays.sort(nums);
         helper(nums,0,res,temp);
         return res;
    }
    public void helper(int[]nums,int i,List<List<Integer>> res, List<Integer> temp){
       res.add(new ArrayList<>(temp));
        
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            temp.add(nums[j]);
            helper(nums,j+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
