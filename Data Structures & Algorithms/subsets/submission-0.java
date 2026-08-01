class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        return pos(arr,res,nums,0);
        
    }

    public List<List<Integer>> pos(ArrayList<Integer> arr,List<List<Integer>> res,int[]nums,int pos){
        
     
        for(int i=pos;i<nums.length;i++){
        arr.add(nums[i]);
        pos(arr,res,nums,i+1);
        arr.remove(arr.size()-1);
        }
           
        res.add(new ArrayList<>(arr));
        return res;
    


        


    }
}
