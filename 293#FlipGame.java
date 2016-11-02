public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                list.add(s.substring(0, i) + "--" + s.substring(i+2));
            }
        }
        return list;
    }
}