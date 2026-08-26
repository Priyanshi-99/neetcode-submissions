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
    private int inIdx;
    private int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        inIdx=0;
        preIdx=0;
        return buildBT(preorder,inorder,Integer.MIN_VALUE);
        
    }
    private TreeNode buildBT(int[]preorder,int[]inorder,int boundry){
        if(preIdx>=preorder.length){
            return null;//no vlues remains
        }
        if(inorder[inIdx]==boundry){
            inIdx++;
            return null;
        }
        //preorder gives us root
        TreeNode node=new TreeNode(preorder[preIdx++]);
        node.left=buildBT(preorder,inorder,node.val);
        node.right=buildBT(preorder,inorder,boundry);

        return node;
    }
























}
