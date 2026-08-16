class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][]memo=new Boolean[s1.length()+1][s2.length()+1];
          if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return helper(s1,s2,s3,0,0,memo);

        
    }
    public boolean helper(String s1,String s2,String s3,int i,int j,Boolean [][]memo){
        if(i==s1.length() && j==s2.length()) return true;
        boolean res=false;
        if(memo[i][j]!=null) return memo[i][j];
        int k=i+j;

        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)&& helper(s1,s2,s3,i+1,j,memo)){
            res= true;
        }

        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)&& helper(s1,s2,s3,i,j+1,memo)){
            res= true;
        }
        return memo[i][j]=res;
    }
}
