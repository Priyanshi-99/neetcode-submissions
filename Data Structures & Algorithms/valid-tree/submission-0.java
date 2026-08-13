class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        Set<Integer> hs=new HashSet<>();
        int prev=-1;

        return dfs(0,adj,prev,hs,n)&& hs.size()==n ;
}

    public boolean dfs(int i,List<List<Integer>> adj,int prev,Set<Integer> hs,int n){

        if(hs.contains(i)){
            return false;
        }
        hs.add(i);

        for(int nei: adj.get(i)){
            if(nei==prev){
                continue;
            }
            if(!dfs(nei,adj,i,hs,n)) return false;

        }

        return true;

    }
}
