package test;

public class Q37_SudokuResolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int s) {
        if (s == 81)
            return true;

        final int i = s / 9;
        final int j = s % 9;

        if (board[i][j] != '.')
            return dfs(board, s + 1);

        for (char c = '1'; c <= '9'; ++c)
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (dfs(board, s + 1))
                    return true;
                board[i][j] = '.';
            }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            int br = (3 * (row / 3)) + i / 3;
            int bc = (3 * (col / 3)) + i % 3;
            if (board[i][col] == c || board[row][i] == c ||
                    board[br][bc] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q37_SudokuResolver c = new Q37_SudokuResolver();

        char[][] input = {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '8', '.', '.', '6' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }
        };

        c.solveSudoku(input);
        System.out.println(input);

    }
}
