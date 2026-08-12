class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk=new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            boolean destroyed=false;
         
            while(!stk.isEmpty() && (asteroids[i]<0 && stk.peek()>0)){
                if(Math.abs(asteroids[i])>Math.abs(stk.peek())){
                    stk.pop();
                }
                else if(Math.abs(asteroids[i])==Math.abs(stk.peek())){
                    stk.pop();
                    destroyed=true;
                    break;
                }
                else {
                    destroyed=true;
                     break;
                }
            }
                if(!destroyed){
                    stk.push(asteroids[i]);
                }
                
                // if(stk.isEmpty()){
                //     stk.push(asteroids[i]);
                // }
               
            
           
            
        }
        int[] ans=new int[stk.size()];
           int j=stk.size()-1;
           while(!stk.isEmpty()){
            ans[j--]=stk.pop();
           }
        return ans;

        
    

}
}