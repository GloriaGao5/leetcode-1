public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0;
        int maxLen = 0;
        int start = 0;
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            if(count[chs[i]]++ == 0) num ++;
            if(num > k){
                while(--count[chs[start++]] != 0);
                num--;
            }
            maxLen = Math.max(maxLen,1 + i-start);
        }
        return maxLen;
    }
}