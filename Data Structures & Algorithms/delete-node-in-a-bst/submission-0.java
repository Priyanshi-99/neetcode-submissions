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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        //search in appropriate tree
        if(key<root.val){
            root.left=deleteNode(root.left,key);

        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);

        }
        //delete the node: root is the node to be deleted
        else{
            //no right childs
            if(root.left==null){
                return root.right;
            }
            //no left childs
            if(root.right==null){
                return root.left;
            }
            //two childs
            //find the delete node's left
            TreeNode replacment=root.right;
            while(replacment.left!=null){
                replacment=replacment.left;
            }
            replacment.left=root.left;

            return root.right;


        }

        return root;
        
    }
}