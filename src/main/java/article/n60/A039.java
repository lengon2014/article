package article.n60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ] 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8, 所求解集为: [   [2,2,2,2],   [2,3,3],  
 * [3,5] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A039 {
	public static void main(String args[]) {
		A039 a = new A039();
		List<List<Integer>> result = a.combinationSum(new int[] { 2, 3, 5,4 }, 1);
		for (List<Integer> r : result) {
			for (Integer i : r) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, target, new ArrayList<>(), 0, result);
		return result;
	}

	public void combinationSum(int[] candidates, int target, List<Integer> list, int count,
			List<List<Integer>> result) {
		for (int can : candidates) {

			//去重
			if (list.size() > 0) {
				int last = list.get(list.size() - 1);
				if (can < last) {
					continue;
				}
			}
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

	public List<Integer> cloneList(List<Integer> list) {
		List<Integer> ins = new ArrayList<>();
		for (Integer l : list) {
			ins.add(l);
		}
		return ins;
	}

}
