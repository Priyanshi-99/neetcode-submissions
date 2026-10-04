class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                ind=i;
                break;

            }
        }
        // already maximum hai
        if(ind==-1){
            rev(nums,0);  
        }
        else{
        ///just greater elemet we will find
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[ind]){
                swap(nums,ind,i);
                break;
            }
        }
        rev(nums,ind+1);
        }
    }

    public void rev(int nums[],int c){
        int n=nums.length;
        int i=c;
        int j=n-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }

    }

    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}