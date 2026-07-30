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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode rightone=null;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                rightone=node;
                if(node.left!=null ) q.offer(node.left);  
                if(node.right!=null) q.offer(node.right);
                          
                           
                 

            }
            ls.add(rightone.val);

        }
        return ls;
    }
}
