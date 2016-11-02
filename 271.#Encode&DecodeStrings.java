public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(strs.size() + "#");
        for(String str : strs){
            sb1.append(str.length() + "#");
            sb2.append(str);
        }
        sb1.append(sb2.toString());
        return sb1.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        List<Integer> idx = new ArrayList<Integer>();
        String[] tmp = s.split("#");
        int total = Integer.parseInt(tmp[0]);
        int start = tmp[0].length() + 1;
        for(int i = 1; i <= total; i++){
            idx.add(Integer.parseInt(tmp[i]));
            start += (tmp[i].length() + 1);
        }
        for(Integer len : idx){
            res.add(s.substring(start, start + len));
            start += len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));