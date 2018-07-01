package test;

public class MazeRunner {

	public static void main(String[] args) {
		int[][] maze = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println("");
		}
	}

}
