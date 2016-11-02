public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    
    // generate all;
    private void helper(List<String> res, StringBuilder sb, char[] c, int i, int num){
        int len = sb.length();
        if(i == c.length){
            if(num != 0) sb.append(num);
            res.add(sb.toString());
        }else{
            helper(res, sb, c, i + 1, num + 1); //abbr c[i];
            
            if(num != 0) sb.append(num);
            helper(res, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }
}