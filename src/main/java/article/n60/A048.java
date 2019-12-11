package article.n60;

import article.ArrayUtils;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A048 {

	public static void main(String args[]) {
		A048 a048 = new A048();

		int[][] value = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		a048.rotate(value);
		System.out.println(ArrayUtils.buildInfo(value));
	}

	public void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int circle = 0; circle < length / 2; circle++) {
			for (int i = circle; i < length - circle - 1; i++) {
				// 4个数字进行swap
				int start = matrix[circle][i];
				int end = matrix[i][length - 1 - circle];
				int nextEnd = matrix[length - 1 - circle][length - 1 - i];
				int nextStart = matrix[length - 1 - i][circle];

				// 进行逐一替换
				matrix[circle][i] = nextStart;
				matrix[i][length - 1 - circle] = start;
				matrix[length - 1 - circle][length - 1 - i] = end;
				matrix[length - 1 - i][circle] = nextEnd;
			}
		}
	}
}
