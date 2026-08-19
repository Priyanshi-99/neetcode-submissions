class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int []point:points){
            int x=point[0];
            int y=point[1];
            int dist=x*x+y*y;
            q.offer(new int[]{dist,x,y});
        }
        int [][]res=new int[k][2];
        for(int i=0;i<k;i++){
            int[]close=q.poll();
            res[i][0]=close[1];
            res[i][1]=close[2];
        }
        return res;

    }
}
