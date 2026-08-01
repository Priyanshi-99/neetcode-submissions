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
    private int cnt=0;
    private int result=-1;
    public int kthSmallest(TreeNode root, int k) {
       
         dfs(root,k);
         return result;

        
    }

    public void dfs(TreeNode root,int k){
        if(root==null || result!=-1) return ;
        //left first acc to inorder
        dfs(root.left,k);
        cnt++;

        if(cnt==k){
            result=root.val;
            return;
        }

        dfs(root.right,k);

        // if(cnt==k) return root.val;
        // if(root.left.val<root.val) cnt++;

        // dfs(root.left,k,cnt);
        // dfs(root.right,k,cnt);

        // return root.val;
    }


















}
