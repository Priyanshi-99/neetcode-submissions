class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        
        String ans="";
        for(int j=1;j<strs.length;j++){
            int i=0;
            while(i<prefix.length() && i<strs[j].length()){
                if(prefix.charAt(i)!=strs[j].charAt(i)){
                    break;
                }
               
                i++;
                
            
            }
           prefix=prefix.substring(0,i);
        if(prefix.length()==0) return "";

        }
        
        return prefix;
        
    }
}