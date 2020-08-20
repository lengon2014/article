package article.n90;

import article.ArrayUtils;

public class A064 {

	public static void main(String args[]) {
		int[][] t = ArrayUtils.buildInts("[[1,5],[10,11]]");
		A064 a = new A064();
		System.out.print(a.minPathSum(t));
	}

	public int minPathSum(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}

		if (grid[0].length == 0) {
			return 0;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0 && i > 0) {
					grid[i][j] = grid[i - 1][j] + grid[i][j];
				}

				if (i == 0 && j > 0) {
					grid[i][j] = grid[i][j - 1] + grid[i][j];
				}

				if (i > 0 && j > 0) {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
				}

			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

}
