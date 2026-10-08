class Solution {
    String longest ="";
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxlen=0;
        //String dp[]=new String[n+1];
        //Arrays.e whl(dp,"");
       for(int i=0;i<n;i++){
        String l1=helper(s,i,i);
        String l2=helper(s,i,i+1);
        if(l1.length()>longest.length()){
            longest=l1;
        }
        if(l2.length()>longest.length()){
            longest=l2;
        }
        
        
       }
       return longest;
        
    }

    public String helper(String s,int l,int r){
        if(l<0 || r>=s.length() || s.charAt(l)!=s.charAt(r)){
            return s.substring(l+1,r);//return the 0,0 string of l+1 is for not taking negaative number
        }
        
        return helper(s,l-1,r+1);
    }
}
