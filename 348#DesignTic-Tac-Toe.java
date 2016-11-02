public class TicTacToe {

    class Status{
        int[] row;
        int[] col;
        int diagonal;
        int anti_diagonal;
        int len;
        
        public Status(int n){
            row = new int[n];
            col = new int[n];
            diagonal = 0;
            anti_diagonal = 0;
            len = n;
        }
        
        public boolean update(int i, int j){
            if(grid[i][j] == 1){
                return false;
            }else{
                grid[i][j] = 1;
            }
            if(row[i]++ == len - 1){
                return true;
            }
            if(col[j]++ == len - 1){
                return true;
            }
            if(i == j && diagonal++ == len - 1){
                return true;
            }
            if(i + j == len - 1 && anti_diagonal++ == len - 1){
                return true;
            }
            return false;
        }
    }
    
    private int[][] grid;
    Status Astus;
    Status Bstus;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        grid = new int[n][n];
        Astus = new Status(n);
        Bstus = new Status(n);
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1){
            if(Astus.update(row, col)) return 1;
        }else{
            if(Bstus.update(row, col)) return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */