package article.n60;

import article.ArrayUtils;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A059 {

	public static void main(String args[]) {
		A059 a = new A059();
		System.out.println(ArrayUtils.buildInfo(a.generateMatrix(50)));

	}

	public int[][] generateMatrix(int n) {
		if (n <= 0) {
			return null;
		}

		int[][] result = new int[n][n];

		int status = 1;
		int x = -1;
		int y = 0;
		int value = 1;
		while (true) {
			if(value==n*n+1) {
				break;
			}
			// 向左
			if (status == 1) {
				if (x + 1 >= n) {
					status = 2;
					continue;
				}

				if (result[y][x + 1] == 0) {
					result[y][x + 1] = value;
					value++;
					x++;
					continue;
				} else {
					status = 2;
				}
			}

			// 向下
			if (status == 2) {
				if (y + 1 >= n) {
					status = 3;
					continue;
				}

				if (result[y + 1][x] == 0) {
					result[y + 1][x] = value;
					value++;
					y++;
					continue;
				} else {
					status = 3;
				}
			}

			if (status == 3) {
				if (x - 1 < 0) {
					status = 4;
					continue;
				}

				if (result[y][x - 1] == 0) {
					result[y][x - 1] = value;
					value++;
					x--;
					continue;
				} else {
					status = 4;
				}
			}

			if (status == 4) {
				if (y - 1 < 0) {
					status = 1;
					continue;
				}

				if (result[y - 1][x] == 0) {
					result[y - 1][x] = value;
					y--;
					value++;
					continue;
				} else {
					status = 1;
				}
			}
		}
		return result;
	}
}
