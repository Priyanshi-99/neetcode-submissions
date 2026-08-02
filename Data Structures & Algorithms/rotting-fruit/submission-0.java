class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    fresh++;
                }
                else if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
            }
        }


        int time=0;
        int[] dx={-1,0,1,0};
        int[] dy={0,-1,0,1};

        while(fresh>0 && !q.isEmpty()){
               
int s=q.size();
                for(int i=0;i<s;i++){
                int[] curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                
                for(int c=0;c<4;c++){
                    int nr=dx[c]+x;
                    int nc=dy[c]+y;
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }

                }


                }
time++;
        }
        return (fresh==0)?time:-1;

        
    }
}
