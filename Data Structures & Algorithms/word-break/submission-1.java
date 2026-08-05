class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    
        Boolean[]dp=new Boolean[s.length()+1];
       
       return helper(s,0, wordDict,dp);
        
        
    }
    public boolean helper(String s,int i,List<String> wordDict,Boolean[]dp){
        if(i==s.length()) return dp[i]=true;
        if(dp[i]!= null) return dp[i];
        for(String word:wordDict){
        if(s.startsWith(word,i)){
            if(helper(s,i+word.length(),wordDict,dp)){
                return dp[i]=true;
            }
        }
        }
        return dp[i]=false;
    }
}
