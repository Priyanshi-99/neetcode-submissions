class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stk=new Stack<>();
        int nse=0,pse=0,element=0;
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty() && heights[i]<heights[stk.peek()]){
                element=stk.pop();
                //stk.pop();
                nse=i;
                pse= stk.isEmpty()? -1:stk.peek();
                maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));

            }
            stk.push(i);
        }
            while(!stk.isEmpty()){
                nse=heights.length;
                
                element=stk.pop();
                //stk.pop();
                pse= stk.isEmpty()? -1:stk.peek();
                maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
            }
        return maxArea;
            
    }
}
