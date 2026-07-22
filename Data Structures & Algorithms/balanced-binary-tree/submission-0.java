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
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root)!=-1){
            return true;
        }
        return false;

        
    }

    public int checkHeight(TreeNode node){
        if(node==null) return 0;
        int left=checkHeight(node.left);
        int right=checkHeight(node.right);

        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;

        }
        return 1+Math.max(left,right);
    }
}
