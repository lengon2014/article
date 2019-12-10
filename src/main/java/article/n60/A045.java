package article.n60;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。   从下标为 0 跳到下标为 1
 * 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A045 {

	public static void main(String args[]) {
		A045 a = new A045();
		int[] list = new int[] {5,5,1,1,1,4,1,1,1,0};
		System.out.print(a.jump(list));
	}

	public int jump(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		// 先将所有数据进行map处理
		Map<Integer, Set<Integer>> tos = new HashMap<>();
		Map<Integer, Integer> steps = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			tos.put(i, new HashSet<>());
		}
		steps.put(0, 0);
		for (int i = 0; i < nums.length; i++) {
			int now = nums[i];
			int step = steps.get(i);
			if (now == 0) {
				continue;
			}
			for (int j = 1; j <= now; j++) {
				int key = i + j;
				if (null != tos.get(key)) {
					tos.get(key).add(i);
				}
				// 如果当前的步数少于
				if (null == steps.get(key) || steps.get(key) > step + 1) {
					steps.put(key, step + 1);
				}

				// 说明当前是需要走至少超过2步， 那么需要忽略当前的值
				if (key < nums.length) {
					if (nums[key] + key <= now + i) {
						nums[key] = 0;
					}
				}
			}
		}
		return steps.get(nums.length - 1);
	}
}
