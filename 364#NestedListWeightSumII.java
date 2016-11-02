/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<List<Integer>> res = new ArrayList<>();
        NestedInteger root = new NestedInteger();
        for(NestedInteger child : nestedList){
            root.add(child);
        }
        int height = height(res, root, 0);
        int sum = 0;
        for(List<Integer> list : res){
            int subsum = 0;
            for(int num : list){
                subsum += num;
            }
            sum += (height--) * subsum;
        }
        return sum;
    }
    
    private int height(List<List<Integer>> res, NestedInteger ni, int level){
        if(res.size() < level) res.add(new ArrayList<Integer>());
        if(ni.isInteger()){
            res.get(level-1).add(ni.getInteger());
            return level;
        }
        int maxheight = 0;
        for(NestedInteger child : ni.getList()){
            maxheight = Math.max(maxheight, height(res, child, level + 1));
        }
        return maxheight;
    }
}