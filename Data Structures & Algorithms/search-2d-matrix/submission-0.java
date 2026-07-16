class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows=matrix.length, cols=matrix[0].length;
        int low=0,high=rows-1;
        int row=-1;
        //int ans[]=new int[row];
        while(low<=high){
        int mid = low + (high - low) / 2;

            if(target>matrix[mid][cols-1]){
                low=mid+1;
            }
            else if(target<matrix[mid][0]){
                high=mid-1;
            }
            else{
                row=mid;
                break;
            }
        }
        if (row == -1) return false;

        int left=0,right=cols-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
       return false;

        
    }
}
