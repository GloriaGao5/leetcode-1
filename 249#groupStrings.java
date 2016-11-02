public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            String key = getKey(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                map.put(key, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        for(List<String> group : map.values()){
            res.add(group);
        }
        return res;
    }
    
    private String getKey(String str){
        int shift = str.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            sb.append((ch + 26 - shift) % 26);
        }
        return sb.toString();
    }
}