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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=true;
        if(root==null)return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            Integer[] temp=new Integer[size];
            for(int i=0;i<size;i++){
          
            root=q.poll();  
            int index=flag?i:size-i-1;
            temp[index]=root.val;
            if(root.left!=null) q.offer(root.left);
            if(root.right!=null) q.offer(root.right);
            
        }
        flag=!flag;
        res.add(Arrays.asList(temp));
        }
      return res;  
    }
}