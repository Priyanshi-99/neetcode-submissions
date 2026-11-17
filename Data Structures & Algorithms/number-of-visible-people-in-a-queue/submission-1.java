class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack=new ArrayDeque<>();

        int[] ans=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<heights[i]){
                stack.pop();
                ans[i]++;
            }
            if(!stack.isEmpty()){
                ans[i]++;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
}