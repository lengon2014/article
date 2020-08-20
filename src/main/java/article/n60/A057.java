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
		int[][] t = ArrayUtils.buildInts("[[1,5],[10,11],[15,2147483647]]");
		int[] newInterval = new int[] { 4, 8 };
		A057 a = new A057();
		System.out.println(ArrayUtils.buildInfo(a.merge(t, newInterval)));
	}

	public int[][] merge(int[][] intervals, int[] newInterval) {

		boolean isAdd = false;
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];

			if (end < newInterval[0]) {
				result.add(intervals[i]);
			}

			if (start > newInterval[0]) {
				//插入一条数据
				if (end > newInterval[0]) {
   
				}
			}
		}

		if (!isAdd) {
			result.add(newInterval);
		}

		return null;
	}
}
