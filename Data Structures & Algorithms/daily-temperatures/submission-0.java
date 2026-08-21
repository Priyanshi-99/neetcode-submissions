class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
           while(!stk.isEmpty() && temperatures[i]>temperatures[stk.peek()]){
            int prev_index=stk.pop();
            res[prev_index]=i-prev_index;

           }
           stk.push(i);
        }
        return res;
    }
}
