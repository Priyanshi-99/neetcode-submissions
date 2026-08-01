class Solution {
    public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            int maxi=Integer.MIN_VALUE;
            for(int i=0;i<stones.length;i++){
                pq.add(stones[i]);
            }

            while(pq.size()>1){
                int first=pq.poll();
                int second=pq.poll();

                if(first!=second){
                    pq.add(first-second);
                }
                else{
                pq.add(0);
                }
            }
        return pq.poll();
        
    }
}
