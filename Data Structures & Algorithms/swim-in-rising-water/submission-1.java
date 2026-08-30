class Solution {
    public int swimInWater(int[][] grid) {
        int n =grid.length;
        boolean [][] visited=new boolean[n][n];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int[][]direct={{-1,0},{0,-1},{1,0},{0,1}};
        minHeap.offer(new int[]{grid[0][0],0,0});
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int time=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row==n-1 && col==n-1){
                return time;
            }

            for(int[] dir:direct){

                int nr=dir[0]+row;
                int nc=dir[1]+col;
                if(nr<0 || nr>n-1 || nc<0 || nc>n-1 || visited[nr][nc] ){
                    continue;
                }
                visited[nr][nc]=true;
                int nextTime=Math.max(time,grid[nr][nc]);
                minHeap.offer(new int[]{nextTime,nr,nc});




            }
        }
        return -1;
    }
}
