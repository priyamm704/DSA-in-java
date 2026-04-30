class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n-1];
        boolean[] upperDiagonal = new boolean[2 * n-1];

        helper(0, board, leftRow, lowerDiagonal, upperDiagonal, n, res);
        return res;
    }

    public static void helper(int col, char[][] board, boolean[] leftRow, boolean[] lowerDiagonal,
    boolean[] upperDiagonal, int n,List<List<String>> res){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int row=0; row < n; row++){
            if(leftRow[row] || lowerDiagonal[row+col] || upperDiagonal[(n-1) + (col-row)])continue;

            board[row][col] = 'Q';
            leftRow[row] = true;
            lowerDiagonal[row+col] = true;
            upperDiagonal[(n-1) + (col-row)] = true;

            helper(col+1, board, leftRow, lowerDiagonal, upperDiagonal, n, res);

            board[row][col] = '.';
            leftRow[row] = false;
            lowerDiagonal[row+col] = false;
            upperDiagonal[(n-1) + (col-row)] = false;
        }
    }
}