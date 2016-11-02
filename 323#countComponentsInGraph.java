public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<Integer>());
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            visited[i] = true;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : map.get(cur)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            count++;
        }
        return count;
    }
}