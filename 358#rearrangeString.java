public class Solution {
    class Ele{
        char val;
        int count;
        
        public Ele(char val, int count){
            this.val = val;
            this.count = count;
        }
        
        public void Add(){
            count++;
        }
        
        public void Dec(){
            count--;
        }
    }
    
    private void init(PriorityQueue<Ele> queue, String str){
        char[] strs = str.toCharArray();
        int[] count = new int[26];
        for(char ch : strs){
            count[ch - 'a'] ++;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0)
                queue.offer(new Ele((char)('a' + i), count[i]));
        }
    }
    
    public String rearrangeString(String str, int k) {
        if(k == 0) return str;
        PriorityQueue<Ele> queue = new PriorityQueue<>(new Comparator<Ele>(){
            public int compare(Ele e1, Ele e2){ return e2.count - e1.count;}
        });
        Map<Integer, Ele> recover = new HashMap<>();
        init(queue, str);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(recover.containsKey(i)) queue.offer(recover.get(i));
            if(queue.isEmpty()) return "";
            Ele cur = queue.poll();
            sb.append(cur.val);
            cur.Dec();
            if(cur.count != 0 && i + k < str.length()) recover.put(i + k, cur);
        }
        return sb.toString();
    }
}