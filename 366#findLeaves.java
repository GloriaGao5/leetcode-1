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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private int helper(TreeNode root, List<List<Integer>> res){
        if(root == null) return -1;
        int level = 1 + Math.max(helper(root.left, res), helper(root.right, res));
        if(res.size() < (level + 1)) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        return level;
    }
}