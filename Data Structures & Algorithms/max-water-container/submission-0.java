class Solution {
    public int maxArea(int[] heights) {
        int i=0,j=heights.length-1;
        int res=0;
        while(i<j){
            int water=(j-i)*Math.min(heights[i],heights[j]);
            res=Math.max(water,res);
            if(heights[i]<heights[j]){
                i++;
            }
            else{
            j--;
            }
        }
       return res; 
    }
}
