class Solution {

    public int countSubstrings(String s) {
         int c=0;
        for(int i=0;i<s.length();i++){
        c+=helper(s,i,i);        
        c+=helper(s,i,i+1);
        }
        return c;
        
    }
    public int helper(String s,int l,int r){
        int count=0;
        while(r<s.length()&&l>=0&&s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;

    }
}
