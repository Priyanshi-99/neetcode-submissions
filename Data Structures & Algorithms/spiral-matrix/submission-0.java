class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();

        int top=0;
        int bottom=matrix.length;
        int left=0;
        int right=matrix[0].length;

        while(top<bottom && left<right){
            for(int col=left;col<right;col++){
                res.add(matrix[top][col]);
            }
            top++;

            for(int row=top;row<bottom;row++){
                res.add(matrix[row][right-1]);
            }
            right--;
            if(!(top<bottom && left<right)){
                break;
            }
            for(int col=right-1;col>=left;col--){
                res.add(matrix[bottom-1][col]);
            }
            bottom--;
            for(int row=bottom-1;row>=top;row--){
                res.add(matrix[row][left]);
            }
            left++;

        }
        return res;
        


        
    }
}
