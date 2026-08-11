class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean [] vis=new boolean[n];
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[]edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(n,edges,vis,i,adj);
                count++;
            }
        }
return count;
    }
    public void dfs(int n,int[][]graph,boolean[]vis,int i,List<Integer>[] adj){

        //dfs
        vis[i]=true;
        
            for(int nei: adj[i]){
                if(vis[nei]!=true){
                
                dfs(n,graph,vis,nei,adj);
                }
            
        }

        
    }
}
