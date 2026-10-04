class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[]changes=new int[1001];
        for(int[] trip:trips){
            int passenger=trip[0];
            int from=trip[1];
            int to=trip[2];

            changes[from]+=passenger;
            changes[to]-=passenger;
        }
        int passengerincar=0;
        for(int loc=0;loc<=1000;loc++){
            passengerincar+=changes[loc];
            if(passengerincar>capacity){
                return false;
            }
        }
        return true;
        
    }
}