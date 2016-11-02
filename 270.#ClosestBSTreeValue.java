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
    public int closestValue(TreeNode root, double target) {
        if(root.left == null && root.right == null) return root.val;
        if(target < root.val){
            if(root.left == null){
                return root.val;
            }else{
                int minLeft = closestValue(root.left, target);
                return Math.abs(minLeft - target) > Math.abs(root.val - target) ? root.val : minLeft;
            }
        }else if(target > root.val){
            if(root.right == null){
                return root.val;
            }else{
                int minRight = closestValue(root.right, target);
                return Math.abs(minRight - target) > Math.abs(root.val - target) ? root.val : minRight;
            }
        }else{
            return root.val;
        }
    }
}