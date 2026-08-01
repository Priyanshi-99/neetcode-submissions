class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        helper(res,nums,arr,0);
        return res;
        
    }
    public void helper(List<List<Integer>> res,int[]nums,List<Integer> arr,int start){
       if(start==nums.length){
            List<Integer> curr=new ArrayList<>();
            for(int num: nums){
                curr.add(num);
            }
            res.add(curr);
       }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            helper(res,nums,arr,start+1);
            swap(nums,start,i);
        }

    }

    public void swap(int[]nums,int start,int i){
        int temp=nums[start];
        nums[start]=nums[i];
        nums[i]=temp;
    }
}
