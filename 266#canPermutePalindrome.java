public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] bitMap = new int[4];
        for(char ch : s.toCharArray()){
            int index = (ch) / 32;
            int shift = (ch) % 32;
            bitMap[index] ^= (1 << shift);
        }
        int notZeroCount = 0;
        for(int map : bitMap){
            if(map != 0){
                notZeroCount++;
            }
            if((map & (map - 1)) != 0) return false;
        }
        return notZeroCount <= 1;
    }
}