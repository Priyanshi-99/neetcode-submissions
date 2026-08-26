/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int res=0;
    public int diameter(Node root) {
        
        helper(root);
        return res;
        
    }
    public int helper(Node root){
        int longest=0;
        int secondlongest=0;
        if(root==null) return 0;
        int maxdepth=0;
        for(Node child:root.children){
            int curr=helper(child);

            if(curr>longest){
                secondlongest=longest;
                longest=curr;

            }
            else if(curr>secondlongest){
                secondlongest=curr;
            }
            res=Math.max(res,longest+secondlongest);
            
            
        }
        return longest+1;
    }
}
