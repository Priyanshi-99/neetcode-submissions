class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,res,arr,0);
        return res;
    }
    public void helper(int[] candidates,int target,int i,List<List<Integer>> res,List<Integer> arr,int count){
        if(count==target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(count>target) return;
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            arr.add(candidates[j]);
            helper(candidates,target,j+1,res,arr,count+candidates[j]);
            arr.remove(arr.size()-1);

        }

        
    }
}
