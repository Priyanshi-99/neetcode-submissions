class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int island=0;
        int ans=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                    dfs(grid,row,col);
                   ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
       dfs(grid,i+1,j);
       dfs(grid,i-1,j);
       dfs(grid,i,j-1);
       dfs(grid,i,j+1);
    }

    // public void bfs(char[][] grid,int row,int col){
    //     Queue<int[]> queue=new LinkedList<>();
    //     queue.offer(new int[]{row,col});
    //     grid[row][col]='0';
    //     while(!queue.isEmpty()){
    //         int[] cell=queue.poll();
    //         for(int[] direct:dir){
    //             int newR=cell[0]+direct[0];
    //             int newC=cell[1]+direct[1];
    //             if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]=='1'){
    //                 queue.add(new int[]{newR,newC});
    //                 grid[newR][newC]='0';
                    
    //             }
    //         }
    //     }

    // }
}
