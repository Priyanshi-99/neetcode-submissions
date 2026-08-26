class Solution {
    public int diameter=0;
    public int treeDiameter(int[][] edges) {
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<edges.length+1;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }
       // bfs
        //dfs
        dfs(0,-1,ls);
        return diameter;    
    }
    public int dfs(int node,int parent,List<List<Integer>> ls){
        int longest=0;
        int seclongest=0;
        for(int nei:ls.get(node)){
            if(nei==parent){
                continue;
            }
            int childH= dfs(nei,node,ls)+1;

            if(childH>longest){
                seclongest=longest;
                longest=childH;
            }
            else if(childH>seclongest){
                seclongest=childH;
            }
        }
            diameter=Math.max(diameter,longest+seclongest);

        
        return longest;
    }
}
