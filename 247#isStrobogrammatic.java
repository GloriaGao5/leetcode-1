public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    
    Set<Integer> set = new HashSet<>(Arrays.asList(1, 8, 0));
    
    public List<String> findStrobogrammatic(int n) {
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        map.put(0, 0);
        List<String> res = new ArrayList<>();
        helper(n/2, (n & 1) == 1, new StringBuilder(), res);
        return res;
    }
    
    private void helper(int len, boolean odd, StringBuilder sb, List<String> res){
        if(sb.length() == len){
            String post = getPost(sb.toString());
            if(odd){
                for(int num : set){
                    int length = sb.length();
                    res.add(sb.append(num).append(post).toString());
                    sb.setLength(length);
                }
            }else{
                res.add(sb.append(post).toString());
            }
            return;
        }
        for(int num : map.keySet()){
            if(num == 0 && sb.length() == 0) continue;
            int length = sb.length();
            helper(len, odd, sb.append(num), res);
            sb.setLength(length);
        }
    }
    
    private String getPost(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            sb.insert(0, map.get(ch-'0'));
        }
        return sb.toString();
    }
}