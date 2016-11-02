public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                if(idx2 >= 0) res = Math.min(res, i - idx2);
                idx1 = i;
                if(word1.equals(word2)){
                    idx2 = i;
                }
                continue;
            }
            if(words[i].equals(word2)){
                if(idx1 >= 0) res = Math.min(res, i - idx1);
                idx2 = i;
            }
        }
        return res;
    }
}