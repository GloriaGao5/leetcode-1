public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper){
        int[] fnums = new int[nums.length + 2];
        fnums[0] = lower-1;
        fnums[fnums.length-1] = upper+1;
        for(int i = 1; i < fnums.length-1; i++){
            fnums[i] = nums[i-1];
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < fnums.length-1; i++){
            String range = getRange(fnums[i], fnums[i+1]);
            if(range.equals("")) continue;
            res.add(range);
        }
        
        return res;
    }
    
    private String getRange(int start, int end){
        StringBuilder sb = new StringBuilder();
        if(start >= end - 1){
            return sb.toString();
        }else if(start == end - 2){
            sb.append(start+1);
        }else{
            sb.append(start+1);
            sb.append("->");
            sb.append(end-1);
        }
        return sb.toString();
    }
}