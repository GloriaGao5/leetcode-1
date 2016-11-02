public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
            List<Integer> tmp = map.getOrDefault(words[i], new ArrayList<Integer>());
            tmp.add(i);
            map.put(words[i], tmp);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for(int id1 = 0, id2 = 0; id1 < list1.size() && id2 < list2.size(); ){
            int idx1 = list1.get(id1);
            int idx2 = list2.get(id2);
            if(idx1 < idx2){
                min = Math.min(min, idx2 - idx1);
                id1++;
            }else{
                min = Math.min(min, idx1 - idx2);
                id2++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");