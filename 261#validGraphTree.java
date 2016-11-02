public class Solution {
    class UnionFind{
        int[] parents;
        int[] weight;
        int size;
        
        public UnionFind(int size){
            this.parents = new int[size];
            this.weight = new int[size];
            this.size = size;
            for(int i = 0; i < size; i++){
                parents[i] = i;
                weight[i] = 1;
            }
        }
        
        public int find(int x){
            while(parents[x] != x){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
        
        public boolean union(int x, int y){
            int xP = find(x);
            int yP = find(y);
            if(xP == yP) return false;
            if(weight[xP] >= weight[yP]){
                parents[yP] = xP;
                weight[xP] += weight[yP];
            }else{
                parents[xP] = yP;
                weight[yP] += weight[xP];
            }
            size--;
            return true;
        }
    }

    
    public boolean validTree1(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return false;
        }
        return uf.size == 1;
    }
    
    public boolean validTree(int n, int[][] edges){
        HashSet[] child = new HashSet[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            child[i] = new HashSet<Integer>();
        }
        for(int[] edge : edges){
            child[edge[0]].add(edge[1]);
            child[edge[1]].add(edge[0]);
        }
        if(!DFS(child, visited, -1, 0)) return false;
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    
    private boolean DFS(HashSet[] child, boolean[] visited, int pre, int curNode){
        if(visited[curNode]) return false;
        visited[curNode] = true;
        HashSet<Integer> nexts = child[curNode];
        for(int next : nexts){
            if(next == pre) continue;
            if(!DFS(child, visited, curNode, next)) return false;
        }
        return true;
    }
}


// public class Solution {
//     public boolean validTree(int n, int[][] edges) {
//         boolean[] visited = new boolean[n];
//         List<Set<Integer>> edge = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             edge.add(new HashSet<Integer>());
//         }
//         for(int[] ed : edges){
//             edge.get(ed[0]).add(ed[1]);
//             edge.get(ed[1]).add(ed[0]);
//         }
        
//         if(!DFS(edge, visited, -1, 0)) return false;
//         for(boolean idx : visited){
//             if(!idx) return false;
//         }
//         return true;
//     }
    
//     private boolean DFS(List<Set<Integer>> edge, boolean[] visited, int pre, int node){
//         if(visited[node] == true) return false;
//         visited[node] = true;
//         for(Integer next : edge.get(node)){
//             if(next == pre) continue;
//             if(!DFS(edge, visited, node, next)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }