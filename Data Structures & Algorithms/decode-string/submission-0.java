class Solution {
    
    public String decodeString(String s) {
        int k=0;
         StringBuilder curr=new StringBuilder();

        Deque<StringBuilder> strStack=new ArrayDeque<>();
        Deque<Integer> countStack=new ArrayDeque<>();
       
        

        for(int i=0;i<s.length();i++){
          
            if(Character.isDigit(s.charAt(i))){
                k=k*10+(s.charAt(i)-'0');
            }
            else if(s.charAt(i)=='['){
                
                countStack.push(k);
                strStack.push(curr);
                curr=new StringBuilder();
                k=0;

            }
            else if(s.charAt(i)==']'){
                StringBuilder prev=strStack.pop();
                int repeat=countStack.pop();
                for(int j=0;j<repeat;j++){
                    prev.append(curr);
                }
                curr=prev;

            }
            else{
                curr.append(s.charAt(i));
            }
        }
        return curr.toString();
        
    }
}