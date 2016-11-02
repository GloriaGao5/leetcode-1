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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode res = stack.peek();
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(!stack.isEmpty()){
                cur.right = stack.peek();
                cur.left = stack.peek().right;
            }
        }
        cur.left = null;
        cur.right = null;
        return res;
    }
}