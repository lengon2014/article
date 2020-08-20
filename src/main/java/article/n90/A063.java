package article.n90;

import article.ArrayUtils;

public class A063 {

	public static void main(String args[]) {
		int[][] inputs = ArrayUtils.buildInts("[[0,0,0],[0,0,0],[0,0,1]]");
		A063 a = new A063();
		System.out.println(a.uniquePathsWithObstacles(inputs));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;

		// 累计数量
		int[][] counts = new int[n][m];
		// 新增起点
		int start = 1;
		// 都是按照2的倍数来的行走的
		while (true) {
			// 找到所有的和为start的情况
			for (int i = 1; i <= start; i++) {
				int j = start + 1 - i;
				// 超过路径的不计算
				if (i > n) {
					continue;
				}

				if (j > m || j < 1) {
					continue;
				}

				if (obstacleGrid[i - 1][j - 1] == 1) {
					counts[i - 1][j - 1] = 0;
					continue;
				}
				// 2条路的情况
				if (i <= n && j <= m) {
					if (i == 1 && j == 1) {
						counts[i - 1][j - 1] = 1;
						continue;
					}
					// 从其上方和左边进行
					if (i == 1) {
						counts[i - 1][j - 1] = counts[i - 1][j - 2];
						continue;
					}

					if (j == 1) {
						counts[i - 1][j - 1] = counts[i - 2][j - 1];
						continue;
					}
					counts[i - 1][j - 1] = counts[i - 2][j - 1] + counts[i - 1][j - 2];
				}
			}
			if (start >= m + n) {
				return counts[n - 1][m - 1];
			}
			start++;
		}

	}
}
