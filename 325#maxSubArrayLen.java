public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int curSum = 0;
        map.put(curSum, -1);
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(map.containsKey(curSum - k)){
                maxLen = Math.max(maxLen, i - map.get(curSum - k));
            }
            if(!map.containsKey(curSum)){
                map.put(curSum, i);
            }
        }
        return maxLen;
    }
}