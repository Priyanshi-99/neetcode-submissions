class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
        int[] res=new int[nums.length-k+1];
        //effective solution-Dequeue
        //front and back se eke ek bar remove kr skte hai monotonic dec stack ke trh work krega

        Deque <Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            dq.offerLast(i);
            if(i>=k-1){
            res[i-k+1]=nums[dq.peekFirst()];
            }

        }
        return res;


  
        // for(int i=0;i<nums.length-k+1;i++){
        //     int maxi=nums[i];
        // for(int j=i;j<=k+i-1;j++){
        //     maxi=Math.max(maxi,nums[j]);
            

        // }
        // res[i]=maxi;
        // }
        // return res; n*n solution
        
    }
}
