public class Solution {
    class UnionFind{
        int[] parent;
        int[] weight;
        int count;
        
        public UnionFind(int size){
            parent = new int[size];
            weight = new int[size];
            count = size;
            for(int i = 0; i < size; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q){
            int findP = find(p);
            int findQ = find(q);
            if(findP == findQ) return;
            if(weight[findP] < weight[findQ]){
                parent[findP] = findQ;
                weight[findQ] += weight[findP];
            }else{
                parent[findQ] = findP;
                weight[findP] += weight[findQ];
            }
            count --;
        }
        
        public int count(){
            return count;
        }
        
    }
    
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] grid = new int[m][n];
        int zeroCount = m * n;
        UnionFind uf = new UnionFind(m * n);
        for(int[] position : positions){
            grid[position[0]][position[1]] = 1;
            zeroCount --;
            for(int i = 0; i < dx.length; i++){
                int nextX = position[0] + dx[i];
                int nextY = position[1] + dy[i];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1){
                    uf.union(position[0] * n + position[1], nextX * n + nextY);
                }
                
            }
            res.add(uf.count() - zeroCount);
        }
        return res;
    }
}