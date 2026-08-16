class Solution {
    public int longestIncreasingPath(int[][] matrix) {
       
        int totalmx=0;
        int memo[][]=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               totalmx=Math.max(totalmx,dfs(matrix,i,j,memo));

            }
        }
        return totalmx;
        
    }
    public int  dfs(int[][]matrix,int i,int j,int memo[][]){
        int res=1;
        int[][] dire={{-1,0},{1,0},{0,-1},{0,1}};
        if(memo[i][j]!=0) return memo[i][j];
        for(int[] dir:dire){
            int ni=i+dir[0];
            int nj=j+dir[1]; 
            if(ni>=0 && ni<matrix.length && nj>=0 && nj<matrix[0].length && matrix[ni][nj]>matrix[i][j]){
                
                res=Math.max(res,1+dfs(matrix,ni,nj,memo));
                 
            }

        }
       
        return memo[i][j]=res;
        

    }
}
