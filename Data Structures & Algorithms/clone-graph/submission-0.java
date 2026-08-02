/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldtonew=new HashMap<>();
        return dfs(node,oldtonew);



    
    }
    public Node dfs(Node node,  Map<Node,Node> oldtonew){

if(node==null) return null;

if(oldtonew.containsKey(node)){
    return oldtonew.get(node);
}
//agaar presnet nahi hai ahsmap m toh new copy aban ke uska original or copied node dodno add kr denge yhaa pe
Node copy=new Node(node.val);
oldtonew.put(node,copy);

for(Node nei:node.neighbors){
    copy.neighbors.add(dfs(nei,oldtonew));
}
return copy;




    }




























}