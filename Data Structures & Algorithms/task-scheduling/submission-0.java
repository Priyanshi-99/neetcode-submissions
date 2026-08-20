class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(int task:tasks){
            count[task-'A']++;
        }
        Arrays.sort(count);
        int chunk=count[25]-1;
        int idle=chunk*n;
        for(int i=24;i>=0;i--){
            idle-=Math.min(chunk,count[i]);
        }

        if(idle<0) return tasks.length;
        return tasks.length+idle;







        
    }
}
