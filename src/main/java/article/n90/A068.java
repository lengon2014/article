package article.n90;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:
 * 
 * 单词是指由非空格字符组成的字符序列。 每个单词的长度大于 0，小于等于 maxWidth。 输入单词数组 words 至少包含一个单词。
 * 
 * @author lengon
 *
 */
public class A068 {

	public static void main(String args[]) {
		A068 a = new A068();
		String[] test = new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		System.out.println(a.fullJustify(test, 20));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {

		// 获得当前行的
		int currentSize = 0;
		int wordCount = 0;

		List<String> results = new ArrayList<>();
		List<String> curWords = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			currentSize += words[i].length();
			wordCount++;
			curWords.add(words[i]);
			// 判断后续一个是否可以放置， 如果可以。 那么加入一个空格
			if (i + 1 < words.length && words[i + 1].length() + 1 + currentSize <= maxWidth) {
				// 增加一个空格符
				currentSize++;
			} else {

				// 如果是最后一行。 那么每个单词后面新增一个空格
				if (i == words.length - 1) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < curWords.size(); j++) {
						String w = curWords.get(j);
						if (j != curWords.size() - 1) {
							sb.append(w).append(" ");
						} else {
							sb.append(w);
						}

					}

					int spaces = maxWidth - currentSize;
					// 最后一个位置如果已经超过了
					for (int j = 0; j < spaces; j++) {
						sb.append(" ");
					}
					results.add(sb.toString());
					break;
				}

				// 无法添加的情况， 总共的空格为当前的单词数-1和剩余的空间值
				int space = maxWidth - currentSize + wordCount - 1;

				// 如果出现了单词都大于行数的情况，直接设置空白为0
				if (space < 0) {
					space = 0;
				}
				// 将当前的剩余的空间进行插入数据
				int spaceSize = wordCount - 1;

				// 如果是只有一个单词的情况，增加一个最右侧的位置
				if (wordCount == 1) {
					spaceSize = 1;
				}
				int[] spaces = new int[spaceSize];
				for (int j = 0; j < space; j++) {
					spaces[j % (spaceSize)]++;
				}

				// 将对应的值进行拼接起来。
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < curWords.size(); j++) {
					sb.append(curWords.get(j));

					// 判断最后一个位置是否成立
					for (int k = 0; j < spaceSize && k < spaces[j]; k++) {
						sb.append(" ");
					}
				}

				results.add(sb.toString());

				// 重置当前的统计信息
				curWords.clear();
				currentSize = 0;
				wordCount = 0;
			}
		}
		return results;
	}
}
