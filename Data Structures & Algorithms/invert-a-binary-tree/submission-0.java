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
    public TreeNode invertTree(TreeNode dummy) {
        //Treenode dummy=root;
        if(dummy==null) return null;
       
            TreeNode temp=dummy.left;
            dummy.left= dummy.right;
            dummy.right=temp;
            invertTree(dummy.left);
            invertTree(dummy.right);

        return dummy;
    }
        
    }