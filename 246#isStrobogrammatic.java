public class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[10];
    	Arrays.fill(map, -1);
    	map[6] = 9;
    	map[9] = 6;
    	map[8] = 8;
    	map[1] = 1;
    	map[0] = 0;
    	for(int i = 0; i <= num.length() / 2; i++){
    	    char ch = num.charAt(i);
			char hc = num.charAt(num.length() - i - 1);
			if(map[ch - '0'] != hc - '0') return false;
    	}
    	return true;
    }
}