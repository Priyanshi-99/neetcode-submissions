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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if(isLeaf(root)){
            res.add(root.val);
            return res;
        }
        res.add(root.val);
        dfsleft(root.left,res);
        addLeavs(root,res);
        dfsright(root.right,res);
        return res;      
    }
    public void dfsleft(TreeNode node,List<Integer> res){
        while(node!=null){
        if(!isLeaf(node)){
            res.add(node.val);

        }
        //to choose right if left is null
        if(node.left!=null){
            node=node.left;
        }
        else{
            node=node.right;
        }
        }
    }

    public void addLeavs(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        if(isLeaf(node)){
            res.add(node.val);
            return;
        }
        addLeavs(node.left,res);
        addLeavs(node.right,res);
    }
    public boolean isLeaf(TreeNode node){
        if(node!=null && node.left==null && node.right==null){
            return true;
        }
        return false;
    }
    public void dfsright(TreeNode node,List<Integer> res){

        List<Integer> temp=new ArrayList<>();
        while(node!=null){
            if(!isLeaf(node)){
                temp.add(node.val);
            }
            //to choose left is right==null
            if(node.right!=null){
                node=node.right;
            }
            else{
                node=node.left;
            }

        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }

    }




}
