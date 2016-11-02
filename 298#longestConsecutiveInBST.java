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
    public int longestConsecutive(TreeNode root) {
        int[] maxLen = new int[]{0};
        helper(root, Integer.MIN_VALUE, 0, maxLen);
        return maxLen[0];
    }
    
    private void helper(TreeNode root, int pre, int curLen, int[] maxLen){
        if(root == null){
            maxLen[0] = Math.max(maxLen[0], curLen);
            return;
        }
        if(root.val == pre + 1 || pre == Integer.MIN_VALUE){
            curLen++;
        }else{
            maxLen[0] = Math.max(maxLen[0], curLen);
            curLen = 1;
        }
        helper(root.left, root.val, curLen, maxLen);
        helper(root.right, root.val, curLen, maxLen);
    }
}