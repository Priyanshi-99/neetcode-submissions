class Solution {
    private int[] parent;
    private int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        size=new int[n+1];

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(!union(u,v)){
                return edge;
            }
            
        }
        return new int[0];
    }
    private int findP(int node){
        if(parent[node]==node){
            return parent[node];
        }
        return parent[node]=findP(parent[node]);
    }
    private boolean union(int u,int v){
        int up_u=findP(u);
        int up_v=findP(v);
        if(up_v==up_u) return false;//cycle hai

        if(size[up_u]<size[up_v]){
            parent[up_v]=up_u;
            size[up_v]+=size[up_u];
        }
        else{
        parent[up_u]=up_v;
        size[up_u]+=size[up_v];
        }

        return true;
    }











}
