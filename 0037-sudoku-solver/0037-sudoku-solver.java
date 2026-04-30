class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')continue;

                int num = board[i][j] - '0';
                int boxInd = (i / 3) * 3 + (j / 3);

                row[i][num] = true;
                col[j][num] = true;
                box[boxInd][num] = true;
            }
        }
        solveOptimally(board, row, col, box);
    }

    public static boolean solveOptimally(char[][] board,boolean[][] row,boolean[][] col,boolean[][] box){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c<='9';c++){
                        int num = c - '0';
                        int b = (i / 3) * 3 + (j / 3);
                        if(row[i][num] || col[j][num] || box[b][num])continue;

                        board[i][j] = c;
                        row[i][num] = true;
                        col[j][num] = true;
                        box[b][num] = true;
                        if(solveOptimally(board, row, col, box))return true;
                        board[i][j] = '.';
                        row[i][num] = false;
                        col[j][num] = false;
                        box[b][num] = false;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    
}