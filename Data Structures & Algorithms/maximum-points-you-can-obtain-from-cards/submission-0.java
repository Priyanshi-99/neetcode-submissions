class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int windowSize=n-k;
        int totalsum=0;
        for(int i:cardPoints){
            totalsum+=i;
        }
        int windowsum=0;
        //first window
        for(int i=0;i<windowSize;i++){
            windowsum+=cardPoints[i];
        }

        int miniWindowSum=windowsum;
        //sliding window
        for(int r=windowSize;r<n;r++){
            windowsum+=cardPoints[r];
            windowsum-=cardPoints[r-windowSize];
            miniWindowSum=Math.min(miniWindowSum,windowsum);
        }
       
        return totalsum-miniWindowSum;

        
    }
}