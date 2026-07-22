class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int island=0;

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                    bfs(grid,row,col);
                    island++;
                }
            }
        }
        return island++;
    }

    public void bfs(char[][] grid,int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,col});
        grid[row][col]='0';
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            for(int[] direct:dir){
                int newR=cell[0]+direct[0];
                int newC=cell[1]+direct[1];
                if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]=='1'){
                    queue.add(new int[]{newR,newC});
                    grid[newR][newC]='0';
                    
                }
            }
        }

    }
}
