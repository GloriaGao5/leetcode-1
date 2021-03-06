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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        
        Stack<Integer> succ = new Stack<>();
        Stack<Integer> pred = new Stack<>();
        
        initPredecessorStack(root, target, pred);
        initSuccessorStack(root, target, succ);
        
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }
        
    }
}

// public List<Integer> closestKValues(TreeNode root, double target, int k) {
//         List<Integer> res = new ArrayList<>();
        
//         Stack<Integer> s1 = new Stack<>();
//         Stack<Integer> s2 = new Stack<>();
        
//         inorder(root, target, false, s1);
//         inorder(root, target, true, s2);
        
//         while(k-- > 0){
//             if(s1.isEmpty())
//                 res.add(s2.pop());
//             else if(s2.isEmpty())
//                 res.add(s1.pop());
//             else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
//                 res.add(s1.pop());
//             else
//                 res.add(s2.pop());
//         }
        
//         return res;
        
//     }
    
//     private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
//         if(root == null) return;
        
//         inorder(reverse ? root.right : root.left, target, reverse, stack);
        
//         if(root.val <= target == reverse) return;
        
//         stack.push(root.val);
        
//         inorder(reverse ? root.left : root.right, target, reverse, stack);
//     }