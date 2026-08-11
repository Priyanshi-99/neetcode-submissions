class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum=0;
        int costsum=0;
        for(int i=0;i<gas.length;i++){
            gassum+=gas[i];
            costsum+=cost[i];

        }
        if(gassum<costsum) return -1;
        int total=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                res=i+1;
            }
        }
        return res;
    }
}
