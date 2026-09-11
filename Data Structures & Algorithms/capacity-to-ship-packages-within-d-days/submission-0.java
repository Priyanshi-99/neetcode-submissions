class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int capacity=low+(high-low)/2;
            if(canShip(weights,days,capacity)){
            ans=capacity;
            high=capacity-1;
            }
            else{
                low=capacity+1;
            }
        }
        return ans;
    }

    private boolean canShip(int[]weights,int days,int capacity){
        int usedDays=1;
        int currWeight=0;
        for(int weight:weights){
            if(currWeight+weight>capacity){
                usedDays++;
                currWeight=0;
            }
            currWeight+=weight;

            if(usedDays>days){
                return false;
            }
        }
        return true;
    }
}