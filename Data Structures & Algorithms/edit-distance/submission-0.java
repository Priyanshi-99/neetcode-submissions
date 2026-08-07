class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        Integer[][] dp=new Integer[n+1][m+1];
        return helper(word1,n-1,word2,m-1,dp);
        
    }
    public int helper(String w1,int i,String w2,int j,Integer[][]dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return helper(w1,i-1,w2,j-1,dp);
        }
        return dp[i][j]=1+Math.min(helper(w1,i-1,w2,j,dp),Math.min(helper(w1,i-1,w2,j-1,dp),helper(w1,i,w2,j-1,dp)));
    }
}
