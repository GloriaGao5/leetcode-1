public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                map.put(words[i], i);
                if(map.containsKey(word1) && map.containsKey(word2)){
                    res = Math.min(res, Math.abs(map.get(word1) - map.get(word2)));
                }
            }
        }
        return res;
    }
}