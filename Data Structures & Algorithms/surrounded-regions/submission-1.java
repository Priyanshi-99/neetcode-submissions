class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q=new LinkedList<>();
        int rows=board.length;
        int cols=board[0].length;
        //left aur right
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                board[i][0]='T';
                q.offer(new int[]{i,0});
            }
            if(board[i][cols-1]=='O'){
                board[i][cols-1]='T';
                q.offer(new int[]{i,cols-1});

            }
        }
        //Top-bottom
        for(int j=0;j<cols;j++){
            if(board[0][j]=='O'){
                board[0][j]='T';
                q.offer(new int[]{0,j});
            }
            if(board[rows-1][j]=='O'){
                board[rows-1][j]='T';
                q.offer(new int[]{rows-1,j});

            }
        }


        while(!q.isEmpty()){
            int[]curr=q.poll();
            int row=curr[0];
            int col=curr[1];

            int dire[][]={{-1,0},{1,0},{0,-1},{0,1}};

            for(int[] dir:dire){
                int newR=row+dir[0];
                int newC=col+dir[1];

                if(newR<0 || newR>=board.length || newC<0 || newC>=board[0].length || board[newR][newC]!='O'){
                    continue;
                }
                board[newR][newC]='T';
                q.offer(new int[]{newR,newC});
                
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else{
                    if(board[i][j]=='T'){
                        board[i][j]='O';
                    }
                }
            }
        }
        
    }
}
