/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
   
    public Node connect(Node root) {
        //bfs
        if(root==null) return null;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int level=q.size();
           
            for(int i=0;i<level;i++){
                 Node curr=q.poll();
                  // Same level ke next node se connect
                 if(i<level-1){
                    curr.next=q.peek();
                 }
                 else{
                    curr.next=null;
                 }

                   // Sirf non-leaf nodes ke children hote hain
                if(curr.left!=null){
                    curr.left.next=curr.right;
                if(curr.next!=null){
                
                    curr.right.next=curr.next.left;
                }

                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                

            }
        }
        return root;
























    }
}