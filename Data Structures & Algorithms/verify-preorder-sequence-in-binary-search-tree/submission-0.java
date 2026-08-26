class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack=new ArrayDeque<>();
        int lowerbound=Integer.MIN_VALUE;

        for(int value:preorder){
            if(value<=lowerbound){
                return false;
            }
            while(!stack.isEmpty()&& value>stack.peek()){
                lowerbound=stack.pop();
            }
            stack.push(value);
        }
        return true;

        
    }
}
