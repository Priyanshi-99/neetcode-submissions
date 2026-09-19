class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color) return image;
        dfs(sr,sc,image,color,originalColor);
                
        
        return image;
    }
    public void dfs(int sr,int sc,int[][]image,int color,int originalColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=originalColor){
            return;
        }
        image[sr][sc]=color;
        dfs(sr+1,sc,image,color,originalColor);
        dfs(sr,sc+1,image,color,originalColor);
        dfs(sr-1,sc,image,color,originalColor);
        dfs(sr,sc-1,image,color,originalColor);
    }
}