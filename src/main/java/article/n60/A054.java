package article.n60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A054 {

	public static void main(String args[]) {
		A054 a = new A054();
		System.out.println(a.spiralOrder(new int[][] {}));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix.length==0) {
			return result;
		}
		int nowX = 0;
		int nowY = 0;
		int xSize = matrix[0].length;
		int ySize = matrix.length;

		
		while (true) {
			for (int i = nowX; i < xSize - nowX; i++) {
				result.add(matrix[nowY][i]);
			}

			for (int i = nowY + 1; i < ySize - nowY; i++) {
				result.add(matrix[i][xSize - 1 - nowX]);
			}

			if (ySize - nowY - 1 != nowY) {
				for (int i = xSize - 2 - nowX; i >= nowX; i--) {
					result.add(matrix[ySize - nowY - 1][i]);
				}
			}

			if (xSize - nowX - 1 != nowX) {
				for (int i = ySize - nowY - 2; i > nowY; i--) {
					result.add(matrix[i][nowX]);
				}
			}

			if (result.size() == xSize * ySize) {
				break;
			}
			nowX++;
			nowY++;
		}
		return result;
	}
}
