package cn.gov.saic.wssq;

import java.io.File;
import java.util.List;

public class Search {
	public static void main(String args[]) {
		String s = args[0];
		File dir = new File("files");

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (File page : dir.listFiles()) {
			if (!page.isDirectory()) {
				continue;
			}
			for (String content : page.list()) {
				List<String> contents = FileUtils.read("files/" + page.getName(), content);
				for (String line : contents) {
					if (line.contains(s)) {
						sb.append("files/" + page.getName() + "/" + content + "\n                ---->" + line + "\n");
						count++;
						break;
					}
				}
			}
		}

		String c = String.valueOf(count + "\n");
		c = c + sb.toString();
		FileUtils.append("", s + ".txt", c);
	}
}
