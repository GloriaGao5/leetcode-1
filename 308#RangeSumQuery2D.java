public class NumMatrix {
    
    int[][] tree;
    int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            matrix = new int[1][0];
        }
        this.tree = new int[matrix.length + 1][matrix[0].length + 1];
        this.matrix = new int[matrix.length][matrix[0].length];
        constructTree(matrix);
    }
    
    public void constructTree(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        for(int i = row+1; i < tree.length; i += (i & (-i))){
            for(int j = col+1; j < tree[0].length; j += (j & (-j))){
                tree[i][j] += diff;
            }
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
    }
    
    public int sum(int row, int col){
        int res = 0;
        for(int i = row+1; i > 0; i -= (i & (-i))){
            for(int j = col+1; j > 0; j -= (j & (-j))){
                res += tree[i][j];
            }
        }
        return res;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);