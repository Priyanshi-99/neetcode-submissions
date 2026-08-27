class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph=new HashMap<>();
        for(List<String> ticket:tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);
            graph.computeIfAbsent(from,k->new PriorityQueue<>()).offer(to);
        }

        List<String> res=new ArrayList<>();
        dfs("JFK",graph,res);
        Collections.reverse(res);
        return res;
        
    }
    public void dfs(String airport,Map<String,PriorityQueue<String>> graph,List<String> res){
        PriorityQueue<String> dest=graph.get(airport);
        while(dest!=null && !dest.isEmpty()){
            String next=dest.poll();
            dfs(next,graph,res);

        }
        res.add(airport);
    }
}
