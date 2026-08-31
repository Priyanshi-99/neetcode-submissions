class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int left=0;
        int right=n-1;

        while(left<right){
            for(int off=0;off<right-left;off++){
                int top=left;
                int bottom=right;
                int topleft=matrix[top][left+off];
                 // bottom-left -> top-left
                matrix[top][left+off]=matrix[bottom-off][left];
                 // bottom-right -> bottom-left
                matrix[bottom-off][left]=matrix[bottom][right-off];
                // top-right->bottom-right
                matrix[bottom][right-off]=matrix[top+off][right];


                matrix[top+off][right]=topleft;

            }
            left++;
            right--;
        }

        
    }
}
