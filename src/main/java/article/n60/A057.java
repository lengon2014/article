package article.n60;

import java.util.ArrayList;
import java.util.List;

import article.ArrayUtils;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5] 输出: [[1,5],[6,9]] 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] 输出:
 * [[1,2],[3,10],[12,16]] 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A057 {

	public static void main(String args[]) {
		int[][] t = ArrayUtils.buildInts("[[0,2],[3,3],[6,11]]");
		int[] newInterval = new int[] { 9, 15 };
		A057 a = new A057();
		System.out.println(ArrayUtils.buildInfo(a.merge(t, newInterval)));
	}

	public int[][] merge(int[][] intervals, int[] newInterval) {
		// 判断是否有交集。 如果有， 那么进行计算并集
		List<int[]> values = new ArrayList<>();

		// 没有值的情况
		if (intervals.length == 0) {
			values.add(newInterval);
		}

		for (int i = 0; i < intervals.length; i++) {
			int[] start = intervals[i];

			// 如果当前的值是在当前的2个数组的中间。 那么直接累计
			if (null != newInterval && ((i == 0 && newInterval[1] < intervals[0][0])
					|| (i > 0 && newInterval[0] > intervals[i - 1][1] && newInterval[1] < start[0]))) {
				values.add(newInterval);
				newInterval = null;
			}

			if (null == newInterval) {
				values.add(start);
				continue;
			}

			// 包含关系
			if (start[0] < newInterval[0] && start[1] > newInterval[1]) {
				values.add(start);
				// 变换为新的交界
				newInterval = start;
				continue;
			}

			if (newInterval[0] < start[0] && newInterval[1] > start[1]) {
				// 如果是最后一个值。 那么需要
				if (i == intervals.length - 1) {
					values.add(newInterval);
					newInterval = null;
				}
				continue;
			}

			// 没有交集的关系
			if (start[1] < newInterval[0] || newInterval[1] < start[0]) {
				// 如果在两个数组中间
				if (values.size() > 0) {
					// 右边相交
					int[] preone = values.get(values.size() - 1);
					if (preone[1] < newInterval[0] && newInterval[1] < start[0]) {
						values.add(newInterval);
						newInterval = null;
					}
				} else {
					if (newInterval[1] < start[0]) {
						values.add(newInterval);
						newInterval = null;
					}
				}
				values.add(start);
				// 忽略
				continue;
			}

			// 交集关系
			int[] v = new int[] { Math.min(start[0], newInterval[0]), Math.max(start[1], newInterval[1]) };

			// 如果和后面的也有交集， 那么需要抛弃
			newInterval = v;
		}

		// 如果是在最后一个值
		if (intervals.length > 0 && null != newInterval
				&& (values.isEmpty() || newInterval[0] > values.get(values.size() - 1)[1])) {
			values.add(newInterval);
		}

		int[][] result = new int[values.size()][2];
		for (int i = 0; i < values.size(); i++) {
			result[i] = values.get(i);
		}
		return result;
	}
}
