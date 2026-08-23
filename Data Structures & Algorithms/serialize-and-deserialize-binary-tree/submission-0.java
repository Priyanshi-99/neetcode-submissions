/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb=new StringBuilder();
    public String serialize(TreeNode root) {
        TreeNode dummy=root;
        dfs(dummy,sb);
        return String.valueOf(sb);
        
    }
    public void dfs(TreeNode dummy,StringBuilder sb){
        if(dummy==null){
            sb.append("N,");
            return;
        }
        sb.append(dummy.val).append(",");
        dfs(dummy.left,sb);
        dfs(dummy.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] token=data.split(",");
        Queue<String> q=new LinkedList<>(Arrays.asList(token));
        return dfsDeserial(q);
       
        
    }
    public TreeNode dfsDeserial(Queue<String> q){
       
            String val=q.poll();
            if(val.equals("N")){
                return null;
            
            }
            TreeNode t=new TreeNode(Integer.parseInt(val));
            t.left=dfsDeserial(q);
            t.right=dfsDeserial(q);
            return t;
        }
    
}












