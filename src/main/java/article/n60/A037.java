package article.n60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A037 {

	public static void main(String args[]) {
		String input = ".,.,9,7,4,8,.,.,.],[7,.,.,.,.,.,.,.,.],[.,2,.,1,.,9,.,.,.],[.,.,7,.,.,.,2,4,.],[.,6,4,.,1,.,5,9,.],[.,9,8,.,.,.,3,.,.],[.,.,.,8,.,3,.,2,.],[.,.,.,.,.,.,.,.,6],[.,.,.,2,7,5,9,.,.";
		char[][] board = new char[9][9];
		String[] lines = input.split("\\],\\[");
		for (int i = 0; i < 9; i++) {
			String line = lines[i];
			String[] nums = line.split(",");
			for (int j = 0; j < nums.length; j++) {
				board[i][j] = nums[j].charAt(0);
			}
		}
		A037 a = new A037();
		a.solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " , ");
			}
			System.out.println();
		}

	}

	public void solveSudoku(char[][] board) {
		Node[][] nodes = new Node[board.length][board.length];
		setValids(board, nodes);
		char[][] results = solveSudoku(board, nodes);

		// 对应的进行赋值
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = results[i][j];
			}
		}

	}

	public char[][] solveSudoku(char[][] board, Node[][] nodes) {
		while (true) {
			Node node = getSmallestBoard(nodes);
			if (null == node) {
				if (isValidSudoku(board)) {
					return board;
				}
				return null;
			}

			// 将其进行分割为N个棋盘
			if (node.cs.size() > 1) {
				for (int i = 0; i < node.cs.size(); i++) {
					char[][] cloneBoard = cloneBoard(board);
					Node[][] cloneNodes = cloneNode(nodes);
					char c = node.cs.get(i);
					cloneBoard[node.y][node.x] = c;
					Node nowNode = new Node();
					List<Character> cs = new ArrayList<>();
					cs.add(c);
					nowNode.cs = cs;
					nowNode.isFresh = false;
					nowNode.x = node.x;
					nowNode.y = node.y;
					cloneNodes[node.y][node.x] = nowNode;
					char[][] result = solveSudoku(cloneBoard, cloneNodes);
					if (null != result) {
						return result;
					}
				}
				return null;
			} else {
				board[node.y][node.x] = node.cs.get(0);
				refresh(board, node.x, node.y, nodes);
				nodes[node.y][node.x] = null;
			}
		}
	}

	private char[][] cloneBoard(char[][] board) {
		char[][] clones = new char[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				clones[i][j] = board[i][j];
			}
		}
		return clones;
	}

	private Node[][] cloneNode(Node[][] nodes) {
		Node[][] cloneNodes = new Node[nodes.length][nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (nodes[i][j] != null) {
					Node node = new Node();
					node.cs = new ArrayList<>();
					for (Character c : nodes[i][j].cs) {
						node.cs.add(c);
					}
					node.isFresh = nodes[i][j].isFresh;
					node.x = nodes[i][j].x;
					node.y = nodes[i][j].y;
					cloneNodes[i][j] = node;
				}
			}
		}
		return cloneNodes;
	}

	private Node getSmallestBoard(Node[][] nodes) {
		Node small = null;
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (null != nodes[i][j]) {
					if (nodes[i][j].cs.size() == 1) {
						return nodes[i][j];
					}

					// 如果不存在解答
					if (nodes[i][j].cs.size() == 0) {
						return null;
					}

					if (nodes[i][j].cs.size() > 0 && (null == small || nodes[i][j].cs.size() < small.cs.size())) {
						small = nodes[i][j];
					}
				}
			}
		}
		return small;
	}

	// 先设置所有的可能的情况
	private void setValids(char[][] board, Node[][] nodes) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					List<Character> chars = getValidChars(board, i, j);
					Node node = new Node();
					node.x = j;
					node.y = i;
					node.cs = chars;
					node.isFresh = false;
					nodes[i][j] = node;
				}
			}
		}
	}

	private List<Character> getValidChars(char[][] board, int y, int x) {
		// 从左到右的判定
		List<Character> valid = buildFullChars();
		char[] cs = board[y];
		for (char c : cs) {
			if (c != '.') {
				valid.remove(new Character(c));
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][x] != '.') {
				valid.remove(new Character(board[i][x]));
			}
		}

		int startX = x - x % 3;
		int endX = startX + 3;
		int startY = y - y % 3;
		int endY = startY + 3;

		for (int i = startY; i < endY; i++) {
			for (int j = startX; j < endX; j++) {
				if (board[i][j] != '.') {
					valid.remove(new Character(board[i][j]));
				}
			}
		}
		return valid;
	}

	private boolean isValidSudoku(char[][] board) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] == '.') {
					return false;
				}
			}
		}
		// 从左到右的判定
		for (int y = 0; y < board.length; y++) {
			Set<Character> cs = new HashSet<>();
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] != '.') {
					if (cs.contains(board[y][x])) {
						return false;
					}
					cs.add(board[y][x]);
				}
			}
		}

		for (int x = 0; x < board.length; x++) {
			Set<Character> cs = new HashSet<>();
			for (int y = 0; y < board.length; y++) {
				if (board[y][x] != '.') {
					if (cs.contains(board[y][x])) {
						return false;
					}
					cs.add(board[y][x]);
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
							if (cs.contains(board[i][j])) {
								return false;
							}
							cs.add(board[i][j]);
						}
					}
				}

			}
		}
		return true;
	}

	/**
	 * 刷新确定的值
	 * 
	 * @param board
	 * @param x
	 * @param y
	 */
	private void refresh(char[][] board, int x, int y, Node[][] nodes) {
		char target = board[y][x];
		Node[] nds = nodes[y];
		for (Node node : nds) {
			if (node != null) {
				node.cs.remove(new Character(target));
			}
		}

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i][x] != null) {
				nodes[i][x].cs.remove(new Character(target));
			}
		}

		int startX = x - x % 3;
		int endX = startX + 3;
		int startY = y - y % 3;
		int endY = startY + 3;

		for (int i = startY; i < endY; i++) {
			for (int j = startX; j < endX; j++) {
				if (nodes[i][j] != null) {
					nodes[i][j].cs.remove(new Character(target));
				}
			}
		}
		nodes[y][x].isFresh = true;
	}

	private List<Character> buildFullChars() {
		char[] cs = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		List<Character> set = new ArrayList<>();
		for (char c : cs) {
			set.add(c);
		}
		return set;
	}

	class Node {
		int x;
		int y;
		boolean isFresh = false;
		List<Character> cs = new ArrayList<>();

		@Override
		public String toString() {
			return "Node [" + (y + 1) + ", " + (x + 1) + "," + cs + "]";
		}
	}
}
