class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] res=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }
        int[] indegree=new int[numCourses];
        

        for(int[] pair:prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
            
        }
    
    Queue<Integer> q=new LinkedList<>();

    for(int course=0;course<numCourses;course++){
        if(indegree[course]==0){
            q.offer(course);
        }
    }
    int ind=0;
    while(!q.isEmpty()){
        int curr=q.poll();
        res[ind++]=curr;


        for(int next:adj.get(curr)){
            indegree[next]--;
            if(indegree[next]==0){
                q.offer(next);
            }
        }
    }
    if(ind!=numCourses){
        return new int[0];
    }

    return res;
    }

}

















