import java.util.Arrays;

class Main
{
	private static final int N = 4;

	// Check if cell (x, y) is valid or not
	private static boolean isValidCell(int x, int y)
	{
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;

		return true;
	}

	private static int countPaths(int maze[][], int x, int y,
								boolean visited[][], int count)
	{
		// if destination (bottom-rightmost cell) is found,
		// increment the path count
		if (x == N - 1 && y == N - 1)
		{
			count++;
			return count;
		}

		// mark current cell as visited
		visited[x][y] = true;

		// if current cell is a valid and open cell
		if (isValidCell(x, y) && maze[x][y] == 1)
		{
			// go down (x, y) --> (x + 1, y)
			if (x + 1 < N && !visited[x + 1][y])
				count = countPaths(maze, x + 1, y, visited, count);

			// go up (x, y) --> (x - 1, y)
			if (x - 1 >= 0 && !visited[x - 1][y])
				count = countPaths(maze, x - 1, y, visited, count);

			// go right (x, y) --> (x, y + 1)
			if (y + 1 < N && !visited[x][y + 1])
				count = countPaths(maze, x, y + 1, visited, count);

			// go left (x, y) --> (x, y - 1)
			if (y - 1 >= 0 && !visited[x][y - 1])
				count = countPaths(maze, x, y - 1, visited, count);
		}

		// backtrack from current cell and remove it from current path
		visited[x][y] = false;

		return count;
	}

	public static void main(String[] args)
	{
		int maze[][] =
		{
			{ 1, 1, 1, 1 },
			{ 1, 1, 0, 1 },
			{ 0, 1, 0, 1 },
			{ 1, 1, 1, 1 }
		};

		// stores number of unique paths from source to destination
		int count = 0;

		// 2D matrix to keep track of cells involved in current path
		boolean[][] visited = new boolean[N][N];

		// start from source cell (0, 0)
		count = countPaths(maze, 0, 0, visited, count);

		System.out.println("Total number of unique paths are " + count);
	}
}