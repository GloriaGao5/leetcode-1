public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return null;
        int m = A.length, n = A[0].length, e = B.length, l = B[0].length;
        if(n != e) return null;
        int[][] C = new int[m][l];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] != 0){
                    for(int k = 0; k < l; k++){
                        C[i][k] += A[i][j] * B[j][k];
                    }
                 }
            }
        }
        return C;
    }
}