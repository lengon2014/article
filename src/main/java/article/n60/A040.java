package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ] 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A040 {
	public static void main(String args[]) {
		A040 a = new A040();
		List<List<Integer>> result = a.combinationSum2(new int[] { 2,5,2,1,2 }, 0);
		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, target, new ArrayList<>(), 0, result);
		return result;
	}

	public void combinationSum(int[] candidates, int target, List<Integer> list, int count,
			List<List<Integer>> result) {
		List<Integer> clone = cloneList(list);
		List<Integer> valids = getValidCans(candidates, clone);

		Set<Integer> set = new HashSet<>();
		for (int can : valids) {
			if (!set.add(can)) {
				continue;
			}
			// 去重
			if (list.size() > 0) {
				int last = list.get(list.size() - 1);
				if (can < last) {
					continue;
				}
			}

			// 是否是有效的can

			if (count + can == target) {
				List<Integer> ts = cloneList(list);
				ts.add(can);
				result.add(ts);
			}

			if (count + can < target) {
				List<Integer> ts = cloneList(list);
				ts.add(can);
				int total = count + can;
				combinationSum(candidates, target, ts, total, result);
			}
		}
	}

	private List<Integer> getValidCans(int[] candidates, List<Integer> list) {
		List<Integer> values = new ArrayList<>();
		for (int can : candidates) {
			if (list.contains(new Integer(can))) {
				list.remove(new Integer(can));
			} else {
				values.add(can);
			}
		}
		return values;
	}

	public List<Integer> cloneList(List<Integer> list) {
		List<Integer> ins = new ArrayList<>();
		for (Integer l : list) {
			ins.add(l);
		}
		return ins;
	}

}
