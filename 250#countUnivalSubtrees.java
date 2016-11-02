/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        if(isUnivalSubtree(root, root.val)) count ++;
        return count;
    }
    
    public boolean isUnivalSubtree(TreeNode root, int val){
        boolean left = false;
        boolean right = false;
        
        if(root.left != null){
            if(isUnivalSubtree(root.left, root.left.val)){
                count++;
                if(root.val == root.left.val) left = true;
            }
        }else{
            left = true;
        }
        
        if(root.right != null){
            if(isUnivalSubtree(root.right, root.right.val)){
                count++;
                if(root.val == root.right.val) right = true;
            }
        }else{
            right = true;
        }
        
        if(left && right) return true;
        else return false;
    }
}