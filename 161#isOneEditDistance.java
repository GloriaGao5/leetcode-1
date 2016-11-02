public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        for(int i = 0; i < Math.min(sLen, tLen); i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            else{
                if(t.substring(i+1).equals(s.substring(i+1)) 
                    || t.substring(i).equals(s.substring(i+1)) 
                    || t.substring(i+1).equals(s.substring(i))) return true;
                else return false;
                    
            }
        }
        return Math.abs(sLen-tLen) == 1;
    }
}