class Solution {
    public boolean isMatch(String s, String p) {
       int n=s.length()-1;
       int m=p.length()-1; 
       return dfs(s,n,p,m);
        
    }
    public boolean dfs(String s,int i,String p,int j){
        
        if(i<0 && j<0) return true;
        if(i>0 && j<0) return false;
        if (j < 0) {
            return false;
        }

        if (i < 0) {
            if (p.charAt(j) == '*') {
                return dfs(s, i, p, j - 2);
            }
            return false;
        }

        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
            return dfs(s,i-1,p,j-1);
        }
        else if(p.charAt(j)=='*'){
            // Option 1: ignore "x*"
            boolean zero = dfs(s, i, p, j - 2);

            // Option 2: use "x*" to match current character
            boolean oneOrMore =
                (p.charAt(j - 1) == s.charAt(i) ||
                 p.charAt(j - 1) == '.')
                && dfs(s, i - 1, p, j);

            return zero || oneOrMore;
        }
        return false;
    }
}
