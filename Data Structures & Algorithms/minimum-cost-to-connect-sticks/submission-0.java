class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:sticks){
            pq.offer(i);
            
        }
        int totalcost=0;
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            int com=first+second;
            totalcost+=com;
            pq.offer(com);
        }
        return totalcost;

        
    }
}
