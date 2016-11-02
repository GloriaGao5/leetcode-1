public class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary){
            String abbr = getAbbr(word);
            Set<String> tmp = map.getOrDefault(abbr, new HashSet<String>());
            tmp.add(word);
            map.put(abbr, tmp);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return (!map.containsKey(abbr)) || (map.get(abbr).contains(word) && map.get(abbr).size() <= 1);
    }
    
    private String getAbbr(String word){
        int length = word.length();
        if(length <= 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(length - 2);
        sb.append(word.charAt(length-1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");