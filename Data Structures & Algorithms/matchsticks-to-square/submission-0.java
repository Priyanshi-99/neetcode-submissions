class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total=0;
        for(int stick:matchsticks){
            total+=stick;
        }
        if(total%4!=0){
            return false;
        }
        int sideLen=total/4;
        for(int stick:matchsticks){
            if(stick>sideLen){
                return false;
            }
        }
        Arrays.sort(matchsticks);
        int[] sides=new int[4];

        return backtrack(matchsticks,0,sides,sideLen);     
    }

    private boolean backtrack(int[] matchsticks,int i,int [] sides,int target){
        if(i==matchsticks.length){
            return true;
        }
        int stick=matchsticks[i];

        for(int side=0;side<4;side++){
            if(sides[side]+stick>target){
                continue;
            }
            sides[side]+=stick;
            if(backtrack(matchsticks,i+1,sides,target)){
                return true;
            }
            sides[side]-=stick;
            if(sides[side]==0){
                break;
            }

        }
        return false;
    }
    private void reverse(int[]arr){
        int left=0;
        int right=arr.length-1;
        if(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }

}