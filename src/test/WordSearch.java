package test;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				boolean result = isSafe(board, visited, word, i, j);

				if (result) {
					return result;
				}
			}
		}
		return false;
	}

	public boolean isSafe(char[][] board, boolean[][] visited, String word, int i, int j) {

		if (word.isEmpty()) {
			return true;
		}

		if (safe(board, i, j) && !visited[i][j] && board[i][j] == word.charAt(0)) {
			String sub = word.substring(1);
			visited[i][j] = true;
			boolean result = isSafe(board, visited, sub, i, j + 1) || isSafe(board, visited, sub, i + 1, j)
					|| isSafe(board, visited, sub, i - 1, j) || isSafe(board, visited, sub, i, j - 1);

			visited[i][j] = false;

			return result;
		}

		return false;
	}

	public boolean safe(char[][] board, int i, int j) {

		if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
