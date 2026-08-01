class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        //List<Integer> arr=new ArrayList<>();
        pos(nums, target,0,new ArrayList<>(),0,res);
        return res;
    }
    public void pos(int[] nums,int target,int i,List<Integer> arr,int count,List<List<Integer>> res){
       if(count==target){
        res.add(new ArrayList<>(arr));
        return;

       }
        if(count>target || i>=nums.length){
            return;
        }
       
        arr.add(nums[i]);
        pos(nums,target,i,arr,count+nums[i],res);
        arr.remove(arr.size()-1);
        pos(nums,target,i+1,arr,count,res);

       

    }
}
