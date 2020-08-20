package article.n90;

/**
 * 62. 不同路径 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？ 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2 输出: 3 解释: 从左上角开始，总共有 3 条路径可以到达右下角。 1. 向右 -> 向右 -> 向下 2. 向右
 * -> 向下 -> 向右 3. 向下 -> 向右 -> 向右 示例 2:
 * 
 * 输入: m = 7, n = 3 输出: 28  
 * 
 * 提示：
 * 
 * 1 <= m, n <= 100 题目数据保证答案小于等于 2 * 10 ^ 9
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A062 {

	public static void main(String[] args) {
		A062 a = new A062();
		System.out.println(a.uniquePaths(1, 100));
	}

	public int uniquePaths(int m, int n) {
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
