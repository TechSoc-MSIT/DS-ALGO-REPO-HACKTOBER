class Main
{
	// M x N matrix
	private static final int M = 10;
	private static final int N = 10;

	// check if it is possible to go to position (x, y) from
	// current position. The function returns false if the cell
	// has value 0 or it is already visited.
	private static boolean isSafe(int mat[][], int visited[][], int x, int y)
	{
		if (mat[x][y] == 0 || visited[x][y] != 0)
			return false;

		return true;
	}

	// if not a valid position, return false
	private static boolean isValid(int x, int y)
	{
		if (x < M && y < N && x >= 0 && y >= 0)
			return true;

		return false;
	}

	// Find Longest Possible Route in a Matrix mat from source
	// cell (0, 0) to destination cell (x, y)
	// 'max_dist' stores length of longest path from source to
	// destination found so far and 'dist' maintains length of path from
	// source cell to the current cell (i, j)
	public static int findLongestPath(int mat[][], int visited[][], int i,
								int j, int x, int y, int max_dist, int dist)
	{
		// if destination not possible from current cell
		if (mat[i][j] == 0) {
			return 0;
		}

		// if destination is found, update max_dist
		if (i == x && j == y)
		{
			return Integer.max(dist, max_dist);
		}

		// set (i, j) cell as visited
		visited[i][j] = 1;

		// go to bottom cell
		if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
			max_dist = findLongestPath(mat, visited, i + 1, j, x, y,
										max_dist, dist + 1);
		}

		// go to right cell
		if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
			max_dist = findLongestPath(mat, visited, i, j + 1, x, y,
										max_dist, dist + 1);
		}

		// go to top cell
		if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
			max_dist = findLongestPath(mat, visited, i - 1, j, x, y,
										max_dist, dist + 1);
		}

		// go to left cell
		if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
			max_dist = findLongestPath(mat, visited, i, j - 1, x, y,
										max_dist, dist + 1);
		}

		// Backtrack - Remove (i, j) from visited matrix
		visited[i][j] = 0;

		return max_dist;
	}

	public static void main(String[] args)
	{
		// input matrix
		int mat[][] =
		{
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
		};

		// construct a matrix to keep track of visited cells
		int[][] visited= new int[N][N];

		// (0,0) are the source cell coordinates and (5, 7) are the
		// destination cell coordinates
		int max_dist = findLongestPath(mat, visited, 0, 0, 5, 7, 0, 0);

		System.out.println("Maximum length path is " + max_dist);
	}
}