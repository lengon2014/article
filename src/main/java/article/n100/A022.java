package article.n100;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lengon
 *
 */
public class A022 {

	public static void main(String args[]) {
		A022 a = new A022();
		System.out.println(a.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		
		if(n<=0) {
			return new ArrayList<>();
		}
		List<Node> result = new ArrayList<>();
		for (int i = 0; i < 2 * n; i++) {
			List<Node> news = new ArrayList<>();
			if (result.isEmpty()) {
				if (0 < n) {
					news.add(new Node("(", 1, 0));
				}

				/*
				 * if (0 < n) { news.add(new Node(")", 0, 1)); }
				 */
				result = news;
			} else {
				for (Node r : result) {
					if (r.count1 < n) {
						int count1 = r.count1 + 1;
						news.add(new Node(r.value + "(", count1, r.count2));
					}

					if (r.count1 > r.count2 && r.count2 < n) {
						int count2 = r.count2 + 1;
						news.add(new Node(r.value + ")", r.count1, count2));
					}
				}
				result = news;
			}
		}

		List<String> strs = new ArrayList<>();
		for (Node node : result) {
			String value = node.getValue();
			strs.add(value);
		}

		return strs;
	}

	public class Node {
		String value;
		int count1;
		int count2;

		public Node(String value, int count1, int count2) {
			this.value = value;
			this.count1 = count1;
			this.count2 = count2;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getCount1() {
			return count1;
		}

		public void setCount1(int count1) {
			this.count1 = count1;
		}

		public int getCount2() {
			return count2;
		}

		public void setCount2(int count2) {
			this.count2 = count2;
		}

		@Override
		public String toString() {
			return value;
		}

	}
}
