public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] I = new int[m], J = new int[n];
        for (int i=0; i<m; ++i)
            for (int j=0; j<n; ++j)
                if (grid[i][j] == 1) {
                    ++I[i];
                    ++J[j];
                }
        int total = 0;
        for (int[] K : new int[][]{ I, J }) {
            int i = 0, j = K.length - 1;
            while (i < j) {
                int k = Math.min(K[i], K[j]);
                total += k * (j - i);
                if ((K[i] -= k) == 0) ++i;
                if ((K[j] -= k) == 0) --j;
            }
        }
        return total;
    }
}