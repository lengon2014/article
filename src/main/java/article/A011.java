package article;

/**
 * 11. Container With Most Water Medium
 * 
 * 2839
 * 
 * 409
 * 
 * Favorite
 * 
 * Share Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author lengon
 *
 */
public class A011 {
	public static void main(String args[]) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public static int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int min = Math.min(height[i], height[j]);
				int size = min * (j - i);
				if (size > max) {
					max = size;
				}
			}
		}

		return max;
	}
}
