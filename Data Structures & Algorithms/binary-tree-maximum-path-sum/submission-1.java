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
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        
         dfs(root);
        return maxi;
        
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;

            int leftsum = Math.max(dfs(node.left), 0);
    int rightsum = Math.max(dfs(node.right), 0);
        maxi=Math.max(maxi,leftsum+rightsum+node.val);
        ///yaha pe hum max sum nikal rhe hai ki kitna maxiumum ho skta hai sum

        return node.val+Math.max(leftsum,rightsum);
        //yha pe konsa path choose krna hai like jo jayada sum de

    }
}
