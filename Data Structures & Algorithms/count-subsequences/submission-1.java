class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(m>n) return 0;
        Integer[][]memo=new Integer[n+1][m+1];
        
        return dfs(s,t,0,0,memo);
        
    }

    public int dfs(String s,String t,int i,int j,Integer[][]memo){
        if(j==t.length()) return 1;

        if(i==s.length()) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int result=0;
        if(s.charAt(i)==t.charAt(j)){
            result=dfs(s,t,i+1,j+1,memo)+dfs(s,t,i+1,j,memo);
        }
        else{
            result=dfs(s,t,i+1,j,memo);
        }
        return memo[i][j]=result;

    }
}
