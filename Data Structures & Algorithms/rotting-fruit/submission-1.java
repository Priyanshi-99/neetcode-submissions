class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int[][]vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});

                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        
        }
        int time=0;
        int cnt=0;
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        while(fresh>0 &&!q.isEmpty()){
        // ek level==ek minute
        int size=q.size();
        for(int i=0;i<size;i++){
        int curr[]=q.poll();
        int r=curr[0];
        int c=curr[1];
        for(int k=0;k<4;k++){
            int newR=dx[k]+r;
            int newC=dy[k]+c;
            if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]==1 ){
                grid[newR][newC]=2;
                q.offer(new int[]{newR,newC});
                fresh--;
            }
            
        }
        }
        time++;

        }
        return(fresh==0?time:-1);
    
    }
}
