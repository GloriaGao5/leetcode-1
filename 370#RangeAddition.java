public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] scale = new int[length];
        int start, end, value;
        for(int[] update : updates){
            start = update[0];
            end = update[1];
            value = update[2];
            
            scale[start] += value;
            if(end + 1 < length)
                scale[end + 1] -= value;
        }
        
        for(int i = 1; i < length; i++){
            scale[i] += scale[i-1];
        }
        return scale;
    }
}