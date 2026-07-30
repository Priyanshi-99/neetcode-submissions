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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
         if(root==null) return ls;
        q.add(root);
       
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int num=q.size();
            for(int i=0;i<num;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                temp.add(q.poll().val);
            }
            ls.add(temp);

        }
        return ls;

        
        
    }
}
