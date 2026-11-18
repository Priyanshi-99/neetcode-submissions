

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Integer[] jobs=new Integer[profit.length];
        int n=startTime.length;
        //store job index so we can sort jobs by start time
        for(int i=0;i<startTime.length;i++){
            jobs[i]=i;
        }
        int[] dp=new int[n+1];
        Arrays.sort(jobs, Comparator.comparingInt(i -> startTime[i]));
        for(int i=n-1;i>=0;i--){
            int currJob=jobs[i];
            //next points to search for better job which startTime >= endTime as we sort the array
            int next=findJob(i,endTime[currJob],jobs,startTime);
//here we create one option for take/skip skip pe ek kadam age and take pe uska stored value+curr profit
            int take=profit[currJob]+dp[next];
            int skip=dp[i+1];
            dp[i]=Math.max(take,skip);
        }
        return dp[0];   
    }

    private int findJob(int currInd,int currEnd,Integer[]jobs,int[] startTime){
        int left=currInd+1;
        int right=jobs.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(startTime[jobs[mid]]>=currEnd){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

}