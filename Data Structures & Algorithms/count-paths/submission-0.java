class Solution {
    public int uniquePaths(int m, int n) {
        int [][]memo=new int[m+1][n+1];
        return helper(m,n,memo);
        
    }
    public int helper(int m,int n,int[][]memo){
          if(m==1 ||n==1) return 1;
      if(memo[m][n]!=0) return memo[m][n];
        
        return memo[m][n]=helper(m-1,n,memo)+helper(m,n-1,memo);
    }
}
