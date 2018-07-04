package test;

/* Java program to solve Rat in a Maze problem using
backtracking */

public class RatMaze {

	private final int TRIED = 3;
	private final int PATH = 7;

	private int[][] grid = { { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public String toString() {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++)
				result += grid[row][col] + "";
			result += "\n";
		}
		return result;
	}

	private boolean valid(int row, int col) {
		boolean result = false;
		int rl = grid.length - 1;
		int cl = grid[0].length - 1;
		// check if cell is in the bounds of the matrix
		if (col < 0 || row < 0 || row > rl || col > cl) {
			return false;
		}

		// check if cell is not blocked and not previously tried
		if (grid[row][col] == 1)
			result = true;
		return result;
	}

	public boolean traverse(int row, int col) {
		boolean done = false;
		if (valid(row, col)) {
			grid[row][col] = TRIED;
			if (row == grid.length - 1 && col == grid[0].length - 1)
				done = true; // the maze is solved
			else {
				done = traverse(row + 1, col); // down
				if (!done)
					done = traverse(row, col + 1); // right
				if (!done)
					done = traverse(row - 1, col); // up
				if (!done)
					done = traverse(row, col - 1); // left
			}
			if (done) // this location is part of the final path
				grid[row][col] = PATH;
		}
		return done;
	}

	public static void main(String args[]) {
		RatMaze rat = new RatMaze();
		rat.traverse(0, 0);
		System.out.println(rat.toString());
	}
}
// This code is contributed by Abhishek Shankhadhar
