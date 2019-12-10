package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A047 {


	public static void main(String args[]) {
		A047 a47 = new A047();
		int[] datas = new int[] { 1, 1,4};
		List<List<Integer>> result = a47.permuteUnique(datas);
		for (List<Integer> data : result) {
			System.out.println(data);
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> current = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return null;
		}

		// 初始化第一个
		Set<Integer> addSet = new HashSet<>();
		for (int i : nums) {
			if (addSet.add(i)) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				current.add(list);
			}
		}
		for (int i = 1; i < nums.length; i++) {
			current = addToList(current, nums);
		}
		return current;
	}

	public List<List<Integer>> addToList(List<List<Integer>> list, int[] nums) {
		List<List<Integer>> newLists = new ArrayList<>();
		for (List<Integer> l : list) {
			Set<Integer> addSet = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				if(!addSet.add(nums[i])) {
					continue;
				}
				
				//判断当前的数字是否已经全部用掉。 
				//当前共有几个i
				int numCount = 0;
				int listCount = 0;
				for(int n:nums) {
					if(n==nums[i]) {
						numCount++;
					}
				}
				
				for(Integer n:l) {
					if(n==nums[i]) {
						listCount++;
					}
				}
				if(numCount==listCount) {
					continue;
				}
				
				List<Integer> news = new ArrayList<>();
				for (Integer k : l) {
					news.add(k);
				}
				news.add(nums[i]);
				newLists.add(news);
			}
		}
		return newLists;
	}

}
