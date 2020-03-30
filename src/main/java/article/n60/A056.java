package article.n60;

import java.util.ArrayList;
import java.util.List;

import article.ArrayUtils;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和
 * [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 * 
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A056 {

	public static void main(String args[]) {
		int[][] t = ArrayUtils.buildInts("[[5,7],[4,6]]");
		A056 a = new A056();
		System.out.println(ArrayUtils.buildInfo(a.merge(t)));
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[][] {};
		}

		Integer max = null;
		Integer min = null;

		for (int i = 0; i < intervals.length; i++) {
			int[] value = intervals[i];
			if (max == null || value[1] > max) {
				max = value[1];
			}

			if (min == null || value[0] < min) {
				min = value[0];
			}
		}

		int[] datas = new int[max - min + 1];
		for (int i = 0; i < intervals.length; i++) {
			int[] value = intervals[i];

			// 判断之前和之后是否有重合的地方
			int start = value[0] + 1;

			// 之前已经有数字了
			if (datas[value[0] - min] != 0) {
				start = datas[value[0] - min];
			}

			// 之后的设置
			if (datas[value[1]-min] != 0) {
				for (int m = value[1] + 1 - min; m < datas.length; m++) {
					if (datas[m] == datas[value[1] - min]) {
						datas[m] = start;
					}
				}
			}

			for (int j = value[0]; j <= value[1]; j++) {
				datas[j - min] = start;
			}

		}

		List<int[]> result = new ArrayList<>();
		List<Integer> now = new ArrayList<>();
		Integer preValue = null;
		for (int i = min; i <= max; i++) {
			if (now.isEmpty() && datas[i - min] != 0) {
				preValue = datas[i - min];
				now.add(i);
				now.add(i);
				continue;
			}

			if (!now.isEmpty() && datas[i - min] == preValue) {
				if (now.size() == 1) {
					now.add(i);
				} else {
					now.set(1, i);
				}
				continue;
			}

			if (!now.isEmpty() && datas[i - min] != preValue) {
				result.add(new int[] { now.get(0), now.get(1) });
				now = new ArrayList<>();
				if (datas[i - min] != 0) {
					now.add(i);
					now.add(i);
					preValue = datas[i - min];
				}
			}
		}

		if (!now.isEmpty()) {
			result.add(new int[] { now.get(0), now.get(1) });
		}

		int[][] resultInts = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			int[] t = result.get(i);
			resultInts[i] = t;
		}

		return resultInts;
	}
}
