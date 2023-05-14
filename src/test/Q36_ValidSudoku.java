package test;

import java.util.*;;

public class Q36_ValidSudoku {
    //Big O = 9*9  Space also 9*9 as we need to store all element in the set
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                // Iterator itr = seen.iterator();

                // // check element is present or not. if not loop will
                // // break.
                // while (itr.hasNext()) {
                // System.out.println(itr.next());
                // }

                if (board[i][j] == '.')
                    continue;
                final char c = board[i][j];
                if (!seen.add(c + "@row" + i) || //
                        !seen.add(c + "@col" + j) || //
                        !seen.add(c + "@box" + i / 3 + j / 3))
                    return false;
            }

        return true;
    }

    public boolean isValidSudokuWithoutSet(char[][] board) {
        char gs = '.', target;
        int m = 0;

        while (m < 9) {
            int n = 0;
            while (n < 9) {
                if (board[m][n] != gs) {
                    target = board[m][n];

                    // for row
                    for (int j = 0; j < 9; j++) {
                        if (j == n) {
                            continue;
                        }
                        if (board[m][j] == target) {
                            return false;
                        }
                    }
                    // for col
                    for (int i = 0; i < 9; i++) {
                        if (i == m) {
                            continue;
                        }
                        if (board[i][n] == target) {
                            return false;
                        }
                    }
                    // for sub-box
                    int subBoxRowStart = (m / 3) * 3;
                    int subBoxColStart = (n / 3) * 3;
                    for (int i = subBoxRowStart; i < subBoxRowStart + 3; i++) {
                        for (int j = subBoxColStart; j < subBoxColStart + 3; j++) {
                            if (i == m || j == n)
                                continue;
                            if (board[i][j] == target)
                                return false;
                        }
                    }
                }
                n++;
            }
            m++;
        }
        return true;
    }

    public static void main(String[] args) {
        Q36_ValidSudoku c = new Q36_ValidSudoku();

        char[][] input = {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }
        };

        System.out.println(c.isValidSudoku(input));
    }
}
