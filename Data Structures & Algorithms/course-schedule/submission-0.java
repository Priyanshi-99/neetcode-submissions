class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }

       int[] indegree=new int[numCourses];

       for(int[] pair:prerequisites){
        int cou=pair[0];
        int preq=pair[1];
        adj.get(preq).add(cou);
        indegree[cou]++;
       }

       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.offer(i);

        }
       }

       int pro=0;

       while(!q.isEmpty()){
        int curr=q.poll();
        pro++;

        for(int dep:adj.get(curr)){
            indegree[dep]--;
            if(indegree[dep]==0){
                q.offer(dep);
            }
        }
       }
return pro==numCourses;

        
    }
}
