class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for (int[] time : times) {
        int u = time[0], v = time[1], w = time[2];
        adj[u].add(new int[]{v, w});  // only one direction!
}
        int dis[]=new int [n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int maxtime=0;
            int []curr=pq.poll();
            int node=curr[0],time=curr[1];
            for(int[] next:adj[node]){
                int nextNode=next[0];
                int weight=next[1];

                int newTime=time+weight;
                if(newTime<dis[nextNode]){
                    dis[nextNode]=newTime;
                    pq.offer(new int[]{nextNode,newTime});

                }
            }          

        }
        int answer=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            answer=Math.max(answer,dis[i]);
        }
        return answer;
    }
}
