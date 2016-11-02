public class Solution {
    public boolean canWin(String s) {
        char[] ss = s.toCharArray();
        return canWin(ss);
    }
    
    private boolean canWin(char[] ss){
        for(int i = 0; i < ss.length - 1; i++){
            if(ss[i] == '+' && ss[i+1] == '+'){
                ss[i] = '-';
                ss[i+1] = '-';
                boolean win = !canWin(ss);
                ss[i] = '+';
                ss[i+1] = '+';
                if(win) return true;
            }
        }
        return false;
    }
    
    
}