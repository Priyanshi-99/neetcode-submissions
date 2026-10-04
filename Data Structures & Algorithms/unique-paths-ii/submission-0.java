class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int m=obstacleGrid[0].length;
        int n=obstacleGrid.length;
        Integer[][]memo=new Integer[n][m];
        return dfs(obstacleGrid,0,0,memo);
        
        
    }
    public int dfs(int[][] grid,int r,int c,Integer[][]memo){
        int m=grid[0].length;
        int n=grid.length;

        if(r>=n || c>=m || grid[r][c]==1){
            return 0;
        }
        if(r==n-1 && c==m-1){
            return 1;
        }
        if(memo[r][c]!=null){
            return memo[r][c];
        }
        int down=dfs(grid,r+1,c,memo);
        int right=dfs(grid,r,c+1,memo);
        return memo[r][c]=down+right;
    }

}