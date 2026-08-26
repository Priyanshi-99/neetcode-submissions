class Solution {
    public double averageWaitingTime(int[][] customers) {
        //greedy approch
        double waitingTime=customers[0][1];
        int time_to_prep=customers[0][1]+customers[0][0];
        for(int i=1;i<customers.length;i++){
            int[] time=customers[i];
            int arrivetime=time[0];

            int startcook=Math.max(arrivetime,time_to_prep);
            int endtime=startcook+time[1];
            time_to_prep=endtime;
            waitingTime+=endtime-arrivetime;



        }
           return waitingTime/customers.length;
    }
}