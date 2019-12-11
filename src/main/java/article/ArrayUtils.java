package article;

public class ArrayUtils {

	public static String buildInfo(int[] input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			sb.append("index: ").append(i).append(" value: ").append(input[i]).append("\n");
		}
		return sb.toString();
	}

	public static String buildInfo(int[][] input) {
		StringBuilder sb = new StringBuilder();
		for(int m=0;m<input.length;m++) {
			sb.append("index: ").append(m).append(" values: ");
			int[] line=input[m];
			for(int i=0;i<line.length;i++) {
				sb.append(line[i]).append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
