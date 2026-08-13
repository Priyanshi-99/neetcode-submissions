class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {     
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pacific =new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];
        List<List<Integer>> res=new ArrayList<>();

        
        for(int i=0;i<col;i++){
            dfs(0,i,pacific,heights[0][i],heights);
            dfs(row-1,i,atlantic,heights[row-1][i],heights);

        }
        for(int i=0;i<row;i++){
            dfs(i,0,pacific,heights[i][0],heights);
            dfs(i,col-1,atlantic,heights[i][col-1],heights);

        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j]&& atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
        
    }
    public void dfs(int r,int c,boolean vis[][],int prevHeight,int[][]heights){
        int rows = heights.length, cols = heights[0].length;
        if(r<0 || r>=rows|| c<0 || c>=cols||vis[r][c] || heights[r][c]<prevHeight) return;

        vis[r][c]=true;

        dfs(r+1,c,vis,heights[r][c],heights);
        dfs(r-1,c,vis,heights[r][c],heights);
        dfs(r,c+1,vis,heights[r][c],heights);
        dfs(r,c-1,vis,heights[r][c],heights);

    }
}
