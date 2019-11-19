package article.n60;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author lengon
 *
 */
public class A036 {

	public static void main(String args[]) {
		char[][] cs = new char[][] {
				new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '1', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '2', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '2', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(isValidSudoku(cs));

	}

	public static boolean isValidSudoku(char[][] board) {
		// 从左到右的判定
		for (int y = 0; y < board.length; y++) {
			Set<Character> cs = new HashSet<>();
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] != '.') {
					if (!cs.add(board[y][x])) {
						return false;
					}
				}
			}
		}

		for (int x = 0; x < board.length; x++) {
			Set<Character> cs = new HashSet<>();
			for (int y = 0; y < board.length; y++) {
				if (board[y][x] != '.') {
					if (!cs.add(board[y][x])) {
						return false;
					}
				}
			}
		}

		for (int y = 0; y < board.length; y += 3) {
			for (int x = 0; x < board.length; x += 3) {
				int startX = x;
				int endX = (x + 3);
				int startY = y;
				int endY = (y + 3);
				Set<Character> cs = new HashSet<>();
				for (int i = startX; i < endX; i++) {
					for (int j = startY; j < endY; j++) {
						if (board[i][j] != '.') {
							if (!cs.add(board[i][j])) {
								return false;
							}
						}
					}
				}

			}
		}
		return true;
	}

	private Node getSmallestBoard(Node[][] nodes) {
		Node small = null;
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (null != nodes[i][j]) {
					if (nodes[i][j].cs.size() == 1) {
						return nodes[i][j];
					}

					if (null == small) {

					}
				}
			}
		}
		return null;
	}

	// 先设置所有的可能的情况
	private void setValids(char[][] board, Node[][] nodes) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					Set<Character> chars = getValidChars(board, i, j);
					Node node = new Node();
					node.cs = chars;
					node.isFresh = false;
					nodes[i][j] = node;
				}
			}
		}
	}

	private Set<Character> getValidChars(char[][] board, int x, int y) {
		// 从左到右的判定
		Set<Character> valid = buildFullChars();
		char[] cs = board[y];
		for (char c : cs) {
			if (c != '.') {
				valid.remove(c);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][x] != 'c') {
				valid.remove(board[i][x]);
			}
		}

		int startX = x / 3;
		int endX = (x + 3) / 3;
		int startY = y / 3;
		int endY = (y + 3) / 3;

		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if (board[i][j] != 'c') {
					valid.remove(board[i][j]);
				}
			}
		}
		return valid;
	}

	/**
	 * 刷新确定的值
	 * 
	 * @param board
	 * @param x
	 * @param y
	 */
	private void refresh(char[][] board, int x, int y, Node[][] nodes) {
		char target = board[x][y];
		Node[] nds = nodes[y];
		for (Node node : nds) {
			node.cs.remove(target);
		}

		for (int i = 0; i < nodes.length; i++) {
			nodes[i][x].cs.remove(target);
		}

		int startX = x / 3;
		int endX = (x + 3) / 3;
		int startY = y / 3;
		int endY = (y + 3) / 3;

		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				nodes[i][j].cs.remove(target);
			}
		}
		nodes[x][y].isFresh = true;
	}

	private Set<Character> buildFullChars() {
		char[] cs = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Set<Character> set = new HashSet<>();
		for (char c : cs) {
			set.add(c);
		}
		return set;
	}

	class Node {
		boolean isFresh = false;
		Set<Character> cs = new HashSet<>();
	}
}
