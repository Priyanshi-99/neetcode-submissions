class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int n2=2*n;
        int []ans=new int[n2];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
        }
        for(int i=n;i<=n2-1;i++){
            ans[i]=nums[i-n];
        }
        return ans;
    }
}