class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<String> arr=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        isqueen(res,board,0,n);
        return res;
        
    }

    public void isqueen(List<List<String>> res, char[][] board, int j,int n){
        if(j==board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(isSafe(n,i,j,board)){
                board[i][j]='Q';
                isqueen(res,board,j+1,n);
                board[i][j]='.';
                
            }
        }

    }

    public boolean isSafe(int n,int i,int j,char[][] board){

        int row=i;
        int col=j;

        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;

        }

        i=row;
        j=col;

        while(j>=0){
             if(board[i][j]=='Q') return false;
             j--;

        }

        i=row;
        j=col;

        while(j>=0 && i<n){
            if(board[i][j]=='Q') return false;
             j--;
             i++;
        }

        return true;

    }
}
