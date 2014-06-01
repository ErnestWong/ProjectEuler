public class Problem12 {

	private static int findFactors(int n) {
		int cfactor = 1;
		int count = 0;
		while(cfactor <= n ){
			if(n % cfactor == 0) count++;
			
			cfactor++;
		}
		return count;
	}

	private static int findTriangleNumber() {
		int counter = 2;
		int triangleNum = 1;
		while (findFactors(triangleNum) < 500) {
			triangleNum = triangleNum + counter;
			counter++;
		}
		return triangleNum;

	}

	public static void main(String[] args) {
		System.out.println("First triangle number over 500 divisors is: "
				+ findTriangleNumber());
	}
}
