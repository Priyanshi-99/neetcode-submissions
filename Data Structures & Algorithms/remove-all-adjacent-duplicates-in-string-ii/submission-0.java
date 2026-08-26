class Pair{
    char c;
    int count;
    Pair(char c,int count){
        this.c=c;
        this.count=count;
    }
}
class Solution {

    public String removeDuplicates(String s, int k) {
        StringBuilder res=new StringBuilder();
        Deque<Pair> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){

        if(!stack.isEmpty() && s.charAt(i)==stack.peek().c){
             stack.peek().count++;
            if(stack.peek().count==k){
                stack.pop();
            }
            
        }
        else{
            stack.push(new Pair(s.charAt(i),1));
        }
        }
        
        while(!stack.isEmpty()){
            Pair current=stack.pop();
        
            for(int i=0;i<current.count;i++){
                res.append(current.c);
            }

        
        }
return res.reverse().toString();
        



        
        
    }
}
/*
deeeedbbccbdaa



*/