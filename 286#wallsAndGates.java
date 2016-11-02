public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        
        if(rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(i*n+j);
                }
            }
        }
        while(!queue.isEmpty()){
            int curIdx = queue.poll();
            int row = curIdx / n;
            int col = curIdx % n;
            for(int i = 0; i < dx.length; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && rooms[nextRow][nextCol] == Integer.MAX_VALUE){
                    rooms[nextRow][nextCol] = rooms[row][col] + 1;
                    queue.offer(nextRow*n+nextCol);
                }
            }
        }
        return;
    }
}