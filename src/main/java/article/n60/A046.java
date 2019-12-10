package article.n60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * @author lengon
 *
 */
public class A046 {

	public static void main(String args[]) {
		A046 a46 = new A046();
		int[] datas = new int[] { 1, 4 };
		List<List<Integer>> result = a46.permute(datas);
		for (List<Integer> data : result) {
			System.out.println(data);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> current = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return null;
		}

		// 初始化第一个
		for (int i : nums) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			current.add(list);
		}
		for (int i = 1; i < nums.length; i++) {
			current = addToList(current, nums);
		}
		return current;
	}

	public List<List<Integer>> addToList(List<List<Integer>> list, int[] nums) {
		List<List<Integer>> newLists = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (List<Integer> l : list) {
				if (l.contains(nums[i])) {
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
