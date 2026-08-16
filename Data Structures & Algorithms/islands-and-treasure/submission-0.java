class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    
                        q.offer(new int[]{i,j});
                }

                }
            }
            int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

            while(!q.isEmpty()){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];

                for(int [] direct:dir){
                    int newR=row+direct[0];
                    int newC=col+direct[1];


                    if(newR<0 || newR>=grid.length || newC<0 || newC>=grid[0].length|| grid[newR][newC]!=Integer.MAX_VALUE){
                        continue;
                    }
                   grid[newR][newC]=grid[row][col]+1;
                   q.offer(new int[]{newR,newC});
                }
            }
        }

        
    }

