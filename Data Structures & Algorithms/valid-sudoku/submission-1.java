class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!='.'){
                    //1-9 any permution which is not in bottom or left
                    
                   if(!isValid(board,i,j,board[i][j])){
    return false;
}

                }
                
                 
            }
        }
            return true;
        
    }



    public boolean isValid(char[][] board,int row,int col,char c){
      for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==c){
                return false;
            }
             if(i!=row&&board[i][col]==c){
                return false;
            }
            if((3*(row/3)+i/3!=row || 3*(col/3)+i%3!=col)&&board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
            
        }
        return true;


    }
}
