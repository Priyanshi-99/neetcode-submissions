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
    public int goodNodes(TreeNode root) {
        return cal(root,root.val);   
    }
    public int cal(TreeNode node,int maxi){
        if(node==null) return 0;
        int count=(node.val>=maxi)?1:0;

        maxi=Math.max(maxi,node.val);
        count+=cal(node.left,maxi);
        count+=cal(node.right,maxi);

        return count;


    }
}
