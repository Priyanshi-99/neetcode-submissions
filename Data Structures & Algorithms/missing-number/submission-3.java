class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int esum=n*(n+1)/2;
        int suma=0;
        for(int sum:nums){
            suma+=sum;
        }
        return esum-suma;
    }
}
