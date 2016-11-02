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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        
        if(root != null){
            queue.offer(root);
            idx.offer(0);
        }
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int curIdx = idx.poll();
            
            if(cur.left != null){
                queue.offer(cur.left);
                idx.offer(curIdx-1);
            }
            
            if(cur.right != null){
                queue.offer(cur.right);
                idx.offer(curIdx+1);
            }
            
            if(curIdx >= 0){
                if(curIdx == right.size()){
                    right.add(new ArrayList<Integer>());
                }
                right.get(curIdx).add(cur.val);
            }else{
                curIdx = - 1 - curIdx;
                if(curIdx == left.size()){
                    left.add(new ArrayList<Integer>());
                }
                left.get(curIdx).add(cur.val);
            }
        }
        
        Collections.reverse(left);
        left.addAll(right);
        return left;
        
    }
}