class Solution {
    public int compress(char[] chars) {
        int i=0,write=0;
        while(i<chars.length){
            int glen=0;
            char curr=chars[i];
            int j=i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
                
            }
            glen=j-i;
            
            
            chars[write++]=chars[i];
            if(glen>1){
                for(char c:Integer.toString(glen).toCharArray()){
                    chars[write++]=c;
                }
            }
            i=j;

        }
        
        return write;
        
    }
}