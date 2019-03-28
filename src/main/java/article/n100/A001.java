package article.n100;

public class A001 {

	public static void main(String args[]) {
		int[] input = new int[] { 2, 11, 7, 15 };
		int target = 9;
		int[] result = buildIndex(input, target);
		System.out.println(ArrayUtils.buildInfo(result));
	}

	public static int[] buildIndex(int[] input, int target) {
		for(int i=0;i<input.length;i++) {
			for(int j=i+1;j<input.length+1;j++) {
				if(input[i]+input[j]==target){
					return new int[] {i+1,j+1};
				}
			}
		}
		
		return null;
	}
}
