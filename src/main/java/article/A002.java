package article;

public class A002 {

	public static void main(String args[]) {
		A002Node node1 = buildNodes(1, 8);
		A002Node node2 = buildNodes(0);
		System.out.println(buildInfo(build(node1, node2)));
	}

	public static A002Node buildNodes(int... inputs) {
		A002Node first = null;
		A002Node pre = null;
		for (int input : inputs) {
			if (first == null) {
				first = new A002Node(input);
				pre = first;
			} else {
				A002Node now = new A002Node(input);
				pre.setNext(now);
				pre = now;
			}
		}
		return first;
	}

	public static String buildInfo(A002Node node) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append(node.getValue());
			if (node.next == null) {
				return sb.toString();
			} else {
				node = node.next;
				sb.append(" -> ");
			}
		}
	}

	public static A002Node build(A002Node node1, A002Node node2) {
		// 进位
		int tenNumber = 0;
		A002Node first = null;
		A002Node pre = null;
		while (true) {
			int node1Value = 0;
			int node2Value = 0;
			if (node1 != null) {
				node1Value = node1.getValue();
			}

			if (node2 != null) {
				node2Value = node2.getValue();
			}

			int sum = node1Value + node2Value + tenNumber;

			if (sum >= 10) {
				tenNumber = 1;
				sum = sum - 10;
			} else {
				tenNumber = 0;
			}

			A002Node node = new A002Node(sum);
			if (pre == null) {
				first = node;
			} else {
				pre.setNext(node);
			}
			pre = node;
			if (node1 != null) {
				node1 = node1.getNext();
			}
			if (node2 != null) {
				node2 = node2.getNext();
			}
			if (node1 == null && node2 == null) {
				if (tenNumber > 0) {
					A002Node last = new A002Node(tenNumber);
					pre.setNext(last);
				}

				return first;
			}
		}
	}
}
