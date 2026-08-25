class Solution {
    public int missingNumber(int[] nums) {
      int n=nums.length;
      int sum=0;
      int esum=n*(n+1)/2;
      for(int i:nums){
        sum+=i;
      }
      return esum-sum;
    }
}
