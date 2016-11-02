public class Solution {
    public boolean validWordSquare(List<String> words) {
        int row = words.size();
        int col = words.get(0).length();
        if(row != col) return false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= col) return false;
                if(i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) return false;;
            }
        }
        return true;
    }
}