class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int left=0;
        int right=n-k;
        List<Integer> res=new ArrayList<>();
        while(left<right){
            int mid=left+(right-left)/2;
            int leftE=arr[mid];
            int rightE=arr[mid+k];
            if(x-leftE>rightE-x){
                left=mid+1;
            }
            else{
                right=mid;
            }
            
        }
        for(int i=left;i<left+k;i++){
            res.add(arr[i]);
        }
        return res;

    }
}