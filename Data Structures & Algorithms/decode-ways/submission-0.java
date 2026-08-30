class Solution {
    public int numDecodings(String s) {
        Integer[]memo=new Integer[s.length()];
        return dfs(s,0,memo);
        
    }
    public int dfs(String s,int i,Integer[]memo){
        if(i==s.length()) return 1;

        if(s.charAt(i)=='0') return 0;
        if(memo[i]!=null)return memo[i];
        int ways=dfs(s,i+1,memo);
        if(i+1<s.length()){
            char f=s.charAt(i);
            char se=s.charAt(i+1);

            boolean valid=f=='1' || (f=='2'&& se<='6');

            if(valid){
                ways+=dfs(s,i+2,memo);

            }
        }
        return memo[i]=ways;
    }
}
