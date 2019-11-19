package article.n60;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A042 {
	public static void main(String args[]) {
		A042 a = new A042();
		System.out.println(a.trap(new int[] { 7, 1,5 }));

	}

	public int trap(int[] height) {
		int total = 0;
		for (int i = 0; i < height.length; i++) {
			int right = getRight(height, i, height[i], 0);
			if (right != -1) {
				int min = Math.min(height[i], height[right]);
				for (int j = i + 1; j < right; j++) {
					total += min - height[j];
				}
				i = right - 1;
			}

		}
		return total;
	}

	// 找到一个比右边更高的山峰
	public int getRight(int[] height, int start, int left, int beforeRight) {
		int max = -1;
		int index = -1;
		for (int i = start + 1; i < height.length; i++) {
			if (height[i] > left) {
				return i;
			}

			if (height[i] == left) {
				if (height[i] != beforeRight) {
					return i;
				}
			}

			if (max == -1 || height[i] > max) {
				max = height[i];
				index = i;
			}
		}
		return index;
	}
}
