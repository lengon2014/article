package article.n100;

public class ArrayUtils {

	public static String buildInfo(int[] input) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length;i++) {
			sb.append("index: ").append(i).append(" value: ").append(input[i]).append("\n");
		}
		return sb.toString();
	}
}
