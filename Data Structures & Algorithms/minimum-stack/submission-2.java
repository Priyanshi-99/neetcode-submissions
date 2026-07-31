class MinStack {
     Stack<Long> stk;
     private long mini;
    public MinStack() {
     stk=new Stack<>();
     mini=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long x=val;
        if(stk.isEmpty()){
            stk.push(x);
            mini=x;
            
        }
        else{
            if(x>=mini){stk.push(x);}

            else{
                stk.push(2*x-mini);
                mini=x;
            }
        }
        
    }
    
    public void pop() {

        if(stk.isEmpty()) return;
        else{
            long x=stk.peek();
            stk.pop();
            if(x<mini){
                
                mini=2*mini-x;
            }
           
        }


        
    }
    
    public int top() {
        if(stk.isEmpty()) return -1;

        long x=stk.peek();
        if(x<mini) return (int) mini;

        return (int) x;

        
    }
    
    public int getMin() {
   return (int) mini;     
    }
}
