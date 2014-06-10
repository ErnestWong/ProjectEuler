//answer is 837799

public class Problem14{
    static void doproblem(){
		int maxCount = 0;
		int maxI = 0;
		
		for(int i = 13; i <= 1000000; i++){
			int length = collatzSequence(i);
			if(length > maxCount) {
				maxCount = length;
				maxI = i;
			}
		}
		
		System.out.println("The answer is: " + maxI + ", " + maxCount);
	}
	
	static int collatzSequence(long n){
		int count = 1;
		while(n != 1){
			if(n % 2 == 0) n = n / 2;
			else n = 3 * n + 1;
			
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args){
	    long startTime = System.nanoTime();
        doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
